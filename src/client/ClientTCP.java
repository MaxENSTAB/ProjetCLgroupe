package client;

import java.io.*;
import java.net.*;

public class ClientTCP {

	private int numeroPort;

	private String nomServeur;

	private Socket socketServeur;

	private PrintStream socOut;

	private BufferedReader socIn;	
	
	/** Un client se connecte a un serveur identifie par un nom (unNomServeur), sur un port unNumero */
	public  ClientTCP(String unNomServeur, int unNumero) {        
		numeroPort = unNumero;
		nomServeur = unNomServeur;
	} 

	public boolean connecterAuServeur() {        
		boolean ok = false;
		try {
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
		return ok;
	} 	
	
	public void deconnecterDuServeur(String login) {        
		try {
			System.out.println("[ClientTCP] CLIENT : " + socketServeur);
			socOut.println(login + " se deconnecte");
			socOut.close();
			socIn.close();
			socketServeur.close();
			System.exit(0);
		} catch (Exception e) {
			System.err.println("Exception lors de la deconnexion :  " + e);
		}
	} 	
	
	public String transmettreChaine(String uneChaine) {        
		String msgServeur = null;

			socOut.println( uneChaine );
			socOut.flush();

		return msgServeur;
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
