package GO.pages.partie.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import GO.commandes.jouer_ici.JouerIciPourEnvoi;
import GO.enumerations.Couleur;
import GO.commandes.jouer_ici.JouerIci;
import GO.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;

public abstract class VuePartie implements Vue, Initializable {


    @FXML
    private VBox conteneurGrille;
    
    private Button[][] cases;
    
	private JouerIciPourEnvoi jouerIciPourEnvoi;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurGrille);
	} 

    public void creerTable(int taille) {
        J.appel(this);

        
        creerColonnes(taille);
    }

    private void creerColonnes(int taille) {
        J.appel(this);
        
        cases = new Button[taille][taille];

        for(int indiceRangee = 0; indiceRangee < taille; indiceRangee++) {
        	HBox ligne = creerLigne(indiceRangee, taille);
        	
        	conteneurGrille.getChildren().add(ligne);
        }
    }

    private HBox creerLigne(int indiceRangee, int largeur) {
        J.appel(this);
        
        HBox ligne = new HBox();
        
        for(int indiceColonne = 0; indiceColonne < largeur; indiceColonne++) {
        	
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
		
		jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
		
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		for(int x = 0; x < cases.length; x++) {
			for(int y = 0; y < cases[x].length; y++) {
				
				final int indiceX = x;
				final int indiceY = y;
				
				cases[x][y].setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						J.appel(this);
						
						if(true){
							jouerIciPourEnvoi.setIndiceJeton(indiceX, indiceY);
							jouerIciPourEnvoi.envoyerCommande();
				}
						
					}
				});
			}
		}
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
		
		
			
		
	} 
	
	private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
		J.appel(this);

		boolean siValide = false;
		
		if(indiceColonne >= 0 && indiceColonne < cases.length) {
			siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
		}
		
		return siValide;
	}

	public void afficherJeton(int indiceRangee, int indiceColonne, Couleur couleur) {
		J.appel(this);
		
		if(siIndicesValides(indiceRangee, indiceColonne)) {

			Button _case = cases[indiceRangee][indiceColonne];
			switch(couleur) {
				case BLANC:
					_case.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
					break;

				case NOIR:
					_case.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
					break;
			}
		}
	}

}
