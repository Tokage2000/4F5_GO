package GO.pages.partie.composants;

import ntro.debogage.J;

import java.util.ArrayList;
import java.util.List;

import GO.Constantes;
import GO.enumerations.Couleur;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ConteneurLigne extends HBox {
	
	private int indiceY;
	

	public ConteneurLigne(int largeur, int indiceY, Color couleurNoir, Color couleurBlanc) {
		J.appel(this);
		
		this.indiceY = indiceY;
		
		this.getStyleClass().add("conteneurLigne");

		VBox.setVgrow(this, Priority.ALWAYS);
		
        for(int indiceX = 0; indiceX < largeur; indiceX++) {
        	
			CaseAjustable caseAjustable = new CaseAjustable(couleurNoir, couleurBlanc, indiceX, indiceY);
			
			caseAjustable.getStyleClass().add("conteneurCase");
			
			
			HBox.setHgrow(caseAjustable, Priority.ALWAYS);
			
			this.getChildren().add(caseAjustable);
		}
	}
	

	public void afficherJeton(int indiceColonne, Couleur couleur) {
		J.appel(this);
		
		if(siIndiceColonneValide(indiceColonne)) {

			CaseAjustable caseAjustable = getCase(indiceColonne);
			caseAjustable.afficherJeton(couleur);
		}
	}

	private CaseAjustable getCase(int indiceColonne) {
		J.appel(this);

		return (CaseAjustable) this.getChildren().get(indiceColonne);
	}

	private boolean siIndiceColonneValide(int indiceColonne) {
		J.appel(this);

		return indiceColonne < this.getChildren().size();
	}
	
    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);

        for(CaseAjustable caseAjustable : caseAjustable()) {
            
        	caseAjustable.obtenirJouerIciPourEnvoi();
        }
    }
    
    public void installerCapteursJouerIci() {
        J.appel(this);
        
        for(CaseAjustable caseAjustable : caseAjustable()) {
            
        	
        	caseAjustable.installerCapteurJouerIci();
        }
    }
    
    private List<CaseAjustable> caseAjustable(){
        J.appel(this);
        
        List<CaseAjustable> caseAjustable = new ArrayList<>();
        
        for(Node enfant : this.getChildren()) {
            
        	caseAjustable.add((CaseAjustable) enfant);
        }

        return caseAjustable;
    }
}
