package clienserver.tests.unitaires;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import client.ClientTCP;

public class TestTCPClient {

	@Test
	public void testClient() {
		ClientTCP myClient = new ClientTCP("localhost", 6666);
		assertNotNull(myClient);
	}
	
}
