package GO.pages.REPLAY.vues;

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

public class VueReplay implements Vue, Initializable {

	@FXML
	private VBox conteneurGrille;

	@FXML
	private Button suivant, quitter, precedant;

	private Button[][] cases;

	private SuivantPourEnvoi suivantPourEnvoi;
	private PrecedentPourEnvoi precedentPourEnvoi;
	private FermerReplayPourEnvoi fermerReplayPourEnvoi;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);

		DoitEtre.nonNul(conteneurGrille);
		DoitEtre.nonNul(suivant);
		DoitEtre.nonNul(quitter);
	}

	public void creerGrille(int cote) {
		J.appel(this);

		creerColonnes(cote);
	}

	private void creerColonnes(int cote) {
		J.appel(this);

		cases = new Button[cote][cote];

		for (int indiceRangee = 0; indiceRangee < cote; indiceRangee++) {
			HBox ligne = creerLigne(indiceRangee, cote);

			conteneurGrille.getChildren().add(ligne);
		}
	}

	private HBox creerLigne(int indiceRangee, int largeur) {
		J.appel(this);

		HBox ligne = new HBox();

		for (int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {

			Button _case = new Button();

			_case.setMinWidth(Constantes.TAILLE_CASE);
			_case.setMaxWidth(Constantes.TAILLE_CASE);

			cases[indiceColonne][indiceRangee] = _case;
			
			
			ligne.getChildren().add(_case);
		}

		return ligne;
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

	private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
		J.appel(this);

		boolean siValide = false;
		
		if(indiceColonne >= 0 && indiceColonne < cases.length) {
			siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
		}
		
		return siValide;
	}
	//TODO trouver une façon de faire en sorte que les cases ne soit pas laides.
	public void afficherJeton(int indiceRangee, int indiceColonne, Couleur couleur) {
		J.appel(this);
		
		if(siIndicesValides(indiceRangee, indiceColonne)) {

			Button _case = cases[indiceRangee][indiceColonne];
			switch(couleur) {
				case BLANC:
					_case.setStyle("-fx-background-color: white");
					break;

				case NOIR:
					_case.setStyle("-fx-background-color: black");
					break;
			}
		}
	}

	@Override
	public void verifierCommandesPossibles() {
		
	}

	public void clearTable() {
		
		for(int x = 0; x < cases.length; x++) {
			for(int y = 0; y < cases[x].length; y++) {
				
				Button _case = cases[x][y];
				_case.setStyle("-fx-border-color: white; -fx-border-width: .17;");
			}
		}
		
	}
}
