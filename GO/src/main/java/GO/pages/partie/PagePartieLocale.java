package GO.pages.partie;

import static GO.Constantes.IDS_MODELES_TESTS;

import java.util.Random;

import GO.pages.partie.modeles.JetonLectureSeule;
import GO.pages.partie.modeles.PartieLocale;
import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.Initialisateur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;


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
		
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);
		
		
		
		J.valeurs(partie.getId(), partie.getTaille());
		
		
			
		for(int i = 0; i < partie.getTable().getJetons().size(); i++) {
			
			
			JetonLectureSeule jeton = partie.getTable().getJetons().get(i);

				J.valeurs(jeton.getIndiceX(), jeton.getIndiceY(), jeton.getCouleur().name());
		}

		Systeme.quitter();
	}
}
