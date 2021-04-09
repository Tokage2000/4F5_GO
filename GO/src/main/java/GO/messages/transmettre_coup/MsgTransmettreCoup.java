

package GO.messages.transmettre_coup;

import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreCoup extends Message<MsgTransmettreCoupPourEnvoi, MsgTransmettreCoupRecu>

		implements MsgTransmettreCoupPourEnvoi, MsgTransmettreCoupRecu {

	private int indiceX;
	private int indiceY;

	@Override
	public void setIndiceJeton(int indiceX, int indiceY) {
		J.appel(this);

		this.indiceX = indiceX;
		this.indiceY = indiceY;

	}

	@Override
	public int getIndiceX() {
		J.appel(this);

		return indiceX;
	}

	@Override
	public int getIndiceY() {
		J.appel(this);

		return indiceY;
	}
}
