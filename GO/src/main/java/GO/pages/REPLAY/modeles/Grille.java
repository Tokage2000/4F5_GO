package GO.pages.REPLAY.modeles;

import java.util.ArrayList;

import java.util.List;

import ntro.debogage.J;
import GO.enumerations.Couleur;
import GO.pages.REPLAY.modeles.Jeton;
import GO.pages.REPLAY.modeles.JetonLectureSeule;

public class Grille implements GrilleLectureSeule {

	private List<Jeton> jetons = new ArrayList<>();
	
	private transient int max = 0;
	private transient int nbJetons = 0;
	
	//A changer
	private transient boolean update = true;
	
	public void apresCreation() {
		
		jetons = new ArrayList<>();
		
	}

	public void apresChargementJson() {
		
		
	}

	public Jeton ajouterJeton(Couleur couleur, int x, int y) {
		J.appel(this);

		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceX(x);
		jeton.setIndiceY(y);

		jetons.add(jeton);

		return jeton;
	}
	
	
	public void suivant() {
		if(!(max>=nbJetons)) {
			max++;
		}
	}
	
	public void precedent() {
		if(!(max<=0)) {
			max--;
		}
	}

	@Override
	public List<JetonLectureSeule> getJetons() {
		J.appel(this);
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		nbJetons = jetons.size();
		
		if(update) {
			max = nbJetons;
			update = false;
		}
		
		int i=0;
		for (Jeton jeton : jetons) {

			if(i>=max) {
				break;
			}
			
			jetonsLectureSeule.add((JetonLectureSeule) jeton);

			i++;
		}

		return jetonsLectureSeule;
	}

}