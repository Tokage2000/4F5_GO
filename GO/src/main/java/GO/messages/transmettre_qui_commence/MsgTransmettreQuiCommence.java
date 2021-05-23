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


package GO.messages.transmettre_qui_commence;

import GO.enumerations.Couleur;
import ntro.debogage.J;
import ntro.messages.Message;

public class MsgTransmettreQuiCommence extends Message<MsgTransmettreQuiCommencePourEnvoi, 
                                             MsgTransmettreQuiCommenceRecu>

					         implements MsgTransmettreQuiCommencePourEnvoi, 
					                    MsgTransmettreQuiCommenceRecu {
	
	private Couleur quiCommence;

	@Override
	public Couleur getQuiCommence() {
		J.appel(this);
		
		return quiCommence;
	}

	@Override
	public void setQuiCommence(Couleur quiCommence) {
		J.appel(this);
		
		this.quiCommence = quiCommence;
	}
}
