package clienserver.tests.unitaires;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import client.TCPClient;

public class TestTCPClient {

	@Test
	public void testClient() {
		TCPClient myClient = new TCPClient("localhost", 6666);
		assertNotNull(myClient);
	}
	
}
