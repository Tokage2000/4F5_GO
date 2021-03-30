package GO.commandes.choisir_Taille_Table;

import ntro.commandes.CommandeRecue;
import GO.enumerations.TailleTable;

public interface ChoisirTailleTableRecue extends CommandeRecue {
	
	TailleTable getTailleTable();
}