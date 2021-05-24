package GO.pages.partie.modeles;

import java.util.ArrayList;
import java.util.List;

import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import ntro.debogage.J;

public class Table implements TableLectureSeule {
	
	private List<Jeton> jetons = new ArrayList<>();
	private List<Jeton> HistoriqueCoup = new ArrayList<>();
	private transient Couleur[][] liste;
	private transient int[][] id;
	private transient int size;

	public void apresCreation(int size) {
		J.appel(this);
		liste = new Couleur[size][size];
		id = new int[size][size];
		this.size = size;
		
	}

	public void apresChargementJson(int size) {
		J.appel(this);
		liste = new Couleur[size][size];
		id = new int[size][size];
		this.size = size;
	}
	
	public Jeton ajouterJeton(int X, int Y, Couleur couleur) {
		J.appel(this);
		
		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceY(Y);
		jeton.setIndiceX(X);
		
		jetons.add(jeton);
		HistoriqueCoup.add(jeton);
		
		if(jeton.getCouleur()==Couleur.BLANC) {
			liste[X][Y] = Couleur.BLANC;
		}else {
			liste[X][Y] = Couleur.NOIR;
		}
		
		id[X][Y] = jetons.size()-2;
		
		start( X,  Y,  couleur);
		
		return jeton;
	}
	
	
	

	private void start(int X, int Y, Couleur OGcouleur) {
		
		int[][] test = new int[size][size];
		Couleur couleur;
		if(OGcouleur == Couleur.BLANC) {
			couleur = Couleur.NOIR;
		}else {
			couleur = Couleur.BLANC;
		}
		
		if(Y+1<liste.length){
				rmJeton(group(X, Y+1, couleur, test));
		}
		
		
		
		if(Y-1>=0){
				rmJeton(group(X, Y-1, couleur, test));
		}
		
		if(X+1<liste.length){
				rmJeton(group(X+1, Y, couleur, test));
		}
		
		if(X-1>=0){
				rmJeton(group(X-1, Y, couleur, test));
		}
		
	}
	
	
	private int[][] group(int X, int Y, Couleur couleur, int[][] test) {
		
		System.out.println(X+" "+Y);
		
		
		if(liste[X][Y] == couleur && test[X][Y] == 0) {
			test[X][Y] = 1;
			if(X+1<liste.length) {test = group(X+1, Y, couleur, test);}
			if(X-1>=0) {test = group(X-1, Y, couleur, test);}
			if(Y+1<liste.length) {test = group(X, Y+1, couleur, test);}
			if(Y-1>=0) {test = group(X, Y-1, couleur, test);}
		}
		return test;	
	}

	
	private void rmJeton(int[][] groupeJeton) {
		
		for(int X = 0; X < groupeJeton.length; X++) {
			for(int Y = 0; Y < groupeJeton.length; Y++) {
				if(groupeJeton[X][Y] == 1) {
				    for(Jeton jeton : jetons) {
				        if(jeton.getIndiceX() == X && jeton.getIndiceY() == Y ) {
				            jetons.remove(jeton);
				            break;
				        }
				    }
				}
			}
		}
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