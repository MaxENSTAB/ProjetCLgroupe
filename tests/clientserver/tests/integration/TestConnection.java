package clientserver.tests.integration;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.ConnectException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import client.ClientTCP;
import servPattern.ServeurTCP;

public class TestConnection {

	static ServeurTCP aServer;
	
	static ClientTCP client1;
	static ClientTCP client2;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class");
		aServer = new ServeurTCP( 3456 );
		assertNotNull(aServer);
		aServer.start();
		
		client1 = new ClientTCP("localhost", 3456);
		client2 = new ClientTCP("localhost", 8888);
	}
			
	@SuppressWarnings("deprecation")
	@AfterClass
	public static void afterClass(){
		System.out.println("after class");
		aServer.stop();
	}

	@Test
	public void testSimpleConnections() {
		assertNotNull(aServer);
		try {
			assertTrue(client1.connecterAuServeur());
			client1.deconnecterDuServeur();;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
}
