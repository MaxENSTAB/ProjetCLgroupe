package launchPattern;

import servPattern.IContext;
import java.util.Set;
import java.util.ArrayList;
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
    	String user = login;
        String message; 
        String message_user;
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                contexte.getInput(login)));
        ArrayList list = new ArrayList();
        int size =0;
        
        while((message = reader.readLine()) != null) {

	        
	        message_user = user + ":" + message;
	        contexte.addMessages(message_user);
	        Set keys = contexte.getDicOutput().keySet();
	        Iterator i = keys.iterator();
	        String key = "";
	        PrintStream os;
	        list = contexte.getListMessages();

	        while (i.hasNext()) {

	        	key = (String) i.next();
		        if (message.contentEquals(key + " se deconnecte")) {
		        	contexte.remove(key);
		        }
	        	os = new PrintStream(contexte.getOutput(key));
	        	size = list.size();
	        	for (int j = 0;j<size;j++) {
	        		os.println(list.get(j));
	        		
	        		//TODO : parcourir la liste 
	        		//TODO: tant qu'on a des messages dans la liste on les envoie et quand yen a plus on met fin de liste.
	        	}
	        	os.println("fin");
	
	            //MonGUI.setTestField(message);
	        
	        }
	        contexte.clearList();
        }
        
  





    }
}

//TODO : ce fichier est tout nouveau, et c'est ici que les messages sont gérés par le serveur.
