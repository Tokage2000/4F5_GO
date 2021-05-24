
package GO.pages.resultats.modeles;

import java.util.Arrays;

import GO.enumerations.Couleur;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Resultats extends Modele<ResultatsLectureSeule> implements ResultatsLectureSeule {

	private Couleur Gagnant = Couleur.AUCUNE;
	private int  nombreTours;
	private double pointsBlanc = 0, pointsNoir= 0;
	private transient int taille;
	private transient int[][] tableau;
	@FXML
	private Text blanc;

	@Override
	public void apresCreation() {
		J.appel(this);

		
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);

	}
	
	
	public void calculPoints() {
		J.appel(this);
		System.out.println(Gagnant+"test"+pointsNoir+pointsBlanc);
		 if (Gagnant == Couleur.BLANC) {
			 pointsNoir = pointsNoir + 0.5;
		 } else if (Gagnant == Couleur.NOIR) {
			 pointsBlanc = pointsBlanc + 0.5;
		 }
		 System.out.println(Gagnant+"test"+pointsNoir+pointsBlanc);
	 for (int row = 0; row < tableau.length; row++) {
		    for (int col = 0; col < tableau[row].length; col++) {
		       
		    	if (tableau[row][col] == 1) {
		    		pointsNoir++;
		    	}  else if (tableau[row][col] == 2) {
		    		pointsBlanc++;
		    	}
		    }
		 }

	}
	

	
	public void setTableau(int[][] tableau) {
		J.appel(this);
		this.tableau = tableau;
		calculPoints();
		System.out.println(pointsNoir);

		System.out.println(pointsBlanc);

	}
	
	
	public String getNoir() {
		J.appel(this);
		return (" "+pointsNoir);
		
	}
	
	public String getBlanc() {
		J.appel(this);
		return (" "+pointsBlanc);
		
	}
	public void setTaille(int taille) {
		J.appel(this);
		this.taille = taille;
		
	}


	public void setNombreTours(int nombretours) {
		J.appel(this);
		this.nombreTours = nombretours;
	}
	
	
	public void setGagnant(Couleur gagnant) {
		J.appel(this);
		this.Gagnant = gagnant;
	}
	

	
}
