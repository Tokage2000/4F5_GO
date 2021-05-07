

package GO.messages.nouvelle_partie_reseau;

import GO.pages.parametres.Parametres;
import ntro.messages.MessagePourEnvoi;

public interface MsgNouvellePartiePourEnvoi extends MessagePourEnvoi {
	
	void setParametres(Parametres parametres);

}
