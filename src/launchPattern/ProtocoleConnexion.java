package launchPattern;

import servPattern.IContext;
import servPattern.IProtocole;

import javax.swing.*;
import java.io.*;

public class ProtocoleConnexion implements IProtocole {
    public ProtocoleConnexion() {
    }

    public void execute(IContext c , InputStream unInput , OutputStream unOutput ) {

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

                
                File database_user = new File ("/Users/MaximeBarret/Desktop/ENSTA 2A/S4/UE 4.2/ProjetCL/database_user.txt");
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

                    ProtocoleConnexionAdmin Protocole1 = new ProtocoleConnexionAdmin(c, unInput, unOutput) ;
                    valeurExpediee = Protocole1.getValeurExpediee();
                    Protocole1.execute(c, unInput, unOutput);

                    ProtocoleChat Chatroom = new ProtocoleChat(c, unInput, unOutput);
                    while(status.contentEquals("admin")){
                    Chatroom.execute(c, unInput, unOutput);}


                }
                if (status.contentEquals("user")){

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
