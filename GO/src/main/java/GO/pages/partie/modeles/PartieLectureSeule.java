package GO.pages.partie.modeles;

import ntro.mvc.modeles.ModeleLectureSeule;

public interface PartieLectureSeule 
       extends   ModeleLectureSeule {
	
	 TableLectureSeule getTable();
	 int getTaille();
}