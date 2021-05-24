package GO.pages.partie.composants;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.J;
import ntro.javafx.composants.CanvasAjustable;
import GO.commandes.jouer_ici.JouerIci;
import GO.Constantes;
import GO.commandes.jouer_ici.JouerIciPourEnvoi;
import GO.enumerations.Couleur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CaseAjustable extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.75;
    
    private Color couleurNoir;
    private Color couleurBlanc;
    
    private int indiceX;
    private int indiceY;
    
    
    private boolean actif = true, actif2 = true;
    
    private Timeline animationEntreeJeton;
    
    private Button bouton;
    private JouerIciPourEnvoi jouerIciPourEnvoi;

    public CaseAjustable(@NamedArg("couleurNoir") Color couleurNoir, 
    		             @NamedArg("couleurBlanc") Color couleurBlanc,
    		             int indiceX, int indiceY) {
        super();
        J.appel(this);
        

        
        this.indiceX = indiceX;
        this.indiceY = indiceY;

        
        this.setOnMouseEntered(e -> setRed());
        this.setOnMouseExited(e -> setBlack());
        this.setOnMousePressed(e -> setGray());
        this.setOnMouseReleased(e -> setBlue());
        this.setOnMouseClicked(e -> jouer());
    	
		
        
        this.couleurNoir = couleurNoir;
        this.couleurBlanc = couleurBlanc;
        
        creerAnimationEntreeJeton();

        initialiserPinceau();
        viderDessin();
        dessinerCase();
        
    }
    
    private void setBlack() {
        J.appel(this);
        
        pinceau.setStroke(Color.BLACK);
        viderDessin();
        dessinerCase();
    }
    
    private void setRed() {
        J.appel(this);
        
        Color Oldcolor = (Color) pinceau.getFill();
        if(Oldcolor == Color.LIGHTBLUE) {
        pinceau.setStroke(Color.RED);
        viderDessin();
        dessinerCase();
        }
        
    }
    
    private void setGray() {
        J.appel(this);
        
        Color Oldcolor = (Color) pinceau.getFill();
        if(Oldcolor == Color.LIGHTBLUE) {
        pinceau.setFill(Color.GRAY);
        pinceau.setStroke(Color.RED);
        viderDessin();
        dessinerCase();
        }
    }
    
    private void setBlue() {
        J.appel(this);
        Color Oldcolor = (Color) pinceau.getFill();
        if(Oldcolor == Color.GRAY) {
        pinceau.setFill(Color.LIGHTBLUE);
        pinceau.setStroke(Color.BLACK);
        viderDessin();
        dessinerCase();
        }
    }
    
    public void jouer() {
        J.appel(this);
        
        if(actif) {
        jouerIciPourEnvoi.setIndiceJeton(indiceX, indiceY);
		jouerIciPourEnvoi.envoyerCommande();
        }
    }

    public void afficherJeton(Couleur couleur) {
        J.appel(this);
        
        switch(couleur) {
        
            case NOIR:
                pinceau.setFill(couleurNoir);
                pinceau.setStroke(Color.BLACK);
                viderDessin();
                dessinerCase();
                actif = false;
            	actif2 = false;
                break;

            case BLANC:
                pinceau.setFill(couleurBlanc);
                pinceau.setStroke(Color.BLACK);
                viderDessin();
                dessinerCase();
                actif = false;
            	actif2 = false;
                break;
            case AUCUNE:
            	pinceau.setFill(Color.LIGHTBLUE);
                pinceau.setStroke(Color.BLACK);
                viderDessin();
                dessinerCase();
                actif = true;
            	actif2 = true;
                break;
        }
    }

    @Override
    protected void reagirLargeurInitiale(double largeurInitiale) {
        J.appel(this);
        
        viderDessin();
        dessinerCase();
    }

    @Override
    protected void reagirHauteurInitiale(double hauteurInitiale) {
        J.appel(this);

        viderDessin();
        dessinerCase();
    }

    @Override
    protected void reagirNouvelleLargeur(double ancienneLargeur, double nouvelleLargeur) {
        J.appel(this);

        viderDessin();
        dessinerCase();
    }

    @Override
    protected void reagirNouvelleHauteur(double ancienneHauteur, double nouvelleHauteur) {
        J.appel(this);

        viderDessin();
        dessinerCase();
    }

    private void initialiserPinceau() {
        J.appel(this);

        pinceau.setFill(Color.LIGHTBLUE);
        pinceau.setStroke(Color.BLACK);
        pinceau.setLineWidth(0.01*getWidth());
    }
    
    private void viderDessin() {
        J.appel(this);

        pinceau.clearRect(0, 0, getWidth(), getHeight());
    }
    
    private void dessinerCase() {
        J.appel(this);
        
        dessinerCase(TAILLE_POURCENTAGE);
    }

    private class Case {
        public double caseHautGaucheX;
        public double caseHautGaucheY;
        public double tailleCase;
    }
    
    private void dessinerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = calculerCase(taillePourcentage);
        
        dessinerFond(laCase);
        dessinerContour(laCase);
        
    }
 

    private void dessinerFond(Case laCase) {
        J.appel(this);

        
        pinceau.fillArc(laCase.caseHautGaucheX, 
                        laCase.caseHautGaucheY, 
                        laCase.tailleCase, 
                        laCase.tailleCase, 
                        0, 
                        360, 
                        ArcType.ROUND);
    }

    private void dessinerContour(Case laCase) {
        J.appel(this);

        pinceau.strokeArc(laCase.caseHautGaucheX, 
                          laCase.caseHautGaucheY, 
                          laCase.tailleCase, 
                          laCase.tailleCase, 
                          0, 
                          360, 
                          ArcType.OPEN);
    }

    private Case calculerCase(double taillePourcentage) {
        J.appel(this);
        
        Case laCase = new Case();

        double largeurDessin = getWidth();
        double hauteurDessin = getHeight();
        
        laCase.tailleCase = largeurDessin * taillePourcentage;

        if(hauteurDessin < largeurDessin) {
            laCase.tailleCase = hauteurDessin * taillePourcentage;
        }
        
        laCase.caseHautGaucheX = (largeurDessin - laCase.tailleCase) / 2;
        laCase.caseHautGaucheY = (hauteurDessin - laCase.tailleCase) / 2;
        
        return laCase;
    }
    
	public void installerCapteurJouerIci() {
		J.appel(this);
		
	
	}
	
	public void obtenirJouerIciPourEnvoi() {
		J.appel(this);
		
		jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
	}
	
	//Animation
    public void animerEntreeJeton() {
        J.appel(this);
        if(actif) {
        animationEntreeJeton.playFromStart();
        }
    }

	
    private void creerAnimationEntreeJeton() {
        J.appel(this);
        
        animationEntreeJeton = new Timeline();

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.opacityProperty(), 0)));

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(new Duration(200),
                             new KeyValue(this.opacityProperty(), 1))); 

    }

	

}
