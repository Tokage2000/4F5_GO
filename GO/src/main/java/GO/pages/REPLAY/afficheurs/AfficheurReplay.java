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

	private void rafraichirTable(int tailleTable, GrilleLectureSeule table, VueReplay vue) {
		J.appel(this);
		
		List<JetonLectureSeule> jetons = table.getJetons();
		
		for(int i = 0; i < tailleTable; i++) {
			for(int y = 0; y < tailleTable; y++) {
				
					afficherJeton(tailleTable, i, y, Couleur.AUCUNE, vue);
				
			}
		}
		
		
		for(int NoJeton = 0; NoJeton < jetons.size(); NoJeton++) {
			
			
			JetonLectureSeule jeton = jetons.get(NoJeton);
			int indiceY = jeton.getIndiceY();
			int indiceX = jeton.getIndiceX();
			Couleur couleur = jeton.getCouleur();
			
			
			
			afficherJeton(tailleTable, indiceX, indiceY, couleur, vue);

		}
	}

	private void afficherJeton(int tailleTable, int indiceX, int indiceY, Couleur couleur, VueReplay vue) {
		J.appel(this);

		vue.afficherJeton(indiceX, indiceY, couleur);
	}
	

}