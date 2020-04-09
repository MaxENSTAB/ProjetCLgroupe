package client;

import java.io.*;
import java.net.*;

public class ClientTCP {

	private int numeroPort;

	private String nomServeur;

	private Socket socketServeur;

	private PrintStream socOut;

	private BufferedReader socIn;

	private String nomClient;


	/** Un client se connecte a un serveur identifie par un nom (unNomServeur), sur un port unNumero */
	public  ClientTCP(String unNomServeur, int unNumero) {        
		numeroPort = unNumero;
		nomServeur = unNomServeur;

	}

	public boolean connecterAuServeur() {        
		boolean ok = false;
		try {		//Permet de gérer les exceptions, comme par exemple les cas où les logins sont erronés.
					//Les cas où il peut y avoir des exceptions sont listés dans les 'catch'
			String login = new String();
			String pwd = new String();
			System.out.println("Tentative : " + nomServeur + " -- " + numeroPort);
			socketServeur = new Socket( nomServeur, numeroPort);
			socOut = new PrintStream(socketServeur.getOutputStream());
			socIn = new BufferedReader ( 
					new InputStreamReader (socketServeur.getInputStream()));
			ok = true;
		} catch (UnknownHostException e) {
			System.err.println("Serveur inconnu : " + e);

		} catch (ConnectException e) {
			System.err.println("Exception lors de la connexion:" + e);
			e.printStackTrace();

		} catch (IOException e) {
			System.err.println("Exception lors de l'echange de donnees:" + e);
		}
		System.out.println("Connexion faite");
		return ok; //True si la connexion au serveur est faite, False si une exception a été 'attrapée'
	} 	
	
	public void deconnecterDuServeur() {
		try {
			System.out.println("[ClientTCP] CLIENT : " + socketServeur);
			socOut.println(nomClient + " se deconnecte");
			socOut.close();
			socIn.close();
			socketServeur.close();			//On ferme le reader, le printer et la socket liés au client.
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Exception lors de la deconnexion :  " + e);
		}
	} 	
	
	public String transmettreChaine(String uneChaine) {
		//C'est cette méthode qui va permettre d'envoyer un message à tous les clients connectés, via le serveur
		String msgServeur = null;

			socOut.println( uneChaine );	// on écrit sur la socket
			socOut.flush();					// et on 'force' l'envoi

		return msgServeur;
	}


	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String recupchaine() {        
		String msgServeur = null;
		String fin = "fin";
		try {
			msgServeur = socIn.readLine();
			if (!msgServeur.equals(fin)) {
				if (!msgServeur.equals("quitter")) {
					System.out.println( msgServeur ); 
				}
			
			}

			
		} catch (UnknownHostException e) {
			System.err.println("Serveur inconnu : " + e);
		} catch (IOException e) {
			System.err.println("Exception entree/sortie:  " + e);
			e.printStackTrace();
		}
		return msgServeur;
	}


}
