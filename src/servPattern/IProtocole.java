package servPattern;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import GUI.ChatroomGUI;
public interface IProtocole {

	public void execute( IContext aContext , InputStream anInputStream , OutputStream anOutputStream) throws IOException;
	
}
