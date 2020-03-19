package launchPattern;

import servPattern.IContext;
import servPattern.IProtocole;

import java.io.*;

public class ProtocoleConnexionAdmin extends ProtocoleConnexion implements IProtocole {

    private String valeurExpediee;

    public ProtocoleConnexionAdmin() {

        valeurExpediee = "success";
        System.out.println(" Reponse serveur "	+ valeurExpediee);
    }




    public String getValeurExpediee(){return valeurExpediee;}
}
