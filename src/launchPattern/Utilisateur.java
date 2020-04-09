package launchPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//Classe non utilisée dans le projet

public class Utilisateur {
    private String login;
    private String pwd;

    public Utilisateur(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }
    public void checkCredentials(Socket soso, BufferedReader credentials) throws IOException {

        credentials = new BufferedReader(
                new InputStreamReader(soso.getInputStream()));
    }
}
