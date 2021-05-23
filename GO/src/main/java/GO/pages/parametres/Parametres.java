package GO.pages.parametres;

import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {

	private Couleur quiCommence;
	private TailleTable tailleTable;
	

	@Override 
	public void apresCreation() {
		J.appel(this);
		
		quiCommence = Couleur.BLANC;
		tailleTable = TailleTable.MOYENNE;
	}
	
	
	@Override 
	public void apresChargementJson() {
		J.appel(this);
		
		DoitEtre.nonNul(tailleTable);
		DoitEtre.nonNul(quiCommence);
	}
	
	
	@Override
	public Couleur getQuiCommence() {
		J.appel(this);
		
		return quiCommence;
	}
	
	
	public void choisirQuiCommence(Couleur joueurQuiCommence) {
		J.appel(this);
		
		this.quiCommence = joueurQuiCommence;
	}
	
	
	public void choisirTailleTable(TailleTable tailleTable) {
		J.appel(this);
		
		this.tailleTable = tailleTable;
	}
	
	
	@Override
	public TailleTable getTailleTable() {
		return tailleTable;
	}
}
