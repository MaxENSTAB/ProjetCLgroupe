package servPattern;

import launchPattern.ProtocoleConnexion;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

public interface IContext {

    public void add(String login, ProtocoleConnexion protocole, InputStream unInput , OutputStream unOutput);
    public void addMessages(String message);
    public void remove(String login);
    public void clearList();
    public Hashtable getDicProtocole();
    public Hashtable getDicInput();
    public Hashtable getDicOutput();
    public ProtocoleConnexion getProtocole(String login);
    public InputStream getInput(String login);
    public OutputStream getOutput(String login);
    public ArrayList getListMessages();

}
