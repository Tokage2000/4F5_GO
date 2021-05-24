
package GO.pages.resultats.controleurs;

import GO.commandes.fermer_resultats.FermerResultats;
import GO.commandes.fermer_resultats.FermerResultatsRecue;
import GO.commandes.ouvrir_resultats.OuvrirResultats;
import GO.commandes.ouvrir_resultats.OuvrirResultatsRecue;
import GO.messages.transmettre_resultats.MsgTransmettreResultats;
import GO.messages.transmettre_resultats.MsgTransmettreResultatsPourEnvoi;
import GO.messages.transmettre_resultats.MsgTransmettreResultatsRecu;
import GO.pages.resultats.afficheurs.AfficheurResultats;
import GO.pages.resultats.modeles.Resultats;
import GO.pages.resultats.modeles.ResultatsLectureSeule;
import GO.pages.resultats.vues.VueResultats;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import ntro.systeme.Systeme;

public class ControleurResultats
		extends ControleurModeleVue<ResultatsLectureSeule, Resultats, VueResultats, AfficheurResultats> {

	private MsgTransmettreResultatsPourEnvoi msgTransmettreResultats;

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(OuvrirResultats.class, new RecepteurCommandeMVC<OuvrirResultatsRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirResultatsRecue commande) {
				J.appel(this);

				int points = 10;

				msgTransmettreResultats.setResultats(points);

			}
		});

	}

	@Override
	protected void demarrer() {
		J.appel(this);
	}

	@Override
	protected void obtenirMessagesPourEnvoi() {
		J.appel(this);

		msgTransmettreResultats = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreResultats.class);

	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);

		installerRecepteurMessage(MsgTransmettreResultats.class,
				new RecepteurMessageMVC<MsgTransmettreResultatsRecu>() {

					@Override
					public void recevoirMessageMVC(MsgTransmettreResultatsRecu messageRecu) {
						J.appel(this);


						int points = messageRecu.getResultats();
						DoitEtre.nonNul(points);
					}
				});

	}
}
