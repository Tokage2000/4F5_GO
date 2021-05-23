package GO.pages.parametres;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import GO.commandes.fermer_parametres.FermerParametresPourEnvoi;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTablePourEnvoi;
import GO.commandes.choisir_qui_commence.ChoisirQuiCommence;
import GO.commandes.choisir_qui_commence.ChoisirQuiCommencePourEnvoi;
import GO.commandes.fermer_parametres.FermerParametres;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTable;
import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import GO.pages.partie.composants.CaseAjustableParametres;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
/*import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;*/


public class VueParametres implements Vue, Initializable {
	
	private ChoisirQuiCommencePourEnvoi choisirQuiCommence;
	private ChoisirTailleTablePourEnvoi choisirTailleTable;
	private FermerParametresPourEnvoi fermerParametres;
	
	/*private Couleur quiCommence = Couleur.BLANC;
	private TailleTable taille = TailleTable.MOYENNE;*/

	@FXML 
	private CaseAjustableParametres caseNoir, caseBlanc;
	
	@FXML
	private CheckBox checkNOIR, checkBLANC;

	@FXML
	private Button boutonOk;
	
	@FXML
	private ComboBox<String> choixTaille;
	
	private Map<String, TailleTable> tailleSelonNom = new HashMap<>();
	private Map<TailleTable, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseNoir);
		DoitEtre.nonNul(caseBlanc);
		DoitEtre.nonNul(checkNOIR);
		DoitEtre.nonNul(checkBLANC);
		DoitEtre.nonNul(choixTaille);
		DoitEtre.nonNul(boutonOk);

		caseNoir.afficherJeton(Couleur.NOIR);
		caseBlanc.afficherJeton(Couleur.BLANC);
		
		initialiserChoixTaille(resources);
	}

	private void initialiserChoixTaille(ResourceBundle resources) {
		J.appel(this);

		for(TailleTable tailleTable : TailleTable.values()) {
			
			String nomTaille = tailleTable.name();
			
			choixTaille.getItems().add(nomTaille);
			
			tailleSelonNom.put(nomTaille, tailleTable);
			nomSelonTaille.put(tailleTable, nomTaille);
		}
		
		choixTaille.getSelectionModel().clearAndSelect(0);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
		choisirQuiCommence = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiCommence.class);
		choisirTailleTable = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleTable.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		checkNOIR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				choisirQuiCommence.setCouleur(Couleur.NOIR);
				choisirQuiCommence.envoyerCommande();
			}
		});
		
		checkBLANC.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				choisirQuiCommence.setCouleur(Couleur.BLANC);
				choisirQuiCommence.envoyerCommande();
			}
		});
		
		boutonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				
				
				/*choisirQuiCommence.setCouleur(quiCommence);
				choisirTailleTable.setTailleTable(taille);
				
				choisirQuiCommence.envoyerCommande();
				choisirTailleTable.envoyerCommande();*/
				
				fermerParametres.envoyerCommande();
			}
		});
		
		choixTaille.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomTailleChoisie = choixTaille.getSelectionModel().getSelectedItem();
				
				TailleTable tailleChoisie = tailleSelonNom.get(nomTailleChoisie);
				
				choisirTailleTable.setTailleTable(tailleChoisie);
				choisirTailleTable.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiCommence(Couleur couleur) {
		J.appel(this);
		
		DoitEtre.nonNul(couleur);

		switch(couleur) {
		
		case NOIR:
			checkNOIR.setSelected(true);
			checkBLANC.setSelected(false);
			break;

		case BLANC:
			checkNOIR.setSelected(false);
			checkBLANC.setSelected(true);
			break;
		}
	}

	public void afficherTailleTable(TailleTable tailleTable) {
		J.appel(this);
		
		String nomTaille = nomSelonTaille.get(tailleTable);
		
		int indiceTaille = choixTaille.getItems().indexOf(nomTaille);
		
		if(indiceTaille != -1) {
			choixTaille.getSelectionModel().clearAndSelect(indiceTaille);
		}
	}
}
