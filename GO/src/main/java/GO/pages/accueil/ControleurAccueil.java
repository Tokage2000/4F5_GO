
package GO.pages.accueil;

import ntro.debogage.Erreur;
import ntro.debogage.J;
import ntro.systeme.Systeme;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.DialogueModal;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.ControleurVue;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.controleurs.RecepteurCommandeMVC;
import ntro.mvc.modeles.EntrepotDeModeles;
import javafx.scene.Scene;
import javafx.stage.Stage;
import GO.commandes.fermer_parametres.FermerParametres;
import GO.commandes.fermer_parametres.FermerParametresRecue;
import GO.commandes.fermer_replay.FermerReplay;
import GO.commandes.fermer_replay.FermerReplayRecue;
import GO.commandes.fermer_resultats.FermerResultats;
import GO.commandes.fermer_resultats.FermerResultatsRecue;
import GO.commandes.nouvelle_partie.NouvellePartieLocale;
import GO.commandes.nouvelle_partie.NouvellePartieLocaleRecue;
import GO.commandes.ouvrir_parametres.OuvrirParametres;
import GO.commandes.ouvrir_parametres.OuvrirParametresRecue;
import GO.commandes.ouvrir_replay.OuvrirReplay;
import GO.commandes.ouvrir_replay.OuvrirReplayRecue;
import GO.commandes.ouvrir_resultats.OuvrirResultats;
import GO.commandes.ouvrir_resultats.OuvrirResultatsRecue;
import GO.commandes.quitter.Quitter;
import GO.commandes.quitter.QuitterRecue;
import GO.enumerations.Couleur;
import GO.pages.REPLAY.afficheurs.AfficheurReplay;
import GO.pages.REPLAY.controleurs.ControleurReplay;
import GO.pages.REPLAY.modeles.Replay;
import GO.pages.REPLAY.vues.VueReplay;
import GO.pages.parametres.AfficheurParametres;
import GO.pages.parametres.ControleurParametres;
import GO.pages.parametres.Parametres;
import GO.pages.parametres.VueParametres;
//import GO.pages.parametres.AfficheurParametres;
//import GO.pages.parametres.ControleurParametres;
//import GO.pages.parametres.Parametres;
//import GO.pages.parametres.VueParametres;
import GO.pages.partie.afficheurs.AfficheurPartieLocale;
import GO.pages.partie.controleurs.ControleurPartieLocale;
import GO.pages.partie.modeles.PartieLocale;
import GO.pages.partie.vues.VuePartieLocale;
import GO.pages.resultats.afficheurs.AfficheurResultats;
import GO.pages.resultats.controleurs.ControleurResultats;
import GO.pages.resultats.modeles.Resultats;
import GO.pages.resultats.vues.VueResultats;

import static GO.Constantes.*;

import java.awt.List;
import java.io.IOException;

public class ControleurAccueil extends ControleurVue<VueAccueil> {

	private Scene sceneParametres;
	private Stage dialogueParametres;
	private Parametres parametres;
	
	private Scene sceneResultats;
	private Stage dialogueResultats;
	private Resultats resultats;
	
	private Scene sceneReplay;
	private Stage dialogueReplay;	
	private Replay replay;
	
	private PartieLocale partieLocale;

	@Override
	protected void installerReceptionCommandes() {
		J.appel(this);

		installerRecepteurCommande(NouvellePartieLocale.class, new RecepteurCommandeMVC<NouvellePartieLocaleRecue>() {
			@Override
			public void executerCommandeMVC(NouvellePartieLocaleRecue commande) {
				J.appel(this);
				
				nouvellePartieLocale();
			}
		});

		installerRecepteurCommande(OuvrirParametres.class, new RecepteurCommandeMVC<OuvrirParametresRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirParametresRecue commande) {
				J.appel(this);
				
				ouvrirParametres();
			}
		});

		installerRecepteurCommande(FermerParametres.class, new RecepteurCommandeMVC<FermerParametresRecue>() {
			@Override
			public void executerCommandeMVC(FermerParametresRecue commande) {
				J.appel(this);
				
				fermerParametres();
			}
		});
		
		installerRecepteurCommande(OuvrirResultats.class, new RecepteurCommandeMVC<OuvrirResultatsRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirResultatsRecue commande) {
				J.appel(this);
				
				ouvrirResultats();
			}
		});

		installerRecepteurCommande(FermerResultats.class, new RecepteurCommandeMVC<FermerResultatsRecue>() {
			@Override
			public void executerCommandeMVC(FermerResultatsRecue commande) {
				J.appel(this);
				
				fermerResultats();
			}
		});

		installerRecepteurCommande(OuvrirReplay.class, new RecepteurCommandeMVC<OuvrirReplayRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirReplayRecue commande) {
				J.appel(this);
				
				ouvrirReplay();
			}
		});

		installerRecepteurCommande(FermerReplay.class, new RecepteurCommandeMVC<FermerReplayRecue>() {
			@Override
			public void executerCommandeMVC(FermerReplayRecue commande) {
				J.appel(this);
				
				fermerReplay();
			}
		});

		installerRecepteurCommande(Quitter.class, new RecepteurCommandeMVC<QuitterRecue>() {
			@Override
			public void executerCommandeMVC(QuitterRecue commande) {
				J.appel(this);

				quitter();
			}
		});
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
	protected void demarrer() {
		J.appel(this);

		instancierControleurParametres();
		
		ouvrirPartieLocale();
	}

	  private void instancierControleurParametres() {
		J.appel(this);

		ChargeurDeVue<VueParametres> chargeur;
		chargeur = new ChargeurDeVue<VueParametres>(CHEMIN_PARAMETRES_FXML);
		
		sceneParametres = chargeur.nouvelleScene(LARGEUR_PARAMETRES_PIXELS, 
				                                 HAUTEUR_PARAMETRES_PIXELS);
		

			parametres = EntrepotDeModeles.creerModele(Parametres.class, ID_MODELE_PAR_DEFAUT);
		
		
		AfficheurParametres afficheurParametres = new AfficheurParametres();
		
		VueParametres vueParametres = chargeur.getVue();
		
		FabriqueControleur.creerControleur(ControleurParametres.class, 
				                           parametres, 
				                           vueParametres, 
				                           afficheurParametres);
	}
	  
	  private void instancierControleurResultats() {
		J.appel(this);

		ChargeurDeVue<VueResultats> chargeur;
		chargeur = new ChargeurDeVue<VueResultats>(CHEMIN_RESULTATS_FXML,CHEMIN_RESULTATS_CSS, CHEMIN_CHAINES);
		
		sceneResultats = chargeur.nouvelleScene(LARGEUR_PARAMETRES_PIXELS, 
				                                 HAUTEUR_PARAMETRES_PIXELS);
		
		resultats = EntrepotDeModeles.creerModele(Resultats.class, ID_MODELE_PAR_DEFAUT);
		//1 = Noir 2 = Blanc
		int tableau[][] = new int[partieLocale.getTaille()][partieLocale.getTaille()];
		
		for(int i = 0; i < partieLocale.getTable().getJetons().size(); i++) {
			if(partieLocale.getTable().getJetons().get(i).getCouleur() == Couleur.NOIR) {
				tableau[partieLocale.getTable().getJetons().get(i).getIndiceY()][partieLocale.getTable().getJetons().get(i).getIndiceX()] = 1;
			}else if(partieLocale.getTable().getJetons().get(i).getCouleur() == Couleur.BLANC) {
				tableau[partieLocale.getTable().getJetons().get(i).getIndiceY()][partieLocale.getTable().getJetons().get(i).getIndiceX()] = 2;
			}
		}
		
		resultats.setTableau(tableau);
		
		resultats.setTaille(partieLocale.getTaille());
		
		AfficheurResultats afficheurResultats = new AfficheurResultats();
		
		VueResultats vueResultats = chargeur.getVue();
		
		FabriqueControleur.creerControleur(ControleurResultats.class, 
				                           resultats, 
				                           vueResultats, 
				                           afficheurResultats);
	}
	  
	  private void instancierControleurReplay() {
		J.appel(this);

		ChargeurDeVue<VueReplay> chargeur;
		chargeur = new ChargeurDeVue<VueReplay>(CHEMIN_REPLAY_FXML);
		
		sceneReplay = chargeur.nouvelleScene(LARGEUR_REPLAY_PIXELS, 
				                                 HAUTEUR_REPLAY_PIXELS);
		
		replay = EntrepotDeModeles.creerModele(Replay.class, ID_MODELE_PAR_DEFAUT);

		
		replay.setCote(partieLocale.getTaille());
		
		if(partieLocale.getTable().getJetons().size() > 0) {
		replay.setCouleurCourante(partieLocale.getTable().getJetons().get(0).getCouleur());
		}
		for(int i = 0; i < partieLocale.getTable().getJetons().size(); i++) {
			replay.effectuerCoup(partieLocale.getTable().getJetons().get(i).getIndiceX(), 
								 partieLocale.getTable().getJetons().get(i).getIndiceY());
		}
		
		
		AfficheurReplay afficheurReplay = new AfficheurReplay();
		
		VueReplay vueReplay = chargeur.getVue();
		
		FabriqueControleur.creerControleur(ControleurReplay.class, 
											replay, 
				                           vueReplay, 
				                           afficheurReplay);
	}
	private void ouvrirPartieLocale() {
		J.appel(this);
		
		try {

			partieLocale = EntrepotDeModeles.obtenirModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);

		} catch (IOException e) {
			
			creerNouvellePartieLocaleSelonParametres(parametres);
		}
		
		instancierControleurPartieLocale();
	}
	
	private void nouvellePartieLocale() {
		J.appel(this);

		creerNouvellePartieLocaleSelonParametres(parametres);

		instancierControleurPartieLocale();
	}

	private void instancierControleurPartieLocale() {
		J.appel(this);

		VuePartieLocale vuePartieLocale = getVue().creerVuePartieLocale();

		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();

		FabriqueControleur.creerControleur(ControleurPartieLocale.class, 
			                           	   partieLocale, 
			                           	   vuePartieLocale, 
			                           	   afficheur);
	}

	private void creerNouvellePartieLocaleSelonParametres(Parametres parametres) {
		J.appel(this);

		partieLocale = EntrepotDeModeles.creerModele(PartieLocale.class, ID_MODELE_PAR_DEFAUT);
		partieLocale.setTaille(parametres.getTailleTable().getTaille());
		partieLocale.setCouleurCourante(parametres.getQuiEsTu());
	}
	private void ouvrirParametres() {
		J.appel(this);
		
		dialogueParametres = DialogueModal.ouvrirDialogueModal(sceneParametres);
		
		dialogueParametres.setMinWidth(LARGEUR_PARAMETRES_PIXELS_MIN);
		dialogueParametres.setMinHeight(HAUTEUR_PARAMETRES_PIXELS_MIN);

		dialogueParametres.setWidth(LARGEUR_PARAMETRES_PIXELS);
		dialogueParametres.setHeight(HAUTEUR_PARAMETRES_PIXELS);

		dialogueParametres.setMaxWidth(LARGEUR_PARAMETRES_PIXELS_MAX);
		dialogueParametres.setMaxHeight(HAUTEUR_PARAMETRES_PIXELS_MAX);
	}

	private void fermerParametres() {
		J.appel(this);
		
		sauvegarderParametres();
		if(dialogueParametres != null) {
			dialogueParametres.close();
		}
	}
	
	private void ouvrirResultats() {
		J.appel(this);
		
		instancierControleurResultats();
		
		dialogueResultats = DialogueModal.ouvrirDialogueModal(sceneResultats);
		
		dialogueResultats.setMinWidth(LARGEUR_PARAMETRES_PIXELS_MIN);
		dialogueResultats.setMinHeight(HAUTEUR_PARAMETRES_PIXELS_MIN);

		dialogueResultats.setWidth(LARGEUR_PARAMETRES_PIXELS);
		dialogueResultats.setHeight(HAUTEUR_PARAMETRES_PIXELS);

		dialogueResultats.setMaxWidth(LARGEUR_PARAMETRES_PIXELS_MAX);
		dialogueResultats.setMaxHeight(HAUTEUR_PARAMETRES_PIXELS_MAX);
	}

	private void fermerResultats() {
		J.appel(this);
		
		if(dialogueResultats != null) {
			dialogueResultats.close();
		}
	}
	
	private void ouvrirReplay() {
		J.appel(this);
		
		instancierControleurReplay();
		
		dialogueReplay = DialogueModal.ouvrirDialogueModal(sceneReplay);
		
		dialogueReplay.setMinWidth(LARGEUR_REPLAY_PIXELS_MIN);
		dialogueReplay.setMinHeight(HAUTEUR_REPLAY_PIXELS_MIN);

		dialogueReplay.setWidth(LARGEUR_REPLAY_PIXELS);
		dialogueReplay.setHeight(HAUTEUR_REPLAY_PIXELS);

		dialogueReplay.setMaxWidth(LARGEUR_REPLAY_PIXELS_MAX);
		dialogueReplay.setMaxHeight(HAUTEUR_REPLAY_PIXELS_MAX);
	}
	
	//Demander une meilleur facon de transferer les donn�es
	private void fermerReplay() {
		J.appel(this);
		
		if(dialogueReplay != null) {
			dialogueReplay.close();
		}
	}
	private void quitter() {
		J.appel(this);

		sauvegarderPartieLocale();

		Systeme.quitter();
	}


	private void sauvegarderPartieLocale() {
		J.appel(this);

		if (partieLocale != null) {
			try {
				EntrepotDeModeles.sauvegarderModele(partieLocale);

			} catch (IOException e) {

				Erreur.nonFatale("Impossible de sauvegarder la partie locale", e);
			}
		}
	}
	//Inutilis� pour l'instant
	private void sauvegarderParametres() {
		J.appel(this);

		if (partieLocale != null) {
			try {
				EntrepotDeModeles.sauvegarderModele(parametres);

			} catch (IOException e) {

				Erreur.nonFatale("Impossible de sauvegarder la partie locale", e);
			}
		}
	}
}
