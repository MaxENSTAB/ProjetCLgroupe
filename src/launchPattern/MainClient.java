package launchPattern;

import client.ClientTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainClient {

	public static void main(String[] args) throws IOException {
		ClientTCP myClt = new ClientTCP("localhost", 6666 );
		
		if ( myClt.connecterAuServeur() ) {
			System.out.println("Rentre ton login \n");
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(System.in));
			String login = reader.readLine();
			myClt.transmettreChaine(login);  //Pouloulou

			myClt.deconnecterDuServeur();
		}
	
	}

}
