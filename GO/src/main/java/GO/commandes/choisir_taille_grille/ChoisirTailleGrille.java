

package GO.commandes.choisir_taille_grille;

import GO.enumeration.TailleTable;
import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirTailleGrille extends Commande<ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue> 
						   implements ChoisirTailleGrillePourEnvoi, ChoisirTailleGrilleRecue {
	
	private TailleTable tailleGrille;

	@Override
	public TailleTable getTailleTable() {
		J.appel(this);
		
		return tailleGrille;
	}

	@Override
	public void setTailleTable(TailleTable taille) {
		J.appel(this);
		
		this.tailleGrille = taille;
	}
	

}
