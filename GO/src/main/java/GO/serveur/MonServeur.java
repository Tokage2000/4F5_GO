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


package GO.serveur;

import ntro.debogage.J;
import static GO.Constantes.*;

import java.io.IOException;

public class MonServeur {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		J.appel(MonServeur.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() throws IOException, InterruptedException {
		J.appel(MonServeur.class);
		
		MonServeurWebSocket serveur = new MonServeurWebSocket(PORT);
		serveur.start();
		
        System.out.println("\n\nAppuyer sur Entrée pour quitter...");
        
        System.in.read();
        
        serveur.stop();
	}

}
