package GO.pages.replay.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import GO.Constantes;
import GO.commandes.fermer_replay.FermerReplay;
import GO.commandes.fermer_replay.FermerReplayPourEnvoi;
import GO.commandes.precedent.Precedent;
import GO.commandes.precedent.PrecedentPourEnvoi;
import GO.commandes.suivant.Suivant;
import GO.commandes.suivant.SuivantPourEnvoi;
import GO.enumerations.Couleur;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import GO.pages.replay.composants.ConteneurGrilleRP;

public class VueReplay implements Vue, Initializable {

	@FXML
	private ConteneurGrilleRP conteneurGrilleRP;

	@FXML
	private Button suivant, quitter, precedant;

	private Button[][] cases;

	private SuivantPourEnvoi suivantPourEnvoi;
	private PrecedentPourEnvoi precedentPourEnvoi;
	private FermerReplayPourEnvoi fermerReplayPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(conteneurGrilleRP);
		DoitEtre.nonNul(suivant);
		DoitEtre.nonNul(precedant);
		DoitEtre.nonNul(quitter);
	}

	public void creerGrille(int cote) {
		J.appel(this);

		conteneurGrilleRP.creerGrille(cote);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		suivantPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Suivant.class);
		precedentPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(Precedent.class);
		fermerReplayPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(FermerReplay.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		suivant.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				suivantPourEnvoi.envoyerCommande();
				

			}
		});
		
		precedant.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				precedentPourEnvoi.envoyerCommande();
				

			}
		});
		
		quitter.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				fermerReplayPourEnvoi.envoyerCommande();
				

			}
		});
		

	}


	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherJeton(int indiceX, int indiceY, Couleur couleur, Boolean invisible) {
		J.appel(this);

		conteneurGrilleRP.afficherJeton(indiceX, indiceY, couleur, invisible);
	}

	
}
