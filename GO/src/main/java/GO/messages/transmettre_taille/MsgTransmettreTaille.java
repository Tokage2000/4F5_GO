
package GO.messages.transmettre_taille;

import GO.enumerations.TailleTable;
import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreTaille extends Message<MsgTransmettreTaillePourEnvoi, 
                                             MsgTransmettreTailleRecu>

					         implements MsgTransmettreTaillePourEnvoi, 
					                    MsgTransmettreTailleRecu {
	
	private TailleTable tailleTable;

	@Override
	public TailleTable getTailleTable() {
		J.appel(this);

		return tailleTable;
	}

	@Override
	public void setTailleTable(TailleTable tailleTable) {
		J.appel(this);
		
		this.tailleTable = tailleTable;
	}
}
