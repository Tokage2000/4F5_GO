package GO.pages.partie.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import GO.commandes.jouer_ici.JouerIciPourEnvoi;
import GO.enumerations.Couleur;
import GO.pages.partie.composants.ConteneurGrille;
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
    private ConteneurGrille conteneurGrille;
    
    private Button[][] cases;
    


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(conteneurGrille);
	} 

    public void creerTable(int taille) {
        J.appel(this);

        
        conteneurGrille.creerGrille(taille);
    }

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);

		conteneurGrille.obtenirJouerIciPourEnvoi();

	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		conteneurGrille.installerCapteursJouerIci();
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherJeton(int indiceX, int indiceY, Couleur couleur) {
		J.appel(this);

		conteneurGrille.afficherJeton(indiceX, indiceY, couleur);
	}
	
	public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
		J.appel(this);
		
		conteneurGrille.animerEntreeJeton(indiceColonne, indiceRangee);
	}

}
