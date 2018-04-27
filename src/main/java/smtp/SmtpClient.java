package smtp;

import model.mail.Message;

import java.io.*;
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
    String line;


    public SmtpClient(String smtpServerAddress, int smtpServerPort){
        this.smtpServerAddress = smtpServerAddress;
        this.smtpServerPort = smtpServerPort;
    }

    public void sendMessage(Message message){
        try{
            socket = new Socket(smtpServerAddress, smtpServerPort);
            writer = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(reader.readLine());

            writer.write("EHLO blabla");
            writer.write("\r\n");
            writer.flush();

            line = reader.readLine();
            retourServeur(line);

            while(line.startsWith("250-")){
                line = reader.readLine();
                retourServeur(line);
            }

            retourServeur(line);

            writer.write("MAIL FROM:" + message.getFrom());
            writer.write("\r\n");
            writer.flush();

            retourServeur(reader.readLine());


            for(String to : message.getTo()){
                writer.write("RCPT TO:");
                writer.write(to);
                writer.write("\r\n");
                writer.flush();

                retourServeur(reader.readLine());
            }

            writer.write("DATA");
            writer.write("\r\n");
            writer.flush();

            writer.write("FROM:" + message.getFrom());
            writer.write("\r\n");

            for(String to : message.getTo()){
                writer.write("TO:" + to);
                writer.write("\r\n");
                writer.flush();
            }

            for(String to : message.getCc()){
                writer.write("CC:" + to);
                writer.write("\r\n");
                writer.flush();
            }

            writer.write("SUBJECT:"+ message.getSubject());
            writer.write("\r\n");
            writer.flush();

            writer.write(message.getBody());
            writer.write("\r\n");
            writer.write(".");
            writer.write("\r\n");
            writer.flush();
            System.out.println(reader.readLine());

            writer.write("QUIT");
            writer.write("\r\n");
            writer.flush();
            retourServeur(reader.readLine());

            socket.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void retourServeur(String reader) throws Exception {
        if(reader.startsWith("354")){
            System.out.println("354 End data with <CR><LF>.<CR><LF>");
        }
        else if(!reader.startsWith("250")){
            throw new Exception("Commande non supporté par le serveur");
        }
        else{
            System.out.println(reader);
        }
    }
}
