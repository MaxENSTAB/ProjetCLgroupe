package launchPattern;

import servPattern.IContext;
import servPattern.IProtocole;

import javax.swing.*;
import java.io.*;

public class ProtocoleConnexion implements IProtocole {
    public ProtocoleConnexion() {
    }

    public void execute(IContext c , InputStream unInput , OutputStream unOutput ) {

        String logins;
        BufferedReader is = new BufferedReader(new InputStreamReader(
                unInput));
        PrintStream os = new PrintStream(unOutput);
        try {
            String valeurExpediee = "";


            if ((logins = is.readLine()) != null) {
                System.out.println(" Login Recu " + logins);
                String chaines[] = logins.split(" ");

                if (chaines[0].contentEquals("admin")) {
                    ProtocoleConnexionAdmin Protocole = new ProtocoleConnexionAdmin() ;
                    valeurExpediee = Protocole.getValeurExpediee();
                }
                else if (chaines[0].contentEquals("user")){ // TODO : lire un fichier texte pour entrer dans la sous classe user
                    ProtocoleConnexionUser Protocole = new ProtocoleConnexionUser();
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
