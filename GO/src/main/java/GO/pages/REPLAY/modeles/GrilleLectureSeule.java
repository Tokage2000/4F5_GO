package GO.pages.replay.modeles;

import java.util.List;

import GO.enumerations.Couleur;

public interface GrilleLectureSeule {

	List<JetonLectureSeule> getJetons();


	void ajouterHistorique(int indiceX, int indiceY, Couleur couleur);
	
	

}
