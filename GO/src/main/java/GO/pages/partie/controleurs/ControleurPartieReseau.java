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


package GO.pages.partie.controleurs;

import ntro.debogage.J;
import ntro.messages.FabriqueMessage;
import ntro.mvc.controleurs.RecepteurMessageMVC;
import GO.commandes.jouer_ici.JouerIciRecue;
import GO.pages.partie.afficheurs.AfficheurPartieReseau;
import GO.pages.partie.modeles.PartieReseau;
import GO.pages.partie.modeles.PartieReseauLectureSeule;
import GO.pages.partie.vues.VuePartieReseau;
import GO.messages.transmettre_coup.MsgTransmettreCoup;
import GO.messages.transmettre_coup.MsgTransmettreCoupPourEnvoi;
import GO.messages.transmettre_coup.MsgTransmettreCoupRecu;

public class ControleurPartieReseau

                extends ControleurPartie<PartieReseauLectureSeule, 
                        PartieReseau, 
                        VuePartieReseau, 
                        AfficheurPartieReseau> {
	
	private MsgTransmettreCoupPourEnvoi transmettreCoup;
	

	@Override
	protected void obtenirMessagesPourEnvoi() {
		super.obtenirMessagesPourEnvoi();
		J.appel(this);
		
		transmettreCoup = FabriqueMessage.obtenirMessagePourEnvoi(MsgTransmettreCoup.class);
	}

	@Override
	protected void installerReceptionMessages() {
		super.installerReceptionMessages();
		J.appel(this);
		
		installerRecepteurMessage(MsgTransmettreCoup.class, new RecepteurMessageMVC<MsgTransmettreCoupRecu>() {

			@Override
			public void recevoirMessageMVC(MsgTransmettreCoupRecu messageRecu) {
				J.appel(this);
				
				getModele().jouerIci(messageRecu.getIndiceX(),messageRecu.getIndiceY());
			}
		});
	}
	
	@Override
	protected void reagirCommandeJouerIci(JouerIciRecue jouerIciRecue) {
		super.reagirCommandeJouerIci(jouerIciRecue);
		J.appel(this);
		
		transmettreCoup.setIndiceJeton(jouerIciRecue.getIndiceX(),jouerIciRecue.getIndiceY());
		transmettreCoup.envoyerMessage();
	}
}
