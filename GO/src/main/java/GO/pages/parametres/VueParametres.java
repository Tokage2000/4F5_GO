// Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
//
// This file is part of tutoriels4f5
//
// tutoriels4f5 is free software: you can redistribute it and/or modify
// it under the terms of the GNU Affero General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// tutoriels4f5 is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU Affero General Public License for more details.
//
// You should have received a copy of the GNU Affero General Public License
// along with aquiletour.  If not, see <https://www.gnu.org/licenses/>


package GO.pages.parametres;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import ntro.commandes.FabriqueCommande;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;
import GO.commandes.choisir_taille_grille.ChoisirTailleGrillePourEnvoi;
import GO.commandes.choisir_taille_grille.ChoisirTailleGrille;
import GO.commandes.fermer_parametres.FermerParametres;
import GO.commandes.fermer_parametres.FermerParametresPourEnvoi;
import GO.enumeration.Couleur;
import GO.enumeration.TailleTable;
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
	
	private FermerParametresPourEnvoi fermerParametres;
	private ChoisirTailleGrillePourEnvoi choisirTailleGrille;

	
	@FXML
	private Button boutonOk;

	@FXML
	private ComboBox<String> choixTaille;
	
	private Map<String, TailleTable> tailleSelonNom = new HashMap<>();
	private Map<TailleTable, String> nomSelonTaille = new HashMap<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		J.appel(this);
		

		DoitEtre.nonNul(boutonOk);
		DoitEtre.nonNul(choixTaille);

		
		initialiserChoixTaille(resources);
	}

	private void initialiserChoixTaille(ResourceBundle resources) {
		J.appel(this);

		for(TailleTable tailleGrille : TailleTable.values()) {
			
			String nomTaille = tailleGrille.name();
			
			choixTaille.getItems().add(nomTaille);
			
			tailleSelonNom.put(nomTaille, tailleGrille);
			nomSelonTaille.put(tailleGrille, nomTaille);
		}

		choixTaille.getSelectionModel().clearAndSelect(0);
	}

	@Override
	public void obtenirCommandesPourEnvoi() {
		J.appel(this);
		
		fermerParametres = FabriqueCommande.obtenirCommandePourEnvoi(FermerParametres.class);
		choisirTailleGrille = FabriqueCommande.obtenirCommandePourEnvoi(ChoisirTailleGrille.class);
	}

	@Override
	public void installerCapteursEvenementsUsager() {
		J.appel(this);

		boutonOk.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);

				fermerParametres.envoyerCommande();
			}
		});

		choixTaille.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				J.appel(this);
				
				String nomTailleChoisie = choixTaille.getSelectionModel().getSelectedItem();
				
				TailleTable tailleChoisie = tailleSelonNom.get(nomTailleChoisie);
				
				choisirTailleGrille.setTailleTable(tailleChoisie);
				choisirTailleGrille.envoyerCommande();
			}
		});
		
	}

	@Override
	public void verifierCommandesPossibles() {
		J.appel(this);
	}
	
	

	public void afficherTailleGrille(TailleTable tailleGrille) {
		J.appel(this);
		
		String nomTaille = nomSelonTaille.get(tailleGrille);
		
		int indiceTaille = choixTaille.getItems().indexOf(nomTaille);
		
		if(indiceTaille != -1) {
			choixTaille.getSelectionModel().clearAndSelect(indiceTaille);
		}
	}
}
