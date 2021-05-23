package GO.pages.parametres;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

import static GO.Constantes.*;

import java.net.URI;
import java.net.URISyntaxException;


import GO.client.MonClientWebSocket;

public class PageParametres extends Application {
//public static final String[] IDS_MODELES_TESTS = {"test01","test02","test03"};
	static {
		Initialisateur.initialiser();
		
		J.appel(PageParametres.class);
	}
	
	public static void main(String[] args) {
		J.appel(PageParametres.class);
		launch(args);
	}
	
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		connecterAuServeur();
		
		ChargeurDeVue<VueParametres> chargeur;
		chargeur = new ChargeurDeVue<VueParametres>(CHEMIN_PARAMETRES_FXML, CHEMIN_PARAMETRES_CSS,
				CHEMIN_CHAINES);

		VueParametres vue = chargeur.getVue();
		
		Parametres parametres = EntrepotDeModeles.creerModele(Parametres.class, ID_MODELE_PAR_DEFAUT);
		
		AfficheurParametres afficheurParametres = new AfficheurParametres();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurParametres.class, parametres, vue, afficheurParametres);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);
		
		capterEvenementFermeture(fenetrePrincipale);

		fenetrePrincipale.show();
	}
	
	private void capterEvenementFermeture(Stage fenetrePrincipale) {
		J.appel(this);
		
		fenetrePrincipale.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				J.appel(this);

				Systeme.quitter();
			}
		});
	}
	

	private void connecterAuServeur() {
		J.appel(this);

		URI uriServeur = null;
		
		try {

			uriServeur = new URI(ADRESSE_SERVEUR);

		} catch (URISyntaxException e) {
			
			Erreur.fatale("L'adresse du serveur est mal formée: " + ADRESSE_SERVEUR, e);
		}

		connecterAuServeur(uriServeur);
	}
	
	private void connecterAuServeur(URI uriServeur) {
		J.appel(this);

		MonClientWebSocket clientWebSocket = new MonClientWebSocket(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			clientWebSocket.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
}