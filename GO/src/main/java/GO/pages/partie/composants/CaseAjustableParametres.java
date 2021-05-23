
package GO.pages.partie.composants;


import ntro.debogage.J;
import ntro.javafx.composants.CanvasAjustable;
import GO.enumerations.Couleur;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.NamedArg;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.util.Duration;

public class CaseAjustableParametres extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.65;
    
    private Color couleurNoir;
    private Color couleurBlanc;
    
    private Timeline animationSortieJeton;
    private Timeline animationEntreeJeton;

    public CaseAjustableParametres(@NamedArg("couleurNoir") Color couleurNoir, 
    							   @NamedArg("couleurBlanc") Color couleurBlanc) {
        super();
        J.appel(this);
        
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
        
        this.couleurNoir = couleurNoir;
        this.couleurBlanc = couleurBlanc;

        initialiserPinceau();
        dessinerCase();
    }

    public void afficherJeton(Couleur couleur) {
        J.appel(this);
        
        switch(couleur) {
        
            case NOIR:
                pinceau.setFill(couleurNoir);
                dessinerCase();
            break;

            case BLANC:
                pinceau.setFill(couleurBlanc);
                dessinerCase();
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

        pinceau.setFill(Color.WHITE);
        pinceau.setStroke(Color.BLACK);
        pinceau.setLineWidth(0.01 * getWidth());
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
    
    public void animerEntreeJeton() {
        J.appel(this);
        
        animationEntreeJeton.playFromStart();        
        
    }

    public void animerSortieJeton() {
        J.appel(this);
        
        animationSortieJeton.playFromStart();
        
    }

    private void creerAnimationEntreeJeton() {
        J.appel(this);
        
        animationEntreeJeton = new Timeline();

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.translateYProperty(), -100),
                             new KeyValue(this.opacityProperty(), 0)));

        animationEntreeJeton.getKeyFrames().add(
                new KeyFrame(new Duration(100),
                             new KeyValue(this.translateYProperty(), 0),
                             new KeyValue(this.opacityProperty(), 1))); 
    }

    private void creerAnimationSortieJeton() {
        J.appel(this);
        
        animationSortieJeton = new Timeline();
        
        animationSortieJeton.getKeyFrames().add(
                new KeyFrame(Duration.ZERO,
                             new KeyValue(this.translateYProperty(), 0),
                             new KeyValue(this.opacityProperty(), 1)));

        animationSortieJeton.getKeyFrames().add(
                new KeyFrame(new Duration(100),
                             new KeyValue(this.translateYProperty(), 200),
                             new KeyValue(this.opacityProperty(), 0))); 
    }
}
