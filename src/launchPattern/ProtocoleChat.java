package launchPattern;

import servPattern.IContext;
import servPattern.IProtocole;

import java.io.*;

public class ProtocoleChat implements IProtocole {
    private InputStream msgIn;
    private OutputStream msgOut;


    public ProtocoleChat(IContext c ,InputStream msgIn, OutputStream msgOut ) {
        this.msgOut = msgOut;
    }
    public void execute(IContext c ,InputStream msgIn, OutputStream msgOut ) throws IOException {

        String message;
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                msgIn));
        PrintStream os = new PrintStream(msgOut);

        message = reader.readLine();
        System.out.println(message);
        os.println(message);




    }
}

//TODO : ce fichier est tout nouveau, et c'est ici que les messages sont gérés par le serveur.
