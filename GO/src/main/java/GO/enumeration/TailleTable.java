package GO.enumeration;


import ntro.debogage.J;
import static GO.Constantes.*;


public enum TailleTable {
	
	PETITE(TABLE_PETITE), 
	MOYENNE(TABLE_MOYENNE), 
	GRANDE(TABLE_GRANDE);

	private int taille;
	
	private TailleTable(int taille) {
		J.appel(this);

		this.taille = taille;
	}
	
	public int getTaille(){
		return taille;
	}

}
