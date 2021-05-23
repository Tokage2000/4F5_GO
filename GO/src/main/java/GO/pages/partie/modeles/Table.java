package GO.pages.partie.modeles;

import java.util.ArrayList;
import java.util.List;

import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import ntro.debogage.J;

public class Table implements TableLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();

	public void apresCreation(int size) {
		J.appel(this);

		jetons = new ArrayList<>();
		int[][] table = new int[size][size];
		
	}

	public void apresChargementJson() {
		
	}
	
	public Jeton ajouterJeton(int X, int Y, Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceY(Y);
		jeton.setIndiceX(X);
		
		if(jeton.getCouleur()==Couleur.BLANC) {
			
		}
		
		jetons.add(jeton);
		
		start();
		
		return jeton;
	}
	
	
	

	private void start() {
		
		test();
	}
	
	

	private void test() {
		
		
		
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
	
	
	public boolean siPossibleJouerIci(int x, int y) {
		
		boolean returnValue = true;
		
		for(Jeton jeton : jetons) {
			if(jeton.getIndiceX() == x && jeton.getIndiceY() == y) {
				returnValue = false;
				break;
			}
		}
		
		return returnValue;
	}
	
	

	
}