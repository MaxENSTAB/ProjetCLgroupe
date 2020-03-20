package launchPattern;

import servPattern.IContext;
import GUI.ChatroomGUI;
import servPattern.IProtocole;
import java.util.Observable;

import javax.swing.WindowConstants;

import java.io.*;

public class ProtocoleChat extends Observable implements IProtocole {
    private InputStream msgIn;
    private OutputStream msgOut;
    private ChatroomGUI chatroom;


    public ProtocoleChat(IContext c ,InputStream msgIn, OutputStream msgOut ) {
        this.msgOut = msgOut;
        //this.chatroom = chat;

    }
    public void execute(IContext c ,InputStream msgIn, OutputStream msgOut ) throws IOException {

        String message;
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                msgIn));
        PrintStream os = new PrintStream(msgOut);

        message = reader.readLine();
        System.out.println(message);
        os.println(message);
        // chatroom.setTestField(message);




    }
}

//TODO : ce fichier est tout nouveau, et c'est ici que les messages sont gérés par le serveur.
