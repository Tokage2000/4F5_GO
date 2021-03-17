

package GO.pages.partie.controleurs;

import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import GO.commandes.jouer_ici.JouerIci;
import GO.commandes.jouer_ici.JouerIciRecue;
import GO.pages.partie.afficheurs.AfficheurPartie;
import GO.pages.partie.modeles.Partie;
import GO.pages.partie.modeles.PartieLectureSeule;
import GO.pages.partie.vues.VuePartie;

public abstract class  ControleurPartie<PLS extends PartieLectureSeule, 
							    P extends Partie<PLS>,
                                V extends VuePartie, 
                                A extends AfficheurPartie<PLS, V>>

	            extends ControleurModeleVue<PLS, P, V, A> {

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

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(JouerIci.class, new RecepteurCommandeMVC<JouerIciRecue>() {
			@Override
			public void executerCommandeMVC(JouerIciRecue commande) {
				J.appel(this);
				
				reagirCommandeJouerIci(commande);
				
			}
		});
	}
	
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		J.appel(this);

			getModele().jouerIci(jouerIciRecue.getIndiceX(),jouerIciRecue.getIndiceY());
	}
}
