

package GO.messages.transmettre_resultats;

import ntro.messages.MessagePourEnvoi;

public interface MsgTransmettreResultatsPourEnvoi extends MessagePourEnvoi {
	
    void setResultats(int points);

}
