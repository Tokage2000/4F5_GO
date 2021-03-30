package GO.pages.parametres;

import GO.enumerations.Couleur;
import GO.enumerations.TailleTable;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Parametres extends Modele<ParametresLectureSeule> implements ParametresLectureSeule {

	private Couleur quiEsTu;
	private TailleTable tailleTable;
	

	@Override 
	public void apresCreation() {
		J.appel(this);
		
		quiEsTu = Couleur.BLANC;
		tailleTable = TailleTable.MOYENNE;
	}
	
	
	@Override 
	public void apresChargementJson() {
		J.appel(this);
		
		DoitEtre.nonNul(tailleTable);
		DoitEtre.nonNul(quiEsTu);
	}
	
	
	@Override
	public Couleur getQuiEsTu() {
		J.appel(this);
		
		return quiEsTu;
	}
	
	
	public void choisirQuiEsTu(Couleur joueurQuiEsTu) {
		J.appel(this);
		
		this.quiEsTu = joueurQuiEsTu;
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
