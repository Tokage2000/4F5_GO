package GO.pages.replay.modeles;

import GO.enumerations.Couleur;
import ntro.debogage.J;

public class Jeton implements JetonLectureSeule {

	private Couleur couleur;
	private int indiceX;
	private int indiceY;

	@Override
	public Couleur getCouleur() {
		J.appel(this);

		return couleur;
	}

	@Override
	public int getIndiceX() {
		J.appel(this);

		return indiceX;
	}

	@Override
	public int getIndiceY() {
		J.appel(this);

		return indiceY;
	}


	public void setIndiceX(int indiceX) {
		J.appel(this);

		this.indiceX = indiceX;
	}

	public void setIndiceY(int indiceY) {
		J.appel(this);

		this.indiceY = indiceY;
	}

	public void setCouleur(Couleur couleur) {
		J.appel(this);

		this.couleur = couleur;
	}

}
