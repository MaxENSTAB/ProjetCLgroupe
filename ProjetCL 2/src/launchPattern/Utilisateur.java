package launchPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Utilisateur {
    private String login;
    private String pwd;

    public Utilisateur(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    public void checkCredentials(Socket soso, BufferedReader credentials) throws IOException {
        //TODO écrire sur la socket, faire en sorte que le serveur essaie de checker tout ça
        credentials = new BufferedReader(
                new InputStreamReader(soso.getInputStream()));
    }
}
