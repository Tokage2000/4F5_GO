package GO.pages.partie.composants;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.J;
import ntro.javafx.composants.CanvasAjustable;
import GO.commandes.jouer_ici.JouerIci;
import GO.Constantes;
import GO.commandes.jouer_ici.JouerIciPourEnvoi;
import GO.enumerations.Couleur;
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

public class CaseAjustable extends CanvasAjustable {
    
    private final double TAILLE_POURCENTAGE = 0.75;
    
    private Color couleurNoir;
    private Color couleurBlanc;
    
    private int indiceX;
    private int indiceY;
    
    private Button bouton;
    private JouerIciPourEnvoi jouerIciPourEnvoi;

    public CaseAjustable(@NamedArg("couleurNoir") Color couleurNoir, 
    		             @NamedArg("couleurBlanc") Color couleurBlanc,
    		             int indiceX, int indiceY) {
        super();
        J.appel(this);
        
        this.indiceX = indiceX;
        this.indiceY = indiceY;
        
        this.bouton = new Button();
        bouton.setMinWidth(Constantes.TAILLE_CASE);
        bouton.setMaxWidth(Constantes.TAILLE_CASE);
        bouton.setShape(new Circle(Constantes.TAILLE_CASE/2*TAILLE_POURCENTAGE));
        bouton.setMinSize(2*Constantes.TAILLE_CASE/2*TAILLE_POURCENTAGE, 2*Constantes.TAILLE_CASE/2*TAILLE_POURCENTAGE);
        bouton.setMaxSize(2*Constantes.TAILLE_CASE/2*TAILLE_POURCENTAGE, 2*Constantes.TAILLE_CASE/2*TAILLE_POURCENTAGE);
        bouton.setTranslateX(Constantes.TAILLE_CASE*(1-TAILLE_POURCENTAGE)/2);
        bouton.setTranslateY(Constantes.TAILLE_CASE*(1-TAILLE_POURCENTAGE)/2);
        bouton.getStyleClass().add("buttontrans");
		
        //bouton.setOnMouseEntered(e -> test());
        //bouton.setOnMouseExited(e -> test());
        
    	this.getChildren().add(bouton);
		
    	
        
        HBox.setHgrow(this, Priority.ALWAYS);
        VBox.setVgrow(this, Priority.ALWAYS);
        
        this.couleurNoir = couleurNoir;
        this.couleurBlanc = couleurBlanc;

        initialiserPinceau();
        dessinerCase();
    }
    
    public void test() {
        J.appel(this);
        
        
        
    }

    public void afficherJeton(Couleur couleur) {
        J.appel(this);
        
        switch(couleur) {
        
            case NOIR:
                pinceau.setFill(couleurNoir);
                dessinerCase();
                rmvBoutton();
            break;

            case BLANC:
                pinceau.setFill(couleurBlanc);
                dessinerCase();
                rmvBoutton();
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
        
        dessinerLigne(laCase);
        dessinerFond(laCase);
        dessinerContour(laCase);
        
    }
    
    private void dessinerLigne(Case laCase) {
        J.appel(this);
        
        
        Color Oldcolor = (Color) pinceau.getFill();
        pinceau.setFill(Color.BLACK);
        pinceau.fillRect(laCase.caseHautGaucheX-Constantes.TAILLE_CASE, laCase.caseHautGaucheY + (laCase.tailleCase)/2, Constantes.TAILLE_CASE*2, 1);
        pinceau.fillRect(laCase.caseHautGaucheX + (laCase.tailleCase)/2, laCase.caseHautGaucheY-Constantes.TAILLE_CASE, 1 , Constantes.TAILLE_CASE*2);
        pinceau.setFill(Oldcolor); 

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
		
		this.bouton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				jouerIciPourEnvoi.setIndiceJeton(indiceX, indiceY);
				jouerIciPourEnvoi.envoyerCommande();
				
			}
		});
	}
	
	public void obtenirJouerIciPourEnvoi() {
		J.appel(this);
		
		jouerIciPourEnvoi = FabriqueCommande.obtenirCommandePourEnvoi(JouerIci.class);
	}
	
	public void rmvBoutton() {
		J.appel(this);
		
		this.getChildren().remove(bouton);
	}

}
