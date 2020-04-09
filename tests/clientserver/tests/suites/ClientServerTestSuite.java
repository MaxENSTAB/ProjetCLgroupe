package clientserver.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import clienserver.tests.unitaires.TestTCPClient;
import clienserver.tests.unitaires.TestTCPServer;

import clientserver.tests.integration.TestConnection;

@RunWith(Suite.class)

@Suite.SuiteClasses({
   TestTCPClient.class,
   TestTCPServer.class,
   TestConnection.class,

})

public class ClientServerTestSuite {   
}  	