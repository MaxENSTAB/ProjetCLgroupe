package launchPattern;



import GUI.ChatroomGUI;
import client.ClientTCP;



public class LireMessage extends Thread {
	private ClientTCP client;
	private String messageserveur;
	private ChatroomGUI MonGUI;
	String chat = "ok";


	public LireMessage(ClientTCP myClt, ChatroomGUI chat) {
		client = myClt;
		MonGUI = chat;
		
	    }
	 
	public void run() {  
		while (chat=="ok") {
		messageserveur = client.recupchaine();
		if (!messageserveur.equals("fin")){
			if (!messageserveur.equals("quitter")){
				MonGUI.ajouterMessage(messageserveur);
			}
		} 
		
		}
		}
		
		
	

		
		
	} 
	

