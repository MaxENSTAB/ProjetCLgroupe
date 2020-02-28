package clienserver.tests.unitaires;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import server.TCPServer;

public class TestTCPServer {
	
	static TCPServer aServer;
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("before class");
		aServer = new TCPServer( 5555 );
	}
			
	@AfterClass
	public static void afterClass(){
		System.out.println("after class");
		aServer.arret();
	}
	
	@Before
	public void before() {
		System.out.println("before");
	}

	@After
	public void after() {
		System.out.println("after");
	}

	@Test
	public void testRunServerStarted() {
		assertNotNull(aServer);
		aServer.start();
		assertTrue(aServer.isAlive());
	}
	
	@Test
	public void testAccountIsCreated() {
		assertNotNull(aServer.getMonCompte());
	}
	
}
