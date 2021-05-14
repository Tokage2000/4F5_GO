package GO.pages.replay.composants;

import ntro.debogage.J;
import GO.pages.replay.composants.CaseAjustableRP;

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

public class ConteneurLigneRP extends HBox {
	
	private int indiceY;
	

	public ConteneurLigneRP(int largeur, int indiceY, Color couleurNoir, Color couleurBlanc) {
		J.appel(this);
		
		this.indiceY = indiceY;
		
		this.getStyleClass().add("conteneurLigne");

		VBox.setVgrow(this, Priority.ALWAYS);
		
        for(int indiceX = 0; indiceX < largeur; indiceX++) {
        	
			CaseAjustableRP caseAjustable = new CaseAjustableRP(couleurNoir, couleurBlanc, indiceX, indiceY);
			
			caseAjustable.getStyleClass().add("conteneurCase");
			
			
			HBox.setHgrow(caseAjustable, Priority.ALWAYS);
			
			this.getChildren().add(caseAjustable);
		}
	}
	

	public void afficherJeton(int indiceColonne, Couleur couleur, boolean invisible) {
		J.appel(this);
		
		if(siIndiceColonneValide(indiceColonne)) {

			CaseAjustableRP caseAjustable = getCase(indiceColonne);
			caseAjustable.afficherJeton(couleur, invisible);
		}
	}

	private CaseAjustableRP getCase(int indiceColonne) {
		J.appel(this);

		return (CaseAjustableRP) this.getChildren().get(indiceColonne);
	}

	private boolean siIndiceColonneValide(int indiceColonne) {
		J.appel(this);

		return indiceColonne < this.getChildren().size();
	}
	
    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);

        for(CaseAjustableRP caseAjustable : caseAjustable()) {
            
        	caseAjustable.obtenirJouerIciPourEnvoi();
        }
    }
    
    public void installerCapteursJouerIci() {
        J.appel(this);
        
        for(CaseAjustableRP caseAjustable : caseAjustable()) {
            
        	
        	caseAjustable.installerCapteurJouerIci();
        }
    }
    
    private List<CaseAjustableRP> caseAjustable(){
        J.appel(this);
        
        List<CaseAjustableRP> caseAjustable = new ArrayList<>();
        
        for(Node enfant : this.getChildren()) {
            
        	caseAjustable.add((CaseAjustableRP) enfant);
        }

        return caseAjustable;
    }
    
    public void animerEntreeJeton(int indiceColonne) {
        J.appel(this);

        if(siIndiceColonneValide(indiceColonne)) {

            CaseAjustableRP caseAjustable = getCase(indiceColonne);
            caseAjustable.animerEntreeJeton();
        }
    }
}
