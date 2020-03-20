package launchPattern;

import client.ClientTCP;
import GUI.ChatroomGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.WindowConstants;



public class MainClient {
	
	public static void main(String[] args) throws IOException {

		String chat = "ok";
		ClientTCP myClt = new ClientTCP("localhost", 6666 );

		ChatroomGUI MonGUI = new ChatroomGUI();  
		MonGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		System.out.println("je genere une chatroom");
		
		if ( myClt.connecterAuServeur() ) {

			System.out.println("Rentre ton 'login pwd' \n");
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(System.in));
			String login = reader.readLine();
			myClt.transmettreChaine(login);  //Pouloulou

			while(chat=="ok") {

				String message;
				message = reader.readLine();
				if (message == "quitter") {
					myClt.deconnecterDuServeur();
				}

				myClt.transmettreChaine(message);
				
				//TODO : c'est ici que le client envoie son message au serveur, et ça sera au serveur de redistribuer

				MonGUI.setTestField(message);


			/*for(int i = 0; i<ListClients.size(); i++) {
				ClientTCP client = ListClients.get(i);
				client.transmettreChaine(message);
			}*/				//TODO : dans cette boucle for, j'ai essayé de parcourir tous les clients du serveur, ce que je trouve bizarre, cf todo du dessus
							//TODO : Il faudrait plutot essayer de le faire à un endroit où on a accès au nombre de personnes connectées.

			}

			//System.out.println("Saisir texte \n");
			//String texte = reader.readLine();
			//myClt.transmettreChaine(texte);
		}

		

		myClt.deconnecterDuServeur();
		

	
	}

}
