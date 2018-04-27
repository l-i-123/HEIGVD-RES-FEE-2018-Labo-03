package model.prank;

import model.mail.Message;
import model.mail.Person;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elien on 27.04.2018.
 */
public class Prank {

    private Message message;
    private List<Person> victimRecipients = new ArrayList<Person>();
    private Person victimeSender;
    private List<Person> witnessRecipient = new ArrayList<Person>();

    public void addVictimRecipients(Person victim){
        victimRecipients.add(victim);
    }

    public void addVictimRecipients(List<Person> victims){
        victimRecipients.addAll(victims);
    }

    public void addWitnessRecipients(){

    }

    public void generateMailMessage(){

    }

    public void getMessage(){

    }

    public void getVictimRecipient(){

    }

    public List<Person> getWitnessrecipients(){
        return victimRecipients;
    }

    public void setMessage(Message message){

    }

    public int importVictim(BufferedReader reader){
        String line;
        Person person;
        int compteur = 0;
        try{
            while((line = reader.readLine()) != null){
                person = new Person(line);
                addVictimRecipients(person);
                compteur++;
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return compteur;
    }

    //public void setVictimSender(VictimSender victimSender){

   // }
}
