
package GO.pages.resultats.vues;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
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
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import static GO.Constantes.*;

public class VueResultats implements Vue, Initializable {
	private FermerResultatsPourEnvoi fermerResultats;
	private QuitterPourEnvoi fermerJeux;
	
	@FXML
	private Button quitter,accueil;

	// private FermerParametresPourEnvoi fermerParamatres;
	// private ChoisirTailleGrillePourEnvoi choisirTailleGrille;

	@FXML
	private VBox conteneurResultats;

	@FXML
	private Text blanc,noir,verdicte,taille;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(quitter);
		DoitEtre.nonNul(accueil);
		DoitEtre.nonNul(blanc);
		

	}
	
	
	public void setTexte(String blancs, String noirs, int Taille) {
		blanc.setText(blancs);
		noir.setText(noirs);
		
		 float b,n;
		 b = Float.parseFloat(blancs);
		 n = Float.parseFloat(noirs);
		 
		 if (b>n) {
			
			 verdicte.setText(" Blanc");
		 } else if (n>b) {
			 verdicte.setText(" Noir");
		 }
		 
		 taille.setText("" + Taille + " * " + Taille);
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
