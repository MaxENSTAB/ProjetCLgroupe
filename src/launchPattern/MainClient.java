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
		ClientTCP myClt = new ClientTCP("localhost", 6666 );
				
		if ( myClt.connecterAuServeur() ) {
			
			System.out.println("Rentre ton 'login pwd' \n");
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(System.in));
			String logins = reader.readLine();
			myClt.transmettreChaine(logins);  
			String login = logins.split(" ")[0];
			myClt.recupchaine();
			
			// une fois connecté : 
			ChatroomGUI MonGUI = new ChatroomGUI();  
			MonGUI.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			LireMessage liremessage = new LireMessage(myClt, MonGUI);

	
			
			while(chat=="ok") {
				
				System.out.println("Tu es maintenant sur le chat. Ecris ce que tu veux. \n");
				String message = "init";
				String quitter = "quitter";
				 
			
				liremessage.start();
			
				
				
				while (message  != null) {
					
					message = reader.readLine();
					if (message.contentEquals(quitter)) {
						liremessage.stop();
						myClt.deconnecterDuServeur(login); //TODO : revoir la fonction parce que pas vraiment deconnecté
						
						chat = "break";
						
				
					}
					myClt.transmettreChaine(message);
					
					};
			}


		}

		

		

	
	}

}
