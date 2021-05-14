package GO.pages.replay.composants;

import ntro.debogage.J;
import GO.pages.replay.composants.ConteneurLigneRP;

import java.util.ArrayList;
import java.util.List;

import GO.Constantes;
import GO.enumerations.Couleur;
import javafx.beans.NamedArg;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ConteneurGrilleRP extends VBox {
    
    private Color couleurNoir;
    private Color couleurBlanc;
    
    public ConteneurGrilleRP(@NamedArg("couleurNoir") String couleurNoir, 
    		               @NamedArg("couleurBlanc") String couleurBlanc) {
        super();
        J.appel(this);

        if(couleurNoir != null && !couleurNoir.isEmpty()) {
            this.couleurNoir = Color.valueOf(couleurNoir);
        }
        
        if(couleurBlanc != null && !couleurBlanc.isEmpty()) {
            this.couleurBlanc = Color.valueOf(couleurBlanc);
        }
    }

    public void creerGrille(int taille) {
        J.appel(this);
        
        this.getStyleClass().add("conteneurGrille");
        
        VBox.setVgrow(this, Priority.ALWAYS);
        
        
        for(int indiceY = 0; indiceY < taille; indiceY++) {

            this.getChildren().add(new ConteneurLigneRP(taille, indiceY, couleurNoir, couleurBlanc));
        }
    }

    public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur, Boolean invisible) {
        J.appel(this);
        
        if(siIndicesValides(indiceColonne, indiceRangee)) {
            
            ConteneurLigneRP conteneurLigne = getConteneurLigne(indiceRangee);
            conteneurLigne.afficherJeton(indiceColonne, couleur, invisible);
        }
    }
    
	private boolean siIndicesValides(int indiceColonne, int indiceRangee) {
		J.appel(this);

		boolean siValide = false;
		
		if(indiceColonne >= 0 && indiceColonne < this.getChildren().size()) {
			siValide = indiceRangee >= 0 && indiceRangee < getConteneurLigne(indiceRangee).getChildren().size();
		}
		
		return siValide;
	}
    
    private ConteneurLigneRP getConteneurLigne(int indiceRangee) {
        J.appel(this);

        return (ConteneurLigneRP) this.getChildren().get(indiceRangee);
    }
    
    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);

        for(ConteneurLigneRP conteneurLigne : conteneurLigne()) {
            
        	conteneurLigne.obtenirJouerIciPourEnvoi();
        }
    }
    
    public void installerCapteursJouerIci() {
        J.appel(this);
        
        for(ConteneurLigneRP conteneurLigne : conteneurLigne()) {
            
        	conteneurLigne.installerCapteursJouerIci();
        }
    }
    
    private List<ConteneurLigneRP> conteneurLigne(){
        J.appel(this);
        
        List<ConteneurLigneRP> conteneurLigne = new ArrayList<>();
        
        for(Node enfant : this.getChildren()) {
            
        	conteneurLigne.add((ConteneurLigneRP) enfant);
        }

        return conteneurLigne;
    }
    public void animerEntreeJeton(int indiceColonne, int indiceRangee) {
        J.appel(this);

        if(siIndicesValides(indiceColonne, indiceRangee)) {
            
            ConteneurLigneRP ligne = getConteneurLigne(indiceRangee);
            ligne.animerEntreeJeton(indiceColonne);
        }
    }
    
}
