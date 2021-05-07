package GO.pages.accueil;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.mvc.Vue;
import GO.commandes.nouvelle_partie_reseau.NouvellePartieReseau;
import GO.commandes.nouvelle_partie_reseau.NouvellePartieReseauPourEnvoi;
import GO.pages.partie.vues.VuePartieReseau;
import GO.commandes.nouvelle_partie.NouvellePartieLocale;
import GO.commandes.nouvelle_partie.NouvellePartieLocalePourEnvoi;
import GO.commandes.ouvrir_parametres.OuvrirParametres;
import GO.commandes.ouvrir_parametres.OuvrirParametresPourEnvoi;
import GO.commandes.ouvrir_replay.OuvrirReplay;
import GO.commandes.ouvrir_replay.OuvrirReplayPourEnvoi;
import GO.commandes.ouvrir_resultats.OuvrirResultats;
import GO.commandes.ouvrir_resultats.OuvrirResultatsPourEnvoi;
import GO.commandes.quitter.Quitter;
import GO.commandes.quitter.QuitterPourEnvoi;
import GO.pages.partie.vues.VuePartieLocale;
import GO.pages.resultats.vues.VueResultats;

import static GO.Constantes.*;
import static GO.Constantes.CHEMIN_PARTIE_LOCALE_FXML;
import static GO.Constantes.CHEMIN_CHAINES;
import static GO.Constantes.CHEMIN_PARTIE_RESEAU_CSS;
import static GO.Constantes.CHEMIN_PARTIE_RESEAU_FXML;

public class VueAccueil implements Vue, Initializable {
	
	@FXML
	private MenuItem menuNouvellePartieLocale, menuNouvellePartieReseau, menuParametres, menuResultats, menuReplay, menuQuitter;
	
	@FXML
	private VBox conteneurPartie;
	
	private NouvellePartieLocalePourEnvoi nouvellePartieLocalePourEnvoi;
	private NouvellePartieReseauPourEnvoi nouvellePartieReseauPourEnvoi;
	private OuvrirParametresPourEnvoi ouvrirParametresPourEnvoi;
	private OuvrirResultatsPourEnvoi ouvrirResultatsPourEnvoi;
	private OuvrirReplayPourEnvoi ouvrirReplayPourEnvoi;
	private QuitterPourEnvoi quitterPourEnvoi;
	
	private String messageAlerteConnexion;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(menuNouvellePartieLocale);
		DoitEtre.nonNul(menuNouvellePartieReseau);
		DoitEtre.nonNul(menuParametres);
		DoitEtre.nonNul(menuResultats);
		DoitEtre.nonNul(menuReplay);
		DoitEtre.nonNul(menuQuitter);
		
		messageAlerteConnexion = "Aucune connexion au serveur";
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		nouvellePartieLocalePourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieLocale.class);
		nouvellePartieReseauPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(NouvellePartieReseau.class);
		ouvrirParametresPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirParametres.class);
		ouvrirResultatsPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirResultats.class);
		ouvrirReplayPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(OuvrirReplay.class);
		quitterPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		menuNouvellePartieLocale.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartieLocalePourEnvoi.envoyerCommande();
			}
		});
		
		menuNouvellePartieReseau.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				nouvellePartieReseauPourEnvoi.envoyerCommande();
			}
		});

		menuParametres.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirParametresPourEnvoi.envoyerCommande();
			}
		});
	
		menuResultats.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirResultatsPourEnvoi.envoyerCommande();
			}
		});

		menuReplay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				ouvrirReplayPourEnvoi.envoyerCommande();
			}
		});

		menuQuitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				quitterPourEnvoi.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public VuePartieLocale creerVuePartieLocale() {
		J.appel(this);

		ChargeurDeVue<VuePartieLocale> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML, CHEMIN_PARTIE_LOCALE_CSS, CHEMIN_CHAINES_FRANCAIS);

		VuePartieLocale vuePartieLocale = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieLocale;
	}
	
	public VuePartieReseau creerVuePartieReseau() {
		J.appel(this);

		ChargeurDeVue<VuePartieReseau> chargeur;
		chargeur = new ChargeurDeVue<VuePartieReseau>(CHEMIN_PARTIE_RESEAU_FXML,
				                              		  CHEMIN_PARTIE_RESEAU_CSS,
				                              		CHEMIN_CHAINES_FRANCAIS);
		
		VuePartieReseau vuePartieReseau = chargeur.getVue();
		
		Parent parent = chargeur.getParent();
		
		conteneurPartie.getChildren().clear();
		conteneurPartie.getChildren().add(parent);
		
		return vuePartieReseau;
	}



	public void alerterErreurConnexion() {
		J.appel(this);

		new Alert(AlertType.ERROR, messageAlerteConnexion).show();
	}

}
