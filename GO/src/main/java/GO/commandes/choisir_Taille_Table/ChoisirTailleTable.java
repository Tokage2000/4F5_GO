package GO.commandes.choisir_Taille_Table;

import GO.enumerations.TailleTable;
import ntro.commandes.Commande;
import ntro.debogage.J;


public class ChoisirTailleTable extends Commande<ChoisirTailleTablePourEnvoi, ChoisirTailleTableRecue> 
implements ChoisirTailleTablePourEnvoi, ChoisirTailleTableRecue {

	private TailleTable tailleTable;

	@Override
	public TailleTable getTailleTable() {
		J.appel(this);
		
		return tailleTable;
	}

	@Override
	public void setTailleTable(TailleTable taille) {
		J.appel(this);
		
		this.tailleTable = taille;
	}
}