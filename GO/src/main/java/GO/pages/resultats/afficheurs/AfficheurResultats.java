
package GO.pages.resultats.afficheurs;

import GO.pages.resultats.ResultatsLectureSeule;
import GO.pages.resultats.VueResultats;
import ntro.debogage.J;
import ntro.mvc.Afficheur;

public class   AfficheurResultats 
       extends Afficheur<ResultatsLectureSeule, VueResultats> {

	@Override
	public void initialiserAffichage(ResultatsLectureSeule modeleLectureSeule, VueResultats vue) {
		J.appel(this);
	}

	@Override
	public void rafraichirAffichage(ResultatsLectureSeule modeleLectureSeule, VueResultats vue) {
		J.appel(this);

	}

}
