package launchPattern;

import servPattern.IContext;

import servPattern.IProtocole;

import java.io.*;

import GUI.ChatroomGUI;

public class ProtocoleConnexionAdmin extends ProtocoleConnexion {

    private String valeurExpediee;
    private InputStream sockin;
    private OutputStream sockout;

    public ProtocoleConnexionAdmin(IContext c , InputStream unInput , OutputStream unOutput) {

        valeurExpediee = "Admin success";
        System.out.println(" Reponse serveur success ? "	+ valeurExpediee);

        sockin = unInput;
        sockout = unOutput;
    }

    public void execute(IContext c , InputStream sockin , OutputStream sockout) {
        PrintStream os = new PrintStream(sockout);
        os.println("Bienvenue dans le Chat cher Admin !");
    }


    public String getValeurExpediee(){return valeurExpediee;}
}

//TODO : Ici on dit juste qu'on rentre dans le chat, en tant qu'admin.  c'est sûrement ici qu'on implémentera des trucs utiles aux admins.