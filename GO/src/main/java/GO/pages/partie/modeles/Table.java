package GO.pages.partie.modeles;

import java.util.ArrayList;
import java.util.List;

import GO.enumeration.Couleur;
import GO.enumeration.TailleTable;
import ntro.debogage.J;

public class Table implements TableLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();

	public void apresCreation(int taille) {
		J.appel(this);

		jetons = new ArrayList<>();
		
	}

	public void apresChargementJson() {
		
	}
	
	public Jeton ajouterJeton(int X, int Y, Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceY(Y);
		jeton.setIndiceX(X);
		
		jetons.add(jeton);
		
		return jeton;
	}

	@Override
	public List<JetonLectureSeule> getJetons() {
		J.appel(this);
		
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		for(Jeton jeton : jetons) {

			jetonsLectureSeule.add((JetonLectureSeule) jeton);
		}
		
		return jetonsLectureSeule;
	}
	
	

	
}