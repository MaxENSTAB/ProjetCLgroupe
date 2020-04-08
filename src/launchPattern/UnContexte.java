package launchPattern;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import client.ClientTCP;
import servPattern.IContext;



/**
 * @author Pauline Beaujard
 *
 */
public class UnContexte implements IContext {
	private Hashtable<String, ProtocoleConnexion> DicProtocole = new Hashtable<String, ProtocoleConnexion>();
	private Hashtable<String, InputStream> DicInput = new Hashtable<String, InputStream>();
	private Hashtable<String, OutputStream> DicOutput = new Hashtable<String, OutputStream>();
	private ArrayList<String> ListMessages = new ArrayList<String>();
	


	public UnContexte() {
	    }
	
	public void add(String login, ProtocoleConnexion protocole, InputStream unInput , OutputStream unOutput) {
		DicProtocole.put(login, protocole);
		DicInput.put(login, unInput);
		DicOutput.put(login, unOutput);
	}
	
	public void addMessages(String message) {
		ListMessages.add(message);
	}
	public void remove(String login) {
		DicProtocole.remove(login);
		DicInput.remove(login);
		DicOutput.remove(login);
	}
	
	public void clearList() {
		ListMessages.clear();
	}

	public Hashtable getDicProtocole() {
		return DicProtocole;
	}

	public Hashtable getDicInput() {
		return DicInput;
	}

	public Hashtable getDicOutput() {
		return DicOutput;
	}

	public ProtocoleConnexion getProtocole(String login) {
		return (ProtocoleConnexion) DicProtocole.get(login);
	}
	
	public InputStream getInput(String login) {
		return (InputStream) DicInput.get(login);  
	}
	
	public OutputStream getOutput(String login) {
		return (OutputStream) DicOutput.get(login);
	}

	public ArrayList getListMessages() {
		return ListMessages;
	}
	
	

}
