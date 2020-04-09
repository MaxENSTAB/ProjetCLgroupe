package launchPattern;

import servPattern.IContext;

import GUI.ChatroomGUI;
import servPattern.IProtocole;

import javax.swing.*;

import client.ClientTCP;

import java.io.*;
import java.util.ArrayList;
import launchPattern.UnContexte;


public class ProtocoleConnexion implements IProtocole {


	
    public ProtocoleConnexion() {
    	
    }

    public void execute(IContext c , InputStream unInput , OutputStream unOutput) {
    	UnContexte contexte = (UnContexte) c;


        String loginspwd;
        BufferedReader is = new BufferedReader(new InputStreamReader(
                unInput));
        //PrintStream os = new PrintStream(unOutput);
        try {
            String valeurExpediee = "";

            if ((loginspwd = is.readLine()) != null) {
            	String logins = loginspwd.split(" ")[0];
            	String pwd =  loginspwd.split(" ")[1];
            	
                System.out.println(" Login Recu " + logins);
                String chaines[] = logins.split(" ");


                // Attention à bien changer le chemin correspondant au fichier database_user.txt
                File database_user = new File ("/Users/MaximeBarret/Downloads/ProjetCLgroupe-popsita-patch-1/database_user.txt");
            	BufferedReader br = new BufferedReader(new FileReader(database_user));


            	String line = "";
            	String status = "";
            	while ((line = br.readLine()) != null) {
            	
            		String[] decompose = line.split(" ");
            		if (decompose[0].contentEquals(logins)){
            			if (decompose[1].contentEquals(pwd)) {
            				status = decompose[2];      //Détermine si le statut du login : user ou admin
            			}
            		}
            	}
            	br.close();
            	
            	
            	contexte.add(logins, this, unInput, unOutput);

            	//Différentiation entre User et Admin
            	
                if (status.contentEquals("admin")) {

                    ProtocoleConnexionAdmin Protocole1 = new ProtocoleConnexionAdmin(c, unInput, unOutput) ;
                    valeurExpediee = Protocole1.getValeurExpediee();
                    Protocole1.execute(c, unInput, unOutput);
                  
                    ProtocoleChat Chatroom = new ProtocoleChat(c, logins);
                    while(status.contentEquals("admin")){
                    Chatroom.execute(c, logins);} 

                }
                if (status.contentEquals("user")){

                    ProtocoleConnexionUser Protocole2 = new ProtocoleConnexionUser(c, unInput, unOutput);
                    valeurExpediee = Protocole2.getValeurExpediee();
                    Protocole2.execute(c, unInput, unOutput);

                    ProtocoleChat Chatroom = new ProtocoleChat(c, logins);       //On rentre dans la chatroomm
                    while(status.contentEquals("user")){
                    Chatroom.execute(c, logins);}
                    //Les admins et les users ont les memes droits, nous avons manqué de temps pour implémenter les propriétés propres aux administrateurs
                }

                else { // la connexion s'arrete
                    valeurExpediee = "failure";
                    System.out.println(" Reponse serveur success ?"	+ valeurExpediee);
                    
                }

            
            }
        } catch ( Exception e) {
            System.out.println(" Pb d'exception ");
        }
    }

}
