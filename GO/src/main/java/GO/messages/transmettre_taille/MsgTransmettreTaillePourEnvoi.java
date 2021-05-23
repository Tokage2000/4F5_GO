package GO.messages.transmettre_taille;

import GO.enumerations.TailleTable;
import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreTaillePourEnvoi extends MessagePourEnvoi {
	
	void setTailleTable(TailleTable tailleTable);

}