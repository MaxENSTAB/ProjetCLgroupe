package launchPattern;

import servPattern.IContext;
import servPattern.IProtocole;

import java.io.*;

public class ProtocoleConnexionUser extends ProtocoleConnexion {


    private String valeurExpediee;

    
    public ProtocoleConnexionUser(IContext c , InputStream unInput , OutputStream unOutput) {

        valeurExpediee = "success";
        System.out.println(" Reponse serveur "	+ valeurExpediee);
        
        

    }
    

    public String getValeurExpediee(){return valeurExpediee;}

}
