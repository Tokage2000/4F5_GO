package GO.pages.REPLAY.modeles;

import ntro.debogage.J;
import ntro.mvc.modeles.Modele;
import GO.pages.REPLAY.modeles.Grille;

import java.util.List;

import GO.Constantes;
import GO.enumerations.Couleur;

public class Replay extends Modele<ReplayLectureSeule>
		implements ReplayLectureSeule {

	protected int cote;

	protected Couleur couleurCourante;
	protected Grille grille;

	private void initialiserGrille() {
		J.appel(this);

		grille = new Grille();
		grille.apresCreation();
	}

	@Override
	public void apresCreation() {
		J.appel(this);

		cote = Constantes.TABLE_PAR_DEFAUT.getTaille();
		couleurCourante = Couleur.NOIR;

		initialiserGrille();
	}

	
	public void suivant() {
		J.appel(this);

		grille.suivant();
	}
	
	public void precedent() {
		J.appel(this);
		
		grille.precedent();

	}

	public void jouerici(int x, int y) {
		J.appel(this);
		effectuerCoup(x, y);
	}

	public void effectuerCoup(int x, int y) {
		J.appel(this);

		grille.ajouterJeton(couleurCourante, x, y);
		prochaineCouleur();
	}

	private void prochaineCouleur() {
		J.appel(this);

		switch (couleurCourante) {

		case NOIR:
			couleurCourante = Couleur.BLANC;
			break;
		case BLANC:
			couleurCourante = Couleur.NOIR;
			break;
		}
	}

	public void setCote(int cote) {
		J.appel(this);
		this.cote = cote;

		initialiserGrille();
	}

	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}

	public void setCouleurCourante(Couleur couleurCourante) {
		J.appel(this);
		this.couleurCourante = couleurCourante;
	}

	public GrilleLectureSeule getGrille() {
		J.appel(this);
		return (GrilleLectureSeule) grille;
	}

	public void setGrille(Grille grille) {
		J.appel(this);
		this.grille = grille;
	}

	@Override
	public int getCote() {
		J.appel(this);
		return cote;
	}

	@Override
	public void apresChargementJson() {
		
		grille.apresChargementJson();
	}

}
