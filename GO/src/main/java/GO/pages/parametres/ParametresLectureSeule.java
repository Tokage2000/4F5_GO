package GO.pages.parametres;

import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import ntro.mvc.modeles.ModeleLectureSeule;

public interface ParametresLectureSeule extends ModeleLectureSeule {
	
	Couleur getQuiCommence();
	TailleTable getTailleTable();
}
