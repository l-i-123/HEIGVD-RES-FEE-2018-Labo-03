package model.prank;

import model.mail.Message;
import model.mail.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elien on 27.04.2018.
 */
public class Prank {

    private List<Message> message = new ArrayList<>();
    private List<Person> victimRecipients = new ArrayList<Person>();
    private List<Person> witnessRecipient = new ArrayList<Person>();
    private Reader reader;

    public List<Message> generateMessage(){
        message.clear();
        try {
            reader = new InputStreamReader(new FileInputStream("message.txt"), "UTF-8");
            BufferedReader body = new BufferedReader(reader);
            String line;
            StringBuilder messageToSend = new StringBuilder();

            while ((line = body.readLine()) != null){
                if(line.startsWith("===")){
                    message.add(new Message(messageToSend.toString()));
                    messageToSend = new StringBuilder();
                }
                messageToSend.append(line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return message;
    }

    public List<Person> generateVictimRecipient(){
        victimRecipients.clear();
        try{
            reader = new InputStreamReader(new FileInputStream("victims_recipient.txt"), "UTF-8");
            BufferedReader body = new BufferedReader(reader);
            String line;

            while((line = body.readLine()) != null){
                victimRecipients.add(new Person(line));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return victimRecipients;
    }

    public List<Person> generateWitnessRecipient(){
        witnessRecipient.clear();
        try{
            reader = new InputStreamReader(new FileInputStream("witness_recipient.txt"), "UTF-8");
            BufferedReader body = new BufferedReader(reader);
            String line;

            while((line = body.readLine()) != null){
                witnessRecipient.add(new Person(line));
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return witnessRecipient;
    }

    public List<Message> getMessage(){
        return  message;
    }

    public List<Person> getVictimRecipient(){
        return victimRecipients;
    }

    public List<Person> getWitnessrecipients(){
        return witnessRecipient;
    }
}
