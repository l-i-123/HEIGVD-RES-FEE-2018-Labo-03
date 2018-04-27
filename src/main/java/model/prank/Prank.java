package model.prank;

import model.mail.Message;
import model.mail.Person;

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

    public void getWitnessrecipients(){

    }

    public void setMessage(Message message){

    }

    //public void setVictimSender(VictimSender victimSender){

   // }
}
