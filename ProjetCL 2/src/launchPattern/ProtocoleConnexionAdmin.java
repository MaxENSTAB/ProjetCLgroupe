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

    public void SendMessage() {
    	
    	// fonction qui envoie un message commun a tous les clients de la liste ListClients
    	
    }



    public String getValeurExpediee(){return valeurExpediee;}
}
