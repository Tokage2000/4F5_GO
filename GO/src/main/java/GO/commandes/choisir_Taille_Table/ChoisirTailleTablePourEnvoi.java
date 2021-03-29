package GO.commandes.choisir_Taille_Table;

import ntro.commandes.CommandePourEnvoi;
import GO.enumerations.TailleTable;

public interface ChoisirTailleTablePourEnvoi extends CommandePourEnvoi {
	
	void setTailleTable(TailleTable taille);

}