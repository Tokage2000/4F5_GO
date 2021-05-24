

package GO.messages.transmettre_resultats;

import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreResultats extends Message<MsgTransmettreResultatsPourEnvoi,MsgTransmettreResultatsRecu>

		implements  MsgTransmettreResultatsRecu, MsgTransmettreResultatsPourEnvoi {

	private int points;



	@Override
	public int getResultats() {
		J.appel(this);

		return points;
	}

	@Override
	public void setResultats(int points) {
		J.appel(this);

		this.points = points;
	}



}
