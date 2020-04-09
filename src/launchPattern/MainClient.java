package launchPattern;

import client.ClientTCP;

import GUI.ChatroomGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import javax.swing.WindowConstants;



public class MainClient {
	

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {

		String chat = "ok";
		ClientTCP myClt = new ClientTCP("localhost", 6666 ); //Création d'un nouveau client...
				
		if ( myClt.connecterAuServeur() ) {
			
			System.out.println("Rentre ton 'login pwd' \n");
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(System.in));
			String logins = reader.readLine();
			myClt.transmettreChaine(logins);  //Transmet les logins au serveur pour vérification
			String login = logins.split(" ")[0];
			myClt.recupchaine(); //Récupère la réponse serveur
			myClt.setNomClient(login);
			// une fois connect� : 
			ChatroomGUI MonGUI = new ChatroomGUI();  	//... et de sa chatroom dans l'IHM
			MonGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			LireMessage liremessage = new LireMessage(myClt, MonGUI);

	
			
			while(chat=="ok") {
				
				System.out.println("Tu es maintenant sur le chat. Ecris ce que tu veux. \n");
				String message = "init";
				String quitter = "quitter";
				 
			
				liremessage.start();	// On vérifie constamment si le serveur nous envoie quelque chose
			
				
				
				while (message  != null) {
					
					message = reader.readLine();
					if (message.contentEquals(quitter)) {		//Permet de se déconnecter proprement
						liremessage.stop();
						myClt.deconnecterDuServeur();
						
						chat = "break";
						
				
					}
					myClt.transmettreChaine(message);		//Envoie les messages du client
					
					};
			}
		myClt.deconnecterDuServeur();

		}

		

		

	
	}

}
