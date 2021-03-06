package GO.pages.parametres;

import ntro.debogage.J;
import ntro.mvc.Afficheur;

public class   AfficheurParametres 
       extends Afficheur<ParametresLectureSeule, VueParametres> {

	@Override
	public void initialiserAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);
	}

	@Override
	public void rafraichirAffichage(ParametresLectureSeule modeleLectureSeule, VueParametres vue) {
		J.appel(this);

		vue.afficherTailleTable(modeleLectureSeule.getTailleTable());
		vue.afficherQuiCommence(modeleLectureSeule.getQuiCommence());
	}

}
