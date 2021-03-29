
package GO.pages.resultats;

import GO.commandes.fermer_resultats.FermerResultats;
import GO.commandes.fermer_resultats.FermerResultatsRecue;
import GO.pages.resultats.afficheurs.AfficheurResultats;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.systeme.Systeme;

public class ControleurResultats
		extends ControleurModeleVue<ResultatsLectureSeule, Resultats, VueResultats, AfficheurResultats> {

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		
		


	}

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
}
