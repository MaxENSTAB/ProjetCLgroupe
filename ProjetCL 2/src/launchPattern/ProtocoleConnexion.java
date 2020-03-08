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

                
                File database_user = new File ("U:\\Conception logicielle\\ProjetCL\\database_user.txt");
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
                    ProtocoleConnexionAdmin Protocole = new ProtocoleConnexionAdmin(c, unInput, unOutput) ;
                    valeurExpediee = Protocole.getValeurExpediee();
                }
                else if (status.contentEquals("user")){ 
                    ProtocoleConnexionUser Protocole = new ProtocoleConnexionUser(c, unInput, unOutput);
                    valeurExpediee = Protocole.getValeurExpediee();
                }

                else { // la connexion s'arrete
                    valeurExpediee = "failure";
                    System.out.println(" Reponse serveur "	+ valeurExpediee);

                }
                os.println(valeurExpediee);
                
                
            
            }
        } catch ( Exception e) {
            System.out.println(" Pb d'exception ");
        }
    }

}
