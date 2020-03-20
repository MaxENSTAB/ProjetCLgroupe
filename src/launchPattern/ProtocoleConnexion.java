package launchPattern;

import servPattern.IContext;
import GUI.ChatroomGUI;
import servPattern.IProtocole;

import javax.swing.*;

import client.ClientTCP;

import java.io.*;
import java.util.ArrayList;


public class ProtocoleConnexion implements IProtocole {
	
	private ArrayList ListClients = new <ClientTCP>ArrayList();

	
    public ProtocoleConnexion() {
    }

    public void execute(IContext c , InputStream unInput , OutputStream unOutput) {
    	
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

                
                File database_user = new File ("C:\\Users\\Pauline_2\\Downloads\\ProjetCLgroupe-MaxENSTAB-patch-1\\database_user.txt");
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

                if (status.contentEquals("admin")) {
                	ListClients.add(logins);
                	System.out.println(ListClients);
                    ProtocoleConnexionAdmin Protocole1 = new ProtocoleConnexionAdmin(c, unInput, unOutput) ;
                    valeurExpediee = Protocole1.getValeurExpediee();
                    Protocole1.execute(c, unInput, unOutput);

                    ProtocoleChat Chatroom = new ProtocoleChat(c, unInput, unOutput);
                    while(status.contentEquals("admin")){
                    Chatroom.execute(c, unInput, unOutput);}
                    

                }
                if (status.contentEquals("user")){
                	ListClients.add(logins);
                	System.out.println(ListClients);
                    ProtocoleConnexionUser Protocole2 = new ProtocoleConnexionUser(c, unInput, unOutput);
                    valeurExpediee = Protocole2.getValeurExpediee();
                    Protocole2.execute(c, unInput, unOutput);

                    ProtocoleChat Chatroom = new ProtocoleChat(c, unInput, unOutput);       //On rentre dans la chatroomm
                    while(status.contentEquals("user")){
                    Chatroom.execute(c, unInput, unOutput);}
//TODO pour l'instant les admins et les users ont les memes droits, c'est plus tard qu'on implémentera les pouvoirs de l'admin
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
