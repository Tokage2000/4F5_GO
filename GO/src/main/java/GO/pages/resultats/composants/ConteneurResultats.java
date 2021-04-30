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


package GO.pages.resultats.composants;

import ntro.debogage.J;
import GO.Constantes;
import GO.enumerations.Couleur;
import javafx.beans.NamedArg;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ConteneurResultats extends VBox {
    
    private Color couleurRouge;
    private Color couleurJaune;
    
    public ConteneurResultats(@NamedArg("couleurRouge") String couleurRouge, 
    		               @NamedArg("couleurJaune") String couleurJaune) {
        super();
        J.appel(this);

        if(couleurRouge != null && !couleurRouge.isEmpty()) {
            this.couleurRouge = Color.valueOf(couleurRouge);
        }
        
        if(couleurJaune != null && !couleurJaune.isEmpty()) {
            this.couleurJaune = Color.valueOf(couleurJaune);
        }
    }

    public void creerGrille(int largeur, int hauteur) {
        J.appel(this);
        
        this.getStyleClass().add("conteneurTableResultats");

    
    }



}
