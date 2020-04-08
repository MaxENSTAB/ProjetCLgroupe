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
    	
    	//System.out.println(contexte.getListProtocole());

        String loginspwd;
        BufferedReader is = new BufferedReader(new InputStreamReader(
                unInput));
        PrintStream os = new PrintStream(unOutput);
        try {
            String valeurExpediee = "";

            if ((loginspwd = is.readLine()) != null) {
            	String logins = loginspwd.split(" ")[0];
            	String pwd =  loginspwd.split(" ")[1];
            	
                System.out.println(" Login Recu " + logins);
                String chaines[] = logins.split(" ");
                
                File database_user = new File ("C:\\Users\\Pauline_2\\OneDrive - Ecole Nationale Supérieure de Techniques Avancées Bretagne\\COURS\\UE 4.2 - Traitement de l'information\\Conception logicielle\\ProjetCLgroupe-encours\\database_user.txt");
            	BufferedReader br = new BufferedReader(new FileReader(database_user));
            	
            	

            	String line = "";
            	String status = "";
            	while ((line = br.readLine()) != null) {
            	
            		String[] decompose = line.split(" ");
            		if (decompose[0].contentEquals(logins)){
            			if (decompose[1].contentEquals(pwd)) {
            				status = decompose[2];
            			}
            		}
            	}
            	br.close();
            	
            	
            	contexte.add(logins, this, unInput, unOutput);

            	
                if (status.contentEquals("admin")) {

                    ProtocoleConnexionAdmin Protocole1 = new ProtocoleConnexionAdmin(c, unInput, unOutput) ;
                    valeurExpediee = Protocole1.getValeurExpediee();
                    Protocole1.execute(c, unInput, unOutput);
 
                    //pas a faire en fait
                    //TODO : faire protocole(thread?) lire chat (il tourne en boucle)
                    //TODO : comment acceder aux messages de tout le monde dans le thread ? 
                    //TODO : faire protocole envoye chat = Protocolechat
                    //TODO : en gros separer les 2 et que un tourne en boucle et pas l'autre
                  
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
//TODO pour l'instant les admins et les users ont les memes droits, c'est plus tard qu'on implÃ©mentera les pouvoirs de l'admin
                }

                else { // la connexion s'arrete
                    valeurExpediee = "failure";
                    System.out.println(" Reponse serveur "	+ valeurExpediee);
                    
                }
                //os.println(valeurExpediee);
                
                
            
            }
        } catch ( Exception e) {
            System.out.println(" Pb d'exception ");
        }
    }

}
