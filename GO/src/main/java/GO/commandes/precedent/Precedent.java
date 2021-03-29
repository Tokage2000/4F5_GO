package GO.commandes.precedent;

import ntro.commandes.Commande;
import ntro.debogage.J;

public class Precedent extends Commande<PrecedentPourEnvoi, PrecedentRecue>

		implements PrecedentPourEnvoi, PrecedentRecue {

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
