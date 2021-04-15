

package GO.serveur;

import ntro.debogage.J;
import static GO.Constantes.*;

import java.io.IOException;

public class MonServeur {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		J.appel(MonServeur.class);
		
		demarrerServeur();
	}
	
	private static void demarrerServeur() throws IOException, InterruptedException {
		J.appel(MonServeur.class);
		
		MonServeurWebSocket serveur = new MonServeurWebSocket(PORT);
		serveur.start();
	
		
        System.out.println("\n\nAppuyer sur Entrée pour quitter...");
        
        System.in.read();
        
        serveur.stop();
	}

}
