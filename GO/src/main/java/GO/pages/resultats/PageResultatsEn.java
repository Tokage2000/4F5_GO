package GO.pages.resultats;

import java.util.Random;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;
import GO.pages.parametres.AfficheurParametres;
import GO.pages.parametres.ControleurParametres;
import GO.pages.parametres.Parametres;
import GO.pages.parametres.VueParametres;
import GO.pages.resultats.afficheurs.AfficheurResultats;
import GO.pages.resultats.controleurs.ControleurResultats;
import GO.pages.resultats.modeles.Resultats;
import GO.pages.resultats.vues.VueResultats;

import static GO.Constantes.*;

public class PageResultatsEn extends Application {

	static {
		Initialisateur.initialiser();

		J.appel(PageResultatsEn.class);
	}

	public static void main(String[] args) {
		J.appel(PageResultatsEn.class);
		launch(args);
	}

	private Random alea = new Random();

	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		ChargeurDeVue<VueResultats> chargeur;
		chargeur = new ChargeurDeVue<VueResultats>(CHEMIN_RESULTATS_FXML,CHEMIN_RESULTATS_CSS, CHEMIN_CHAINES_ANGLAIS);

		VueResultats vue = chargeur.getVue();
		
		Resultats resultats = EntrepotDeModeles.creerModele(Resultats.class, ID_MODELE_PAR_DEFAUT);
		
		AfficheurResultats afficheurResultats = new AfficheurResultats();
		
		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurResultats.class, resultats, vue, afficheurResultats);

		Scene scene = chargeur.nouvelleScene(LARGEUR_PARAMETRES_PIXELS_MIN, LARGEUR_PARAMETRES_PIXELS_MAX);

		fenetrePrincipale.setScene(scene);
		
		fenetrePrincipale.setMinWidth(LARGEUR_PARAMETRES_PIXELS_MIN);
		fenetrePrincipale.setMinHeight(LARGEUR_PARAMETRES_PIXELS_MAX);
		
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

}
