package launchPattern;

import servPattern.IContext;
import java.util.Set;
import java.util.Iterator;

import GUI.ChatroomGUI;
import servPattern.IProtocole;
import java.util.Observable;

import javax.swing.WindowConstants;

import java.io.*;

public class ProtocoleChat extends Observable {




    public ProtocoleChat(IContext c, String login) {

    }
    public void execute(IContext c, String login) throws IOException {
    	UnContexte contexte = (UnContexte) c;
    	
    	
        String message;
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                contexte.getInput(login)));
        message = reader.readLine();
        System.out.println(message);
        
        Set keys = contexte.getDicOutput().keySet();
        Iterator i = keys.iterator();
        String key = "";
        PrintStream os;
        while (i.hasNext()) {
        	key = (String) i.next();
        	System.out.println(key);
        	
        	os = new PrintStream(contexte.getOutput(key));
        	System.out.println(os);
            os.println(message);
            //MonGUI.setTestField(message);
        }
        
  





    }
}

//TODO : ce fichier est tout nouveau, et c'est ici que les messages sont gérés par le serveur.
