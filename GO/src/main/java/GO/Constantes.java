package GO;

import GO.enumerations.TailleTable;

public class Constantes {
	
	public static final String ID_MODELE_PAR_DEFAUT = "defaut";
	
	public static final String CHEMIN_PRINCIPAL_FXML = "/accueil/structure.xml";
	public static final String CHEMIN_PARAMETRES_FXML = "/parametres/structure.xml";
	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/partie/locale/structure.xml";
	public static final String CHEMIN_RESULTATS_FXML = "/resultats/structure.xml";
	public static final String CHEMIN_PARAMETRES_CSS = "/parametres/style.css";
	public static final String CHEMIN_RESULTATS_CSS = "/resultats/style.css";
	public static final String CHEMIN_REPLAY_FXML = "/replay/structure.xml";
	public static final String CHEMIN_REPLAY_CSS = "/replay/style.css";
	public static final String CHEMIN_PARTIE_RESEAU_FXML = "/partie/reseau/structure.xml";
	public static final String CHEMIN_PARTIE_LOCALE_CSS = "/partie/locale/style.css";
	public static final String CHEMIN_PARTIE_RESEAU_CSS = "/partie/reseau/style.css";
	public static final String CHEMIN_CHAINES = "traductions.chaines";
	public static final String CHEMIN_CHAINES_FRANCAIS = "traductions.chaines_fr";
	public static final String CHEMIN_CHAINES_ANGLAIS = "traductions.chaines_en";
	
	
	public static double AJUSTEMENT_TAILLE_PIXELS = 1.0;
    public static final int TAILLE_POLICE = 15;
    public static final int TAILLE_POLICE_MIN = 11;
    public static final int TAILLE_POLICE_MAX = 18;

	public static final int TABLE_PETITE = 9;
	public static final int TABLE_MOYENNE = 13;
	public static final int TABLE_GRANDE = 19;
	
	public static final TailleTable TABLE_PAR_DEFAUT = TailleTable.PETITE;
	
	public static final int PORT = 8765;
	public static final String ADRESSE_SERVEUR = String.format("ws://localhost:%s", PORT);
	
	public static final int TAILLE_CASE = 30;

	public static final int LARGEUR_PIXELS_MIN = 500;
	public static final int HAUTEUR_PIXELS_MIN = 500;

	public static final int LARGEUR_PIXELS = 600;
	public static final int HAUTEUR_PIXELS= 600;
	
	
	public static final int LARGEUR_PARAMETRES_PIXELS_MIN = 250;
    public static final int HAUTEUR_PARAMETRES_PIXELS_MIN = 500;

    public static final int LARGEUR_PARAMETRES_PIXELS = 300;
    public static final int HAUTEUR_PARAMETRES_PIXELS = 520;

    public static final int LARGEUR_PARAMETRES_PIXELS_MAX = 350;
    public static final int HAUTEUR_PARAMETRES_PIXELS_MAX = 540;
    
	public static final int LARGEUR_REPLAY_PIXELS_MIN = 200;
    public static final int HAUTEUR_REPLAY_PIXELS_MIN = 200;

    public static final int LARGEUR_REPLAY_PIXELS = 586;
    public static final int HAUTEUR_REPLAY_PIXELS = 602;

    public static final int LARGEUR_REPLAY_PIXELS_MAX = 600;
    public static final int HAUTEUR_REPLAY_PIXELS_MAX = 600;
    
    

}
