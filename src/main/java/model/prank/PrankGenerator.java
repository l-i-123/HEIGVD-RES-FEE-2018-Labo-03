package model.prank;

import model.mail.Message;
import model.mail.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elien on 27.04.2018.
 */

//les "Functional requirments" de la données doivent être implémenté ici

public class PrankGenerator {
    private List<Message> message;
    private List<Person> victimRecipients;
    private List<Person> witnessRecipient;
    Prank prank = new Prank();

    public PrankGenerator(){
        message = prank.generateMessage();
        victimRecipients = prank.generateVictimRecipient();
        witnessRecipient = prank.getWitnessrecipients();
    }

    public void generateGroup(){
        
    }

    public void generatePrank(){

    }
}
