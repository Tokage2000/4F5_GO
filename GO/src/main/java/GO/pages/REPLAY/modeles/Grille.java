package GO.pages.replay.modeles;

import java.util.ArrayList;

import java.util.List;

import ntro.debogage.J;
import GO.enumerations.Couleur;
import GO.pages.replay.modeles.Jeton;
import GO.pages.replay.modeles.JetonLectureSeule;

public class Grille implements GrilleLectureSeule {

	private List<Jeton> jetons = new ArrayList<>();
	
	private transient int max = 0;
	private transient int nbJetons = 0;
	
	private transient boolean update = true;
	

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

	public Jeton ajouterJeton(Couleur couleur, int x, int y) {
		J.appel(this);

		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceX(x);
		jeton.setIndiceY(y);

		jetons.add(jeton);
		
		if(jeton.getCouleur()==Couleur.BLANC) {
			liste[x][y] = Couleur.BLANC;
		}else {
			liste[x][y] = Couleur.NOIR;
		}
		
		
		check( x,  y,  couleur);

		return jeton;
	}
	
	@Override
	public void ajouterHistorique(int x, int y, Couleur couleur) {
		Jeton jeton = new Jeton();

		jeton.setCouleur(couleur);
		jeton.setIndiceX(x);
		jeton.setIndiceY(y);
		
		HistoriqueCoup.add(jeton);
	}
	
	//Vérifie si il y a des jetons à enlever (envoie les 4 jeton qui touche le coup éffectuer à group)
	private void check(int X, int Y, Couleur OGcouleur) {
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
	
	//Voit si le groupe est entouré (et donc doit être éffacé)
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
	
	//Trouve le groupe associé à un jeton
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

	//Efface les jeton dans groupeJeton selon leur coordonées
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
	
	
	public void suivant() {
		if(max<HistoriqueCoup.size() ) {
		ajouterJeton(getHistorique().get(max).getCouleur(), getHistorique().get(max).getIndiceX(),getHistorique().get(max).getIndiceY());
		max++;
		}
	}
	
	
	public List<JetonLectureSeule> getHistorique() {
		J.appel(this);
		
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		for(Jeton jeton : HistoriqueCoup) {

			jetonsLectureSeule.add((JetonLectureSeule) jeton);
		}
		
		return jetonsLectureSeule;
	}

	@Override
	public List<JetonLectureSeule> getJetons() {
		J.appel(this);
		
		List<JetonLectureSeule> jetonsLectureSeule = new ArrayList<>();
		
		nbJetons = jetons.size();
		
		
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