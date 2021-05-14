package GO.pages.replay.controleurs;

import GO.pages.replay.modeles.Replay;
import GO.pages.replay.modeles.ReplayLectureSeule;
import GO.pages.replay.vues.VueReplay;
import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import GO.commandes.precedent.Precedent;
import GO.commandes.precedent.PrecedentRecue;
import GO.commandes.suivant.Suivant;
import GO.commandes.suivant.SuivantRecue;
import GO.pages.replay.afficheurs.AfficheurReplay;

public class ControleurReplay 
		extends ControleurModeleVue<ReplayLectureSeule, 
									Replay,
									VueReplay,
									AfficheurReplay>

			{


	protected void demarrer() {
		J.appel(this);
	}

	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

	}

	protected void installerReceptionMessages() {
		J.appel(this);

	}

	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(Suivant.class, new RecepteurCommandeMVC<SuivantRecue>() {

			@Override
			public void executerCommandeMVC(SuivantRecue commande) {
				J.appel(this);

				reagirCommandeSuivant(commande);

			}
		});
		
		installerRecepteurCommande(Precedent.class, new RecepteurCommandeMVC<PrecedentRecue>() {

			@Override
			public void executerCommandeMVC(PrecedentRecue commande) {
				J.appel(this);

				reagirCommandePrecedent(commande);

			}
		});
	}

	protected void reagirCommandeSuivant(SuivantRecue suivantRecue) {
		J.appel(this);

		getModele().suivant();
	}
	
	protected void reagirCommandePrecedent(PrecedentRecue PrecedentRecue) {
		J.appel(this);

		getModele().precedent();
	}
}
