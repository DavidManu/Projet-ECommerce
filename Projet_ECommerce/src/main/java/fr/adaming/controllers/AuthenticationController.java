package fr.adaming.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import fr.adaming.model.Categorie;
import fr.adaming.model.Client;
import fr.adaming.model.LigneCommande;
import fr.adaming.model.Panier;
import fr.adaming.model.Produit;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.ILigneCommandeService;
import fr.adaming.service.IProduitService;

@Controller
@RequestMapping("/authentication")
public class AuthenticationController {

	@Autowired
	private IProduitService produitService;

	@Autowired
	private ICategorieService categorieService;

	@Autowired
	private ILigneCommandeService ligneCommandeService;

	Panier monPanier = new Panier();

	/**
	 * @return the monPanier bla
	 */
	public Panier getMonPanier() {
		return monPanier;
	}

	/**
	 * @param monPanier
	 *            the monPanier to set
	 */
	public void setMonPanier(Panier monPanier) {
		this.monPanier = monPanier;
	}

	/**
	 * @return the produitService
	 */
	public IProduitService getProduitService() {
		return produitService;
	}

	/**
	 * @param produitService
	 *            the produitService to set
	 */
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	/**
	 * @return the categorieService
	 */
	public ICategorieService getCategorieService() {
		return categorieService;
	}

	/**
	 * @param categorieService
	 *            the categorieService to set
	 */
	public void setCategorieService(ICategorieService categorieService) {
		this.categorieService = categorieService;
	}

	/**
	 * @return the ligneCommandeService
	 */
	public ILigneCommandeService getLigneCommandeService() {
		return ligneCommandeService;
	}

	/**
	 * @param ligneCommandeService
	 *            the ligneCommandeService to set
	 */
	public void setLigneCommandeService(ILigneCommandeService ligneCommandeService) {
		this.ligneCommandeService = ligneCommandeService;
	}

	/**
	 * @return the pService
	 */
	@RequestMapping(method = RequestMethod.GET) // value="/welcome",
	public String goToWelcomePage(ModelMap model, SessionStatus sessionStatus) {
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());
		// model.addAttribute("mIdProduit", new Integer(int));
		// new ModelAndView("welcome", "mLigneCommande", new LigneCommande());
		return "welcome";
	}

	@RequestMapping(value = "/ajouterLigneCommande/{idP}")
	public String addLigneCommande(ModelMap model, @PathVariable("idP") long pId) {
		Produit p_rec = produitService.getOneProduit(pId);

		LigneCommande lc_rec = new LigneCommande();
		lc_rec.setProduit(p_rec);
		lc_rec.setPrix((int) p_rec.getPrix());
		lc_rec.setQuantite(1);

		boolean rep = false;
		for (LigneCommande lc : monPanier.getListLigneCommandes()) {

			if (lc.getProduit().getIdProduit() == pId) {
				rep = true;
				if (lc.getQuantite() < produitService.getOneProduit(pId).getQuantite()) {
					lc.setQuantite(lc.getQuantite() + 1);
					monPanier.setTotal(monPanier.getTotal() + p_rec.getPrix());
				}
			}
		}
		if (rep == false) {
			monPanier.getListLigneCommandes().add(lc_rec);
			monPanier.setTotal(monPanier.getTotal() + p_rec.getPrix());
		}
		// ligneCommandeService.createLigneCommande(lc_rec);

		// reload infos
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());

		return "welcome";
	}

	@RequestMapping(value = "/supprimerLigneCommande/{idDes}")
	public String deleteLigneCommande(ModelMap model, @PathVariable("idDes") String lcDes) {
		List<LigneCommande> lcremove = new ArrayList<>();
		for (LigneCommande lc : monPanier.getListLigneCommandes()) {
			if (lc.getProduit().getDesignation().equals(lcDes)) {
				int a = lc.getQuantite() - 1;
				lc.setQuantite(a);
				double d = monPanier.getTotal() - lc.getProduit().getPrix();
				monPanier.setTotal(d);
				if (lc.getQuantite() == 0) {
					lcremove.add(lc);
				}
			}
		}

		monPanier.getListLigneCommandes().removeAll(lcremove);
		// reload infos
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());

		return "welcome";
	}

	@RequestMapping(value = "/validerCommande", method = RequestMethod.GET)
	public ModelAndView validateCommande(ModelMap model) {
		// reload infos
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());
		return new ModelAndView("validation", "mClient", new Client());
	}

	// public String getByKeyWord(ModelMap model, @Valid
	// @ModelAttribute("mProduit") Produit pClient, BindingResult result)

	// method pour soumettre le formulaire
	@RequestMapping(value = "/validerCommande/validation", method = RequestMethod.POST)
	public String envoyerPdf(ModelMap model, @Valid @ModelAttribute("mClient") Client pClient, BindingResult result) {

		// generation du pdf

		try {
//			File file = new File("C:\\Users\\INTI-0364\\Desktop\\facture.pdf");
//			file.createNewFile();
			Document document = new Document(PageSize.A4, 50, 50, 50, 50);
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("C:\\Users\\INTI-0364\\Desktop\\facture.pdf"));
			document.open();
			Anchor anchorTarget = new Anchor("Votre facture.");
			anchorTarget.setName("BackToTop");
			Paragraph paragraph1 = new Paragraph();

			paragraph1.setSpacingBefore(50);

			paragraph1.add(anchorTarget);
			document.add(paragraph1);

			document.add(new Paragraph("Nous vous remercions de nous avoir choisi.",
					FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD, new CMYKColor(0, 255, 0, 0))));
			
			// a table with three columns
	        PdfPTable table = new PdfPTable(3);
	        // the cell object
	        PdfPCell cell;
	        // we add a cell with colspan 3
	        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
	        cell.setColspan(3);
	        table.addCell(cell);
	        // now we add a cell with rowspan 2
	        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
	        cell.setRowspan(2);
	        table.addCell(cell);
	        // we add the four remaining cells with addCell()
	        table.addCell("row 1; cell 1");
	        table.addCell("row 1; cell 2");
	        table.addCell("row 2; cell 1");
	        table.addCell("row 2; cell 2");

			document.close();
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (result.hasErrors()) {
			return "ajouter";
		} else {

			String host = "smtp.gmail.com";
			String from = "emmanuel.lilette@gmail.com";
			Properties props = System.getProperties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.user", from);
			props.put("mail.smtp.password", "9klmstpbgh93!!");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			try {
				Session session = Session.getDefaultInstance(props, null);
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipients(Message.RecipientType.TO, pClient.getEmail());
				message.setSubject("confirmation de votre commande");
				// message.setText("Bonjour Mr/Mme "+pClient.getNomClient()+"
				// nous confirmaons l'envoi de votre commande sous 24h au
				// "+pClient.getAdresse()+". Veuillez rester joignable au
				// "+pClient.getTel());

				String filename = "C:/Users/INTI-0364/Desktop/facture.pdf";

				BodyPart messageBodyPart = new MimeBodyPart();

				messageBodyPart.setText("Bonjour Mr/Mme " + pClient.getNomClient()
						+ " nous confirmaons l'envoi de votre commande sous 24h au " + pClient.getAdresse()
						+ ". Veuillez rester joignable au " + pClient.getTel()+". Votre facture est jointe à ce mail.");

				Multipart multipart = new MimeMultipart();

				multipart.addBodyPart(messageBodyPart);

				messageBodyPart = new MimeBodyPart();

				DataSource source = new FileDataSource(filename);

				messageBodyPart.setDataHandler(new DataHandler(source));

				messageBodyPart.setFileName(filename);

				multipart.addBodyPart(messageBodyPart);

				message.setContent(multipart);

				Transport transport = session.getTransport("smtp");
				transport.connect("smtp.gmail.com", "emmanuel.lilette@gmail.com", "9klmstpbgh93!!");
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();
			} catch (MessagingException e) {
				e.printStackTrace();
			}

			// if(pClient.getIdClient()==0){
			// pClient.addPersonne(pClient);
			// }else{
			// pClient.updatePersonne(pClient);
		}

		// model.addAttribute("pListe", pService.getAllPersonne());

		for (LigneCommande lc : monPanier.getListLigneCommandes()) {
			long id = lc.getProduit().getIdProduit();
			Produit p = produitService.getOneProduit(id);
			p.setQuantite(p.getQuantite() - lc.getQuantite());
			produitService.updateProduit(p);
		}
		monPanier.getListLigneCommandes().clear();
		monPanier.setTotal(0);

		// reload infos
		List<Produit> listeProduits = produitService.getAllProduit();
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());

		return "merci";
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping(value = "/produitsByCat/{idP}")
    public String produitsByCat(@PathVariable("idP") long idCat, ModelMap model) {
		// reload infos
		List<Produit> listeProduits = produitService.getProduitsParCategorie(idCat);
		model.addAttribute("pListe", listeProduits);
		List<Categorie> listeCategories = categorieService.getAllCategorie();
		model.addAttribute("cListe", listeCategories);
		// List<LigneCommande> listeLigneCommandes =
		// monPanier.getListLigneCommandes();
		model.addAttribute("lcListe", monPanier.getListLigneCommandes());
		model.addAttribute("panierTot", monPanier.getTotal());
        return "welcome";
    }

	@RequestMapping(value = "/adminCatProd/adminCatProdPage", method = RequestMethod.GET)
	public String goToAdminCatProdPage(ModelMap model) {
		// Récuperer l'admin cat qui vient de se connecter
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nom = auth.getName();
		model.addAttribute("nomAdminCatProd", nom);
		model.addAttribute("msg",
				"Bonjour Mr. l'administrateur vous avez les droits d'édition des catégories et des produit");
		return "adminCatProd";
	}

	@RequestMapping(value = "/adminProd/adminProdPage", method = RequestMethod.GET)
	public String affichePageUser(ModelMap model) {
		// Récuperer l'admin prod qui vient de se connecter
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String nom = auth.getName();
		model.addAttribute("nomAdminProd", nom);
		model.addAttribute("msg", "Bonjour Mr. l'administrateur vous avez le droit d'édition des produit");
		return "adminProd";
	}
}
