package GO.pages.partie.modeles;

import GO.Constantes;
import GO.enumerations.Couleur;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;
import GO.pages.partie.modeles.Jeton;
import GO.pages.partie.modeles.JetonLectureSeule;

public class      Partie<PLS extends PartieLectureSeule> 
       extends    Modele<PLS>
       implements PartieLectureSeule {

	protected  int taille;
	
	protected Couleur couleurCourante;

	protected Table table;
	
	protected Couleur quiCommence;
	
	private transient Jeton dernierJetonAjoute;

	
	@Override
	public void apresCreation() {
		J.appel(this);

		taille = Constantes.TABLE_PAR_DEFAUT.getTaille();
		couleurCourante = Couleur.NOIR;
		initialiserTable();
	}

	private void initialiserTable() {
		J.appel(this);

		table = new Table();
		table.apresCreation(getTaille());
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);
		
		table.apresChargementJson(getTaille());
	}
	

	public Couleur getQuiCommence() {
		J.appel(this);
		return quiCommence;
	}
	
	public void setQuiCommence(Couleur quiCommence) {
		J.appel(this);
		
		 this.quiCommence = quiCommence;
	}

	
	
    public void jouerIci(int X, int Y){
        J.appel(this);

        effectuerCoup(X, Y);
    }

    public void effectuerCoup(int X, int Y) {
        J.appel(this);
        
        if(siPossibleJouerIci(X,Y)) {
        	dernierJetonAjoute = table.ajouterJeton(X, Y , couleurCourante);
        prochaineCouleur();
        }
    }

    private void prochaineCouleur() {
        J.appel(this);

        switch(couleurCourante) {

        case NOIR:
        	couleurCourante = Couleur.BLANC;
            break;
        case BLANC:
        	couleurCourante = Couleur.NOIR;
            break;
        }
    }

	public int getTaille() {
		J.appel(this);
		return taille;
	}

	public void setTaille(int taille) {
		J.appel(this);
		this.taille = taille;

		initialiserTable();
	}

	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}

	public void setCouleurCourante(Couleur couleurCourante) {
		J.appel(this);
		this.couleurCourante = couleurCourante;
	}

	public TableLectureSeule getTable() {
		J.appel(this);
		return (TableLectureSeule) table;
	}

	public void setTable(Table table) {
		J.appel(this);
		this.table = table;
	}

	public boolean siPossibleJouerIci(int X, int Y) {
		J.appel(this);
		boolean siPossible = true;
		
		if(!siCoordonneValide(X,Y)) {
			siPossible = false;
		}
		
		if(!table.siPossibleJouerIci(X, Y)) {
			siPossible = false;
		}
		
		
		
		return siPossible;
	}
	
	@Override
	public JetonLectureSeule getDernierJetonAjoute() {
		J.appel(this);

		return dernierJetonAjoute;
	}
	
	
	
	public boolean siCoordonneValide(int X, int Y) {
		if(X > taille || Y > taille) { 
			return false;
		}else {
			return true;
		}
	}

}