

package GO.pages.partie.afficheurs;

import java.util.List;

import ntro.debogage.J;
import ntro.mvc.Afficheur;
import GO.pages.partie.modeles.TableLectureSeule;
import GO.enumerations.Couleur;
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
		
		vue.creerTable(taille);
	}

	@Override
	public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
		J.appel(this);

		TableLectureSeule table = partieLectureSeule.getTable();
		
		int tailleTable = partieLectureSeule.getTaille();
		
		rafraichirTable(tailleTable, table, vue);
		animerDernierJeton(partieLectureSeule, vue);
	}

	private void animerDernierJeton(PLS partieLectureSeule, V vue) {
		J.appel(this);

		JetonLectureSeule dernierJeton = partieLectureSeule.getDernierJetonAjoute();
        
        if(dernierJeton != null) {
            vue.animerEntreeJeton(dernierJeton.getIndiceX(), dernierJeton.getIndiceY());
        }
	}

	private void rafraichirTable(int tailleTable, TableLectureSeule table, V vue) {
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
	
	private void afficherJeton(int tailleTable, 
			                   int indiceX,  
			                   int indiceY, 
			                   Couleur couleur,
			                   V vue) {
		J.appel(this);

		vue.afficherJeton(indiceX,indiceY, couleur);
	}

}
