package launchPattern;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

import servPattern.IContext;
import servPattern.IProtocole;


public class ProtocolePingPong implements IProtocole {

	public void execute( IContext c , InputStream unInput , OutputStream unOutput ) {
		
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
					valeurExpediee = "success";
					System.out.println(" Reponse serveur "	+ valeurExpediee);
				}
				os.println(valeurExpediee);
			}
		} catch ( Exception e) {
			System.out.println(" Pb d'exception ");
		}			
	}
}
