package clientserver.tests.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import client.TCPClient;
import server.TCPServer;

@RunWith(Parameterized.class)
public class TestCommunication {

	static TCPServer aServer;
	static TCPClient client1;
	
	private ArrayList<String> messages;
	private int result;
	
	// Chaque parametre est un argument, A  chaque test une nouvelle valeur est donnee.
	public TestCommunication(ArrayList<String> messages, int result) {
	    this.messages = messages;
	    this.result = result;
	}
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class");
		aServer = new TCPServer( 5678 );
		client1 = new TCPClient("localhost", 5678);
		aServer.start();
	}
			
	@AfterClass
	public static void afterClass(){
		System.out.println("after class");
		aServer.arret();
	}
	
	@Test
	public void testCommunications() {
		System.out.println("Test transmissions");
		try {
			client1.connectToServer();
		
			for(String message : messages){
				client1.stringTransmitOnly(message);
			}
			
			System.out.println("Sur le compte : " + aServer.getMonCompte().getVariablePartagee() + 
					" , Espere : " + result);
			
			assertEquals(aServer.getMonCompte().getVariablePartagee(), result);
			
			client1.disconnectFromServer();
		} catch (Exception e) {
			fail();
		}
		
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> scenarios() {
		ArrayList<String> scenario1 = new ArrayList<String>();
		scenario1.add("send something");
		scenario1.add("demandeRetrait");
		scenario1.add("demandeDepot");
		scenario1.add("stop");
		
		ArrayList<String> scenario2 = new ArrayList<String>();
		scenario2.add("send something");
		scenario2.add("demandeDepot");
		scenario2.add("demandeRetrait");
		scenario2.add("stop");
		
		ArrayList<String> scenario3 = new ArrayList<String>();
		scenario3.add("demandeDepot");
		scenario3.add("demandeDepot");
		scenario3.add("stop");
		
		
	      return Arrays.asList(new Object[][] {
	         { scenario1, 5000 },
	         { scenario2, 5000 },
	         { scenario3, 5020 }
	      });
	   }
}
