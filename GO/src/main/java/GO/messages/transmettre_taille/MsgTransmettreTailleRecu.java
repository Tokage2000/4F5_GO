package GO.messages.transmettre_taille;

import GO.enumerations.TailleTable;
import ntro.messages.MessageRecu;

public interface MsgTransmettreTailleRecu extends MessageRecu {
	
	TailleTable getTailleTable();

}