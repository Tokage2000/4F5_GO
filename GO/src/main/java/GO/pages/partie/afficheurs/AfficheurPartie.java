

package GO.pages.partie.afficheurs;

import java.util.List;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import GO.enumeration.Couleur;
import GO.pages.partie.modeles.TableLectureSeule;
import GO.pages.partie.modeles.JetonLectureSeule;
import GO.pages.partie.modeles.PartieLectureSeule;
import GO.pages.partie.vues.VuePartie;


public abstract class   AfficheurPartie<PLS extends PartieLectureSeule, 
                                        V extends VuePartie> 

				extends Afficheur<PLS, V> {

	@Override
	public void initialiserAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);
		
		int taille = partieLectureSeule.getTaille();
		System.out.println(taille);
		
		vue.creerTable(taille);
	}

	@Override
	public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);

		TableLectureSeule grille = partieLectureSeule.getTable();
		
		int tailleGrille = partieLectureSeule.getTaille();
		
		rafraichirTable(tailleGrille, grille, vue);
	}

	private void rafraichirTable(int tailleGrille, TableLectureSeule table, V vue) {
		J.appel(this);

		List<JetonLectureSeule> jetons = table.getJetons();
		
		for(int NoJeton = 0; NoJeton < jetons.size(); NoJeton++) {
			
			
			JetonLectureSeule jeton = jetons.get(NoJeton);
			int indiceY = jeton.getIndiceY();
			int indiceX = jeton.getIndiceX();
			Couleur couleur = jeton.getCouleur();
			
			
			
			afficherJeton(tailleGrille, indiceX, indiceY, couleur, vue);

		}
	}
	
	private void afficherJeton(int tailleTable, 
			                   int indiceX,  
			                   int indiceY, 
			                   Couleur couleur,
			                   V vue) {
		J.appel(this);
		
		int[] indiceRangeeCoordonneesGraphiques = convertirEnCoordonneesGraphiques(tailleTable, indiceX ,indiceY);

		vue.afficherJeton(indiceRangeeCoordonneesGraphiques[0],indiceRangeeCoordonneesGraphiques[1], couleur);
	}
	
	private int[] convertirEnCoordonneesGraphiques(int tailleTable, int indiceX ,int indiceY) {
		J.appel(this);
		int[] calcul = new int[2];
		calcul[0] = indiceX-1;
		calcul[1] = tailleTable - indiceY;
		return calcul;
	}

}
