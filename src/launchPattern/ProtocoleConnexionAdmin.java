package launchPattern;

import servPattern.IContext;
import servPattern.IProtocole;

import java.io.*;

public class ProtocoleConnexionAdmin extends ProtocoleConnexion {

    private String valeurExpediee;
    
    private InputStream sockin;
    private OutputStream sockout;

    public ProtocoleConnexionAdmin(IContext c , InputStream unInput , OutputStream unOutput) {

        valeurExpediee = "success";
        System.out.println(" Reponse serveur "	+ valeurExpediee);
        sockin = unInput;
        sockout = unOutput;
    }

    public void execute(IContext c , InputStream unInput , OutputStream unOutput ) {
    	
    	// fonction qui envoie un message commun a tous les clients de la liste ListClients
    	String message;
        BufferedReader is = new BufferedReader(new InputStreamReader(
                unInput));
        PrintStream os = new PrintStream(unOutput);
        System.out.println("ProtocoleConnexionAdmin.execute");
        try {
        	System.out.println("system print là");
        	os.println("l'os affiche là");
            if ((message = is.readLine()) != null) {
            	os.println(message);
            }
            }
        catch ( Exception e) {
            System.out.println(" Pb d'exception ");
        }
        
    }



    public String getValeurExpediee(){return valeurExpediee;}
}
