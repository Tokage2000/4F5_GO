
package GO.pages.resultats.modeles;

import java.util.Arrays;

import GO.enumerations.Couleur;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Resultats extends Modele<ResultatsLectureSeule> implements ResultatsLectureSeule {

	private Couleur Gagnant;
	private int nombreTours,pointsBlanc, pointsNoir;
	private transient int taille;
	private transient int[][] tableau;

	@Override
	public void apresCreation() {
		J.appel(this);
		
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
		DoitEtre.nonNul(Gagnant);
	}

	@Override
	public Couleur getCouleurGagnant() {
		J.appel(this);

		return Gagnant;
	}
	
	
	public void setTableau(int[][] tableau) {
		J.appel(this);
		this.tableau = tableau;
	}
	
	public void setTaille(int taille) {
		J.appel(this);
		this.taille = taille;
	}

	@Override
	public int getnombreTours() {
		J.appel(this);
		return nombreTours;
	}

	@Override
	public int getpointsBlanc() {
		J.appel(this);
		return pointsBlanc;
	}

	@Override
	public int getpointsNoir() {
		J.appel(this);
		return pointsNoir;
	}
	
	public void setCouleurGagnant(Couleur gagnant) {
		J.appel(this);

		this.Gagnant = gagnant;
	}
	
	public void setnombreTours(int tours) {
		J.appel(this);

		this.nombreTours = tours;
	}
	
	public void setpointsBlanc(int points) {
		J.appel(this);

		this.pointsBlanc = points;
	}
	
	public void setpointsNoir(int points) {
		J.appel(this);

		this.pointsNoir = points;
	}


	
	
}
