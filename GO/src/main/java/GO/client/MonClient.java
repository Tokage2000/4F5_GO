package GO.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.systeme.Systeme;
import GO.client.MonClient;
import GO.client.MonClientWebSocket;
import GO.pages.accueil.ControleurAccueil;
import GO.pages.accueil.VueAccueil;

import static GO.Constantes.*;
import static GO.Constantes.ADRESSE_SERVEUR;

import java.net.URI;
import java.net.URISyntaxException;

public class MonClient extends Application {
	
	static {
		Initialisateur.initialiser();
		J.appel(MonClient.class);
	}
	
	private static MonClientWebSocket clientWebSocket;

	
	public static void main(String[] args) {
		J.appel(MonClient.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		DialogueModal.enregistreFenetrePrincipale(fenetrePrincipale);
		
		connecterAuServeur();
		
		Scene scene = instancierControleurAccueil();

		fenetrePrincipale.setScene(scene);

		ajusterTailles(fenetrePrincipale, scene);
		
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

	private Scene instancierControleurAccueil() {
		J.appel(this);

		ChargeurDeVue<VueAccueil> chargeur;
		chargeur = new ChargeurDeVue<VueAccueil>(CHEMIN_PRINCIPAL_FXML, CHEMIN_PARTIE_LOCALE_CSS, CHEMIN_CHAINES_FRANCAIS);

		VueAccueil vue = chargeur.getVue();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurAccueil.class, vue);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS );
		return scene;
	}

	private void ajusterTailles(Stage fenetrePrincipale, Scene scene) {
		J.appel(this);

		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS_MIN);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS_MIN);

		fenetrePrincipale.setWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setHeight(HAUTEUR_PIXELS);
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

		clientWebSocket = new MonClientWebSocket(uriServeur);
		
		Erreur.avertissement("Tentative de connexion au serveur... ");
		
		try {

			clientWebSocket.connectBlocking();

		} catch (InterruptedException e) {
			
			Erreur.nonFatale("Tentative de connexion annulée", e);
		}
	}
	
	public static boolean siConnecteAuServeur() {
		J.appel(MonClient.class);
		
		return clientWebSocket != null && clientWebSocket.isOpen();
	}
	
}
