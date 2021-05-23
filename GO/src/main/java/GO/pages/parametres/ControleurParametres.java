package GO.pages.parametres;

import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTable;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTableRecue;
import GO.commandes.choisir_qui_commence.ChoisirQuiCommence;
import GO.commandes.choisir_qui_commence.ChoisirQuiCommenceRecue;
import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import GO.messages.transmettre_qui_commence.MsgTransmettreQuiCommence;
import GO.messages.transmettre_qui_commence.MsgTransmettreQuiCommencePourEnvoi;
import GO.messages.transmettre_qui_commence.MsgTransmettreQuiCommenceRecu;
import GO.messages.transmettre_taille.MsgTransmettreTaille;
import GO.messages.transmettre_taille.MsgTransmettreTaillePourEnvoi;
import GO.messages.transmettre_taille.MsgTransmettreTailleRecu;

public class   ControleurParametres 
       extends ControleurModeleVue<ParametresLectureSeule, 
                                   Parametres,
                                   VueParametres,
                                   AfficheurParametres> {
	
	private MsgTransmettreQuiCommencePourEnvoi msgTransmettreQuiCommence;
	private MsgTransmettreTaillePourEnvoi msgTransmettreTaille;
	
	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);
		
		installerRecepteurCommande(ChoisirQuiCommence.class, new RecepteurCommandeMVC<ChoisirQuiCommenceRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirQuiCommenceRecue commande) {
				J.appel(this);
				
				Couleur quiCommence = commande.getCouleur();

				DoitEtre.nonNul(quiCommence);

				getModele().choisirQuiCommence(quiCommence);
				
				msgTransmettreQuiCommence.setQuiCommence(quiCommence);
				msgTransmettreQuiCommence.envoyerMessage();
			}
		});
		
		installerRecepteurCommande(ChoisirTailleTable.class, new RecepteurCommandeMVC<ChoisirTailleTableRecue>() {
			@Override
			public void executerCommandeMVC(ChoisirTailleTableRecue commande) {
				J.appel(this);
				
				TailleTable tailleTable = commande.getTailleTable();
				
				DoitEtre.nonNul(tailleTable);
				
				getModele().choisirTailleTable(tailleTable);
				
				msgTransmettreTaille.setTailleTable(tailleTable);
				msgTransmettreTaille.envoyerMessage();
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
		
		msgTransmettreQuiCommence = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreQuiCommence.class);
		msgTransmettreTaille = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreTaille.class);
		
	}

	@Override
	protected void installerReceptionMessages() {
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreQuiCommence.class, new RecepteurMessageMVC<MsgTransmettreQuiCommenceRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreQuiCommenceRecu messageRecu) {
				J.appel(this);
				
				Couleur quiCommence = messageRecu.getQuiCommence();
				
				DoitEtre.nonNul(quiCommence);
				
				getModele().choisirQuiCommence(quiCommence);
			}
		});
		
		installerRecepteurMessage(MsgTransmettreTaille.class, new RecepteurMessageMVC<MsgTransmettreTailleRecu>() {
			@Override
			public void recevoirMessageMVC(MsgTransmettreTailleRecu messageRecu) {
				J.appel(this);
				
				TailleTable tailleTable = messageRecu.getTailleTable();
				
				DoitEtre.nonNul(tailleTable);
				
				getModele().choisirTailleTable(tailleTable);
			}
		});
	}
}
