package launchPattern;

import servPattern.IContext;
import GUI.ChatroomGUI;
import servPattern.IProtocole;

import java.io.*;

public class ProtocoleConnexionUser extends ProtocoleConnexion {

    private String valeurExpediee;
    private InputStream sockin;
    private OutputStream sockout;

    public ProtocoleConnexionUser(IContext c , InputStream unInput , OutputStream unOutput) {

        valeurExpediee = "User success";
        System.out.println(" Reponse serveur success ? " + valeurExpediee);

        sockin = unInput;
        sockout = unOutput;
        }

        public void execute(IContext c , InputStream sockin , OutputStream sockout ) {
            PrintStream os = new PrintStream(sockout);     // On écrit sur la socket pour préciser au client qu'il est bien dans le Chat
            os.println("Bienvenue dans le Chat cher User!");
        }
        

    public String getValeurExpediee(){return valeurExpediee;}
}