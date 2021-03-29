
package GO.commandes.jouer_ici;

import ntro.commandes.Commande;
import ntro.debogage.J;

public class JouerIci extends Commande<JouerIciPourEnvoi, 
                                       JouerIciRecue> 

                      implements JouerIciPourEnvoi, 
                                 JouerIciRecue {
	
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
