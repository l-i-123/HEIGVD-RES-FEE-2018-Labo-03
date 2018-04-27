package smtp;

import model.mail.Message;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;


/**
 * Created by elien on 27.04.2018.
 */

//Implementation du protocole SMTP pour envoyer un mail

public class SmtpClient {

    private BufferedReader reader;
    private String smtpServerAddress;
    private int smtpServerPort;
    private Socket socket;
    private PrintWriter writer;

    public SmtpClient(String smtpServerAddress, int smtpServerPort){
        
    }

    public void SendMessage(Message message){

    }
}
