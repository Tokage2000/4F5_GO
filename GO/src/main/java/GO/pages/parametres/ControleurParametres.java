package GO.pages.parametres;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import GO.commandes.choisir_Qui_Es_Tu.ChoisirQuiEsTu;
import GO.commandes.choisir_Qui_Es_Tu.ChoisirQuiEsTuRecue;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTable;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTableRecue;
import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiEsTu.class, new RecepteurCommandeMVC<ChoisirQuiEsTuRecue>() {
			
			@Override
			public void executerCommandeMVC(ChoisirQuiEsTuRecue commande) {
				J.appel(this);
				
				Couleur quiEsTu = commande.getCouleur();

				DoitEtre.nonNul(quiEsTu);

				getModele().choisirQuiEsTu(quiEsTu);
			}
		});
		
		installerRecepteurCommande(ChoisirTailleTable.class, new RecepteurCommandeMVC<ChoisirTailleTableRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleTableRecue commande) {
				J.appel(this);
				
				TailleTable tailleTable = commande.getTailleTable();
				
				DoitEtre.nonNul(tailleTable);
				
				getModele().choisirTailleTable(tailleTable);
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
