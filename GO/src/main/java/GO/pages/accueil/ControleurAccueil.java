
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
import GO.enumeration.Couleur;
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

import static GO.Constantes.*;

import java.io.IOException;

public class ControleurAccueil extends ControleurVue<VueAccueil> {

	private Scene sceneParametres;
	private Stage dialogueParametres;
	private Parametres parametres;
//	private Resultats resultats;
//	private Replay replay;
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
				
				//ouvrirResultats();
			}
		});

		installerRecepteurCommande(FermerResultats.class, new RecepteurCommandeMVC<FermerResultatsRecue>() {
			@Override
			public void executerCommandeMVC(FermerResultatsRecue commande) {
				J.appel(this);
				
				//fermerResultats();
			}
		});

		installerRecepteurCommande(OuvrirReplay.class, new RecepteurCommandeMVC<OuvrirReplayRecue>() {
			@Override
			public void executerCommandeMVC(OuvrirReplayRecue commande) {
				J.appel(this);
				
				//ouvrirReplay();
			}
		});

		installerRecepteurCommande(FermerReplay.class, new RecepteurCommandeMVC<FermerReplayRecue>() {
			@Override
			public void executerCommandeMVC(FermerReplayRecue commande) {
				J.appel(this);
				
				//fermerReplay();
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
		
		if(dialogueParametres != null) {
			dialogueParametres.close();
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
}
