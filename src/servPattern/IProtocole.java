package servPattern;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import GUI.ChatroomGUI;
public interface IProtocole {

	//On utilise le pattern strategy : Nous avons beaucoup de cas de figure différents, et pour respecter le S de SOLID, nous avons
	//utilisé plusieurs protocoles, dérivant de cette interface.
	// Protocole Connexion pour se connecter, et qui selon le contexte va executer les protocoles Connexion Admin ou User.
	// Protocole Chat pour la discussion en elle même

	public void execute( IContext aContext , InputStream anInputStream , OutputStream anOutputStream) throws IOException;
	
}
