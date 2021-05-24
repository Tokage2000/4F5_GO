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
	private transient int size;

	public void apresCreation(int size) {
		J.appel(this);
		liste = new Couleur[size][size];
		this.size = size;
		
	}

	public void apresChargementJson(int size) {
		J.appel(this);
		liste = new Couleur[size][size];
		this.size = size;
		for(Jeton jeton : jetons) {
			liste[jeton.getIndiceX()][jeton.getIndiceY()] = jeton.getCouleur();
		}
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
		
		
		start( X,  Y,  couleur);
		
		return jeton;
	}
	
	
	

	private void start(int X, int Y, Couleur OGcouleur) {
		J.appel(this);
		
		Couleur couleur;
		if(OGcouleur == Couleur.BLANC) {
			couleur = Couleur.NOIR;
		}else {
			couleur = Couleur.BLANC;
		}
		
		int[][] test = new int[size][size];
		
		if(Y+1<liste.length){

			if(libertycheck(group(X, Y+1, couleur, test))){
				rmJeton(group(X, Y+1, couleur, test));
			}
		}
		
		test = new int[size][size];
		
		if(Y-1>=0){

			if(libertycheck(group(X, Y-1, couleur, test))){
				rmJeton(group(X, Y-1, couleur, test));
			}
		}
		
		test = new int[size][size];
		
		if(X+1<liste.length){

			if(libertycheck(group(X+1, Y, couleur, test))){
				rmJeton(group(X+1, Y, couleur, test));
			}
		}
		
		test = new int[size][size];
		
		if(X-1>=0){

			if(libertycheck(group(X-1, Y, couleur, test))){
				rmJeton(group(X-1, Y, couleur, test));
			}
		}
		
		test = new int[size][size];
		

		if(libertycheck(group(X, Y, OGcouleur, test))){
			rmJeton(group(X, Y, OGcouleur, test));
		}
		
	}
	
	private boolean libertycheck(int[][] groupeJeton){
		J.appel(this);
		
		boolean test = true;
		
		System.out.println("auto");

		
		for(int X = 0; X < groupeJeton.length; X++) {
			for(int Y = 0; Y < groupeJeton.length; Y++) {
				
				if(groupeJeton[X][Y] == 1) {
					
					if(Y+1<liste.length){
						if(liste[X][Y+1] == null) {
							test = false;
						}
					}
					if(Y-1>=0){
						if(liste[X][Y-1] == null) {
							test = false;
						}
					}
					
					if(X+1<liste.length){
						if(liste[X+1][Y] == null) {
							test = false;
						}
					}
					
					if(X-1>=0){
						if(liste[X-1][Y] == null) {
							test = false;
						}
					}
				}
			}
		}
		
		return test;
	}
	
	
	private int[][] group(int X, int Y, Couleur couleur, int[][] groupeJeton) {
		J.appel(this);
		
		
		if(liste[X][Y] == couleur && groupeJeton[X][Y] == 0) {
			groupeJeton[X][Y] = 1;
			
			if(X+1<liste.length) {groupeJeton = group(X+1, Y, couleur, groupeJeton);}
			if(X-1>=0) {groupeJeton = group(X-1, Y, couleur, groupeJeton);}
			if(Y+1<liste.length) {groupeJeton = group(X, Y+1, couleur, groupeJeton);}
			if(Y-1>=0) {groupeJeton = group(X, Y-1, couleur, groupeJeton);}
		}

		return groupeJeton;	

	}

	
	private void rmJeton(int[][] groupeJeton) {
		J.appel(this);
		
		for(int X = 0; X < groupeJeton.length; X++) {
			for(int Y = 0; Y < groupeJeton.length; Y++) {
				if(groupeJeton[X][Y] == 1) {
				    for(Jeton jeton : jetons) {
				        if(jeton.getIndiceX() == X && jeton.getIndiceY() == Y ) {
				            jetons.remove(jeton);
				            groupeJeton[X][Y] = 0;
				            liste[X][Y] = null;
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