
package GO.pages.resultats;

import GO.enumerations.Couleur;
import ntro.mvc.modeles.ModeleLectureSeule;


public interface ResultatsLectureSeule extends ModeleLectureSeule {
	Couleur getCouleurGagnant();
	int getnombreTours();
	int getpointsBlanc();
	int getpointsNoir();

}
