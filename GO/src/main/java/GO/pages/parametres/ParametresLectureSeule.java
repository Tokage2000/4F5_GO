
package GO.pages.parametres;

import GO.enumeration.Couleur;
import GO.enumeration.TailleTable;
import ntro.mvc.modeles.ModeleLectureSeule;

public interface ParametresLectureSeule extends ModeleLectureSeule {
	
	Couleur getQuiCommence();
	TailleTable getTailleTable();

}
