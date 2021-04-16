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


package GO.pages.partie.composants;

import ntro.debogage.J;
import GO.Constantes;
import GO.enumerations.Couleur;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ConteneurLigne extends HBox {
	
	public ConteneurLigne(int largeur, Color couleurRouge, Color couleurJaune) {
		J.appel(this);
		
		this.getStyleClass().add("conteneurLigne");

        this.setMinWidth(largeur*Constantes.TAILLE_CASE);
        this.setMaxWidth(largeur*Constantes.TAILLE_CASE);
		
		for(int i = 0; i < largeur; i++) {
			
			CaseAjustable caseAjustable = new CaseAjustable(couleurRouge, couleurJaune);
			
			caseAjustable.getStyleClass().add("conteneurCase");
			
			caseAjustable.setMinHeight(Constantes.TAILLE_CASE);
			caseAjustable.setMinWidth(Constantes.TAILLE_CASE);

			caseAjustable.setMaxHeight(Constantes.TAILLE_CASE);
			caseAjustable.setMaxWidth(Constantes.TAILLE_CASE);
			
			this.getChildren().add(caseAjustable);
		}
	}

	public void afficherJeton(int indiceColonne, Couleur couleur) {
		J.appel(this);
		
		if(siIndiceColonneValide(indiceColonne)) {

			CaseAjustable caseAjustable = getCase(indiceColonne);
			caseAjustable.afficherJeton(couleur);
		}
	}

	private CaseAjustable getCase(int indiceColonne) {
		J.appel(this);

		return (CaseAjustable) this.getChildren().get(indiceColonne);
	}

	private boolean siIndiceColonneValide(int indiceColonne) {
		J.appel(this);

		return indiceColonne < this.getChildren().size();
	}
}
