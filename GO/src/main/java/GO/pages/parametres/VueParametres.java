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
import GO.commandes.choisir_Qui_Es_Tu.ChoisirQuiEsTu;
import GO.commandes.choisir_Qui_Es_Tu.ChoisirQuiEsTuPourEnvoi;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTablePourEnvoi;
import GO.commandes.fermer_parametres.FermerParametres;
import GO.commandes.choisir_Taille_Table.ChoisirTailleTable;

import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;


public class VueParametres implements Vue, Initializable {
	
	private ChoisirQuiEsTuPourEnvoi choisirQuiEsTu;
	private ChoisirTailleTablePourEnvoi choisirTailleTable;
	private FermerParametresPourEnvoi fermerParametres;
	
	private Couleur quiEsTu = Couleur.BLANC;
	private TailleTable taille = TailleTable.MOYENNE;

	@FXML 
	private Button caseNOIR, caseBLANC, boutonOk, boutonAnnuler;
	
	@FXML
	private CheckBox checkNOIR, checkBLANC;

	@FXML
	private ComboBox<String> choixTaille;
	
	private Map<String, TailleTable> tailleSelonNom = new HashMap<>();
	private Map<TailleTable, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		
		DoitEtre.nonNul(caseNOIR);
		DoitEtre.nonNul(caseBLANC);
		DoitEtre.nonNul(checkNOIR);
		DoitEtre.nonNul(checkBLANC);
		DoitEtre.nonNul(choixTaille);
		


		caseNOIR.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		caseBLANC.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		
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
		choisirQuiEsTu = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirQuiEsTu.class);
		choisirTailleTable = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleTable.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);
		
		checkNOIR.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				quiEsTu = Couleur.NOIR;
				afficherQuiEsTu(Couleur.NOIR);
			}
		});
		
		checkBLANC.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				quiEsTu = Couleur.BLANC;
				afficherQuiEsTu(Couleur.BLANC);

			}
		});

		choixTaille.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomTailleChoisie = choixTaille.getSelectionModel().getSelectedItem();
			
				
				TailleTable tailleChoisie = tailleSelonNom.get(nomTailleChoisie);
				
				
				taille = tailleChoisie;
				
				
			}
		});
		
		boutonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				
				
				choisirQuiEsTu.setCouleur(quiEsTu);
				choisirTailleTable.setTailleTable(taille);
				
				choisirQuiEsTu.envoyerCommande();
				choisirTailleTable.envoyerCommande();
				
				fermerParametres.envoyerCommande();
			}
		});
		
		boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerParametres.envoyerCommande();
			}
		});
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}

	public void afficherQuiEsTu(Couleur couleur) {
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
