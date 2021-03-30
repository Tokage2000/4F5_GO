package GO.commandes.choisir_Qui_Es_Tu;


import GO.enumerations.Couleur;

import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirQuiEsTu extends Commande <ChoisirQuiEsTuPourEnvoi, ChoisirQuiEsTuRecue> 
	implements ChoisirQuiEsTuPourEnvoi, ChoisirQuiEsTuRecue {
	
	private Couleur couleur;
	
	@Override
	public Couleur getCouleur() {
		J.appel(this);
		
		return couleur;
	}
	
	@Override
	public void setCouleur(Couleur marque) {
	J.appel(this);
	
	this.couleur = marque;
	}

}
