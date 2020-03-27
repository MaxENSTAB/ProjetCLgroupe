package launchPattern;

import javax.swing.WindowConstants;

import GUI.ChatroomGUI;
import servPattern.ServeurTCP;

public class MainServeur {
	
	
	public static void main(String[] args) {
		UnContexte contexte = new UnContexte();
		ServeurTCP myServ = new ServeurTCP(contexte , new ProtocoleConnexion() , 6666 );
		myServ.start();
	}
}

//TODO : Rien changé ici