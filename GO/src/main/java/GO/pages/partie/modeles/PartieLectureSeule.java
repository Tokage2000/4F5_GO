package GO.pages.partie.modeles;

import ntro.mvc.modeles.ModeleLectureSeule;
import GO.pages.partie.modeles.JetonLectureSeule;

public interface PartieLectureSeule 
       extends   ModeleLectureSeule {
	
	 TableLectureSeule getTable();
	 int getTaille();
	 
	 JetonLectureSeule getDernierJetonAjoute();
}