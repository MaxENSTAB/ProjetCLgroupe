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
            PrintStream os = new PrintStream(sockout);
            os.println("Bienvenue dans le Chat cher user!");
        }
        

    public String getValeurExpediee(){return valeurExpediee;}
}

//TODO sombre copy/paste du admin, mais pour l'instant, je crois qu'on s'en fout.