package GO.pages.partie.composants;

import ntro.debogage.J;

import java.util.ArrayList;
import java.util.List;

import GO.Constantes;
import GO.enumerations.Couleur;
import javafx.beans.NamedArg;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ConteneurGrille extends VBox {
    
    private Color couleurNoir;
    private Color couleurBlanc;
    
    public ConteneurGrille(@NamedArg("couleurNoir") String couleurNoir, 
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

            this.getChildren().add(new ConteneurLigne(taille, indiceY, couleurNoir, couleurBlanc));
        }
    }

    public void afficherJeton(int indiceColonne, int indiceRangee, Couleur couleur) {
        J.appel(this);
        
        if(siIndicesValides(indiceColonne, indiceRangee)) {
            
            ConteneurLigne conteneurLigne = getConteneurLigne(indiceRangee);
            conteneurLigne.afficherJeton(indiceColonne, couleur);
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
    
    private ConteneurLigne getConteneurLigne(int indiceRangee) {
        J.appel(this);

        return (ConteneurLigne) this.getChildren().get(indiceRangee);
    }
    
    public void obtenirJouerIciPourEnvoi() {
        J.appel(this);

        for(ConteneurLigne conteneurLigne : conteneurLigne()) {
            
        	conteneurLigne.obtenirJouerIciPourEnvoi();
        }
    }
    
    public void installerCapteursJouerIci() {
        J.appel(this);
        
        for(ConteneurLigne conteneurLigne : conteneurLigne()) {
            
        	conteneurLigne.installerCapteursJouerIci();
        }
    }
    
    private List<ConteneurLigne> conteneurLigne(){
        J.appel(this);
        
        List<ConteneurLigne> conteneurLigne = new ArrayList<>();
        
        for(Node enfant : this.getChildren()) {
            
        	conteneurLigne.add((ConteneurLigne) enfant);
        }

        return conteneurLigne;
    }
}
