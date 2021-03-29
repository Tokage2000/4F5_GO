package GO.pages.partie;

import static GO.Constantes.CHEMIN_PARTIE_LOCALE_FXML;
import static GO.Constantes.HAUTEUR_PIXELS;
import static GO.Constantes.LARGEUR_PIXELS;
import static GO.Constantes.CHEMIN_PARTIE_LOCALE_FXML;
import static GO.Constantes.HAUTEUR_PIXELS;
import static GO.Constantes.ID_MODELE_PAR_DEFAUT;
import static GO.Constantes.LARGEUR_PIXELS;

import java.util.Random;

import GO.pages.partie.modeles.JetonLectureSeule;
import GO.pages.partie.modeles.PartieLocale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;
import GO.pages.partie.afficheurs.AfficheurPartieLocale;
import GO.pages.partie.controleurs.ControleurPartieLocale;
import GO.pages.partie.vues.VuePartieLocale;


public class PagePartieLocale extends Application {

	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartieLocale.class);
	}

	private Random alea = new Random();
	
	public static void main(String[] args) {
		J.appel(PagePartieLocale.class);
		launch(args);
	}
	
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VuePartieLocale> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML);

		VuePartieLocale vue = chargeur.getVue();
		
		PartieLocale partie = EntrepotDeModeles.creerModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);
		
		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurPartieLocale.class, partie, vue, afficheur);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PIXELS, HAUTEUR_PIXELS);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PIXELS);
		fenetrePrincipale.setMinHeight(HAUTEUR_PIXELS);

		fenetrePrincipale.show();
	}
}
