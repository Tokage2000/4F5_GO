package GO.pages.replay.afficheurs;

import java.util.List;

import GO.pages.replay.modeles.ReplayLectureSeule;
import GO.pages.replay.vues.VueReplay;
import ntro.debogage.J;
import ntro.mvc.Afficheur;
import GO.enumerations.Couleur;
import GO.pages.replay.modeles.GrilleLectureSeule;
import GO.pages.replay.modeles.JetonLectureSeule;

public class AfficheurReplay extends Afficheur<ReplayLectureSeule, VueReplay>

		{

	@Override
	public void initialiserAffichage(ReplayLectureSeule replayLectureSeule, VueReplay vue) {
		J.appel(this);

		int cote = replayLectureSeule.getCote();
		System.out.println(cote);

		vue.creerGrille(cote);
	}

	@Override
	public void rafraichirAffichage(ReplayLectureSeule replayLectureSeule, VueReplay vue) {
		J.appel(this);

		GrilleLectureSeule grille = replayLectureSeule.getGrille();

		int cote = replayLectureSeule.getCote();

		rafraichirTable(cote, grille, vue);
	}

	private void rafraichirTable(int cote, GrilleLectureSeule grille, VueReplay vue) {
		J.appel(this);
		
		clearTable(vue);
		
		List<JetonLectureSeule> jetons = grille.getJetons();
		for (int indice = 0; indice < jetons.size(); indice++) {
			
			Boolean invisible = false;
			JetonLectureSeule jeton = jetons.get(indice);
			int indiceY = jeton.getIndiceY();
			int indiceX = jeton.getIndiceX();
			Couleur couleur = jeton.getCouleur();
			if(indice>grille.getMax()-1) {
				invisible = true;
			}
			afficherJeton(cote, indiceX, indiceY, couleur, vue, invisible);

		}
	}

	private void afficherJeton(int tailleTable, int indiceX, int indiceY, Couleur couleur, VueReplay vue, Boolean invisible) {
		J.appel(this);

		vue.afficherJeton(indiceX, indiceY, couleur, invisible);
	}
	
	private void clearTable(VueReplay vue) {
		J.appel(this);

		//vue.clearTable();
	}

}