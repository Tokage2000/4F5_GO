
package GO.pages.resultats.modeles;

import GO.enumerations.Couleur;
import ntro.mvc.modeles.ModeleLectureSeule;


public interface ResultatsLectureSeule extends ModeleLectureSeule {
	Couleur getCouleurGagnant();
	int getnombreTours();
	int getpointsBlanc();
	int getpointsNoir();

}
