
package GO.pages.resultats;



import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import GO.commandes.fermer_resultats.FermerResultatsPourEnvoi;
import GO.commandes.quitter.Quitter;
import GO.commandes.quitter.QuitterPourEnvoi;
import GO.commandes.fermer_resultats.FermerResultats;
import GO.enumerations.Couleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

public class VueResultats implements Vue, Initializable {
	private FermerResultatsPourEnvoi fermerResultats;
	private QuitterPourEnvoi fermerJeux;
	
	@FXML
	private Button quitter,accueil;

	// private FermerParametresPourEnvoi fermerParamatres;
	// private ChoisirTailleGrillePourEnvoi choisirTailleGrille;

	@FXML
	private ComboBox<String> choixTaille;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		DoitEtre.nonNul(quitter);
		DoitEtre.nonNul(accueil);
		

		J.appel(this);

	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		fermerResultats = FabriqueCommande.obtenirCommandePourEnvoi(FermerResultats.class);
		fermerJeux = FabriqueCommande.obtenirCommandePourEnvoi(Quitter.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		accueil.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerResultats.envoyerCommande();
			}
		});
		
		quitter.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerJeux.envoyerCommande();
			}
		});

	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

}
