

package GO.pages.parametres;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import GO.commandes.choisir_taille_grille.ChoisirTailleGrille;
import GO.commandes.choisir_taille_grille.ChoisirTailleGrilleRecue;
import GO.enumeration.Couleur;
import GO.enumeration.TailleTable;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirTailleGrille.class, new RecepteurCommandeMVC<ChoisirTailleGrilleRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleGrilleRecue commande) {
				J.appel(this);
				
				TailleTable tailleGrille = commande.getTailleTable();
				
				DoitEtre.nonNul(tailleGrille);
				
				getModele().choisirTailleGrille(tailleGrille);
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
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
	}
}
