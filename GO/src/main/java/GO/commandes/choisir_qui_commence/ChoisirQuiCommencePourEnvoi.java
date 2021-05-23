package GO.commandes.choisir_qui_commence;

import GO.enumerations.Couleur;
import ntro.commandes.CommandePourEnvoi;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi{
	
	void setCouleur(Couleur marque);
}
