

package GO.commandes.choisir_taille_grille;

import GO.enumeration.TailleTable;
import ntro.commandes.CommandePourEnvoi;

public interface ChoisirTailleGrillePourEnvoi extends CommandePourEnvoi {
	
	void setTailleTable(TailleTable taille);

}
