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

    private List<Message> messages = new ArrayList<>();
    private List<Person> victimRecipients = new ArrayList<Person>();
    private List<Person> witnessRecipient = new ArrayList<Person>();
    private Reader reader;
    private String absolutPath = "D:/HEIG-VD/Informatique/RES/HEIGVD-RES-FEE-2018-Labo-03/src/main/java/config";

    public List<Message> generateMessage(){
        messages.clear();
        try {
            reader = new InputStreamReader(new FileInputStream(absolutPath + "/messages.txt"), "UTF-8");
            BufferedReader body = new BufferedReader(reader);
            String line;
            String subject = "";
            StringBuilder messageToSend = new StringBuilder();
            Message message = new Message();

            while ((line = body.readLine()) != null){
                if(line.startsWith("===")){
                    message = new Message(messageToSend.toString());
                    message.setSubject(subject);
                    messages.add(message);
                    messageToSend = new StringBuilder();
                }
                else if(line.startsWith("SUBJECT: ")){
                    subject = line.substring(8);
                }
                else{
                    messageToSend.append(line);
                    messageToSend.append("\r\n");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            try{
                reader.close();
            }catch (IOException e){
                System.out.println(e);
            }

        }
        return messages;
    }

    public List<Person> generateVictimRecipient(){
        victimRecipients.clear();
        try{
            reader = new InputStreamReader(new FileInputStream(absolutPath + "/victims_recipient.txt"), "UTF-8");
            BufferedReader body = new BufferedReader(reader);
            String line;

            while((line = body.readLine()) != null){
                victimRecipients.add(new Person(line));
            }

            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                reader.close();
            }catch (IOException e){
                System.out.println(e);
            }

        }
        return victimRecipients;
    }

    public List<Person> generateWitnessRecipient(){
        witnessRecipient.clear();
        try{
            reader = new InputStreamReader(new FileInputStream(absolutPath + "/witness_recipient.txt"), "UTF-8");
            BufferedReader body = new BufferedReader(reader);
            String line;

            while((line = body.readLine()) != null){
                witnessRecipient.add(new Person(line));
            }

            reader.close();
        }catch (Exception e){
            System.out.println(e);
        }
        finally {
            try{
                reader.close();
            }catch (IOException e){
                System.out.println(e);
            }
        }
        return witnessRecipient;
    }

    public List<Message> getMessage(){
        return  messages;
    }

    public List<Person> getVictimRecipient(){
        return victimRecipients;
    }

    public List<Person> getWitnessrecipients(){
        return witnessRecipient;
    }
}
