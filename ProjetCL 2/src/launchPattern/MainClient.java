package launchPattern;

import client.ClientTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainClient {

	public static void main(String[] args) throws IOException {
		ArrayList ListClients = new <ClientTCP>ArrayList();
		
		ClientTCP myClt = new ClientTCP("localhost", 6666 );
		
		if ( myClt.connecterAuServeur() ) {
			ListClients.add(myClt);
			System.out.println("Rentre ton 'login pwd' \n");
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(System.in));
			String login = reader.readLine();
			myClt.transmettreChaine(login);  //Pouloulou
			
			System.out.println("Qui est ton pote ? \n");
			String copain = reader.readLine();
			myClt.transmettreChaine(copain);
			
	
			myClt.deconnecterDuServeur();
		}
		

	
	}

}
