package GO.pages.replay;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import GO.pages.replay.controleurs.ControleurReplay;

import static GO.Constantes.*;

import java.util.Random;

import GO.pages.replay.afficheurs.AfficheurReplay;
import GO.pages.replay.modeles.Replay;
import GO.pages.replay.vues.VueReplay;

public class PageReplay extends Application {

	static {

		Initialisateur.initialiser();

		J.appel(PageReplay.class);
	}

	private Random alea = new Random();

	public static void main(String[] args) {
		J.appel(PageReplay.class);
		launch(args);
	}

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		ChargeurDeVue<VueReplay> chargeur;

		chargeur = new ChargeurDeVue<VueReplay>(CHEMIN_REPLAY_FXML, CHEMIN_REPLAY_CSS, CHEMIN_CHAINES_FRANCAIS);

		VueReplay vue = chargeur.getVue();

		Replay replay = EntrepotDeModeles.creerModele(Replay.class, ID_MODELE_PAR_DEFAUT);

		AfficheurReplay afficheur = new AfficheurReplay();

		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurReplay.class, replay, vue, afficheur);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);

		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();

	}
}
