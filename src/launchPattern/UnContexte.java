package launchPattern;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

import client.ClientTCP;
import servPattern.IContext;



public class UnContexte implements IContext {
	private Hashtable DicProtocole = new Hashtable();
	private Hashtable DicInput = new Hashtable();
	private Hashtable DicOutput = new Hashtable();


	public UnContexte() {
	    }
	
	public void add(String login, ProtocoleConnexion protocole, InputStream unInput , OutputStream unOutput) {
		DicProtocole.put(login, protocole);
		DicInput.put(login, unInput);
		DicOutput.put(login, unOutput);
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
	
	

}
