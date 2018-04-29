package model.prank;

import config.Protocol;
import model.mail.Message;
import model.mail.Person;
import smtp.SmtpClient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by elien on 27.04.2018.
 */

//les "Functional requirments" de la données doivent être implémenté ici

public class PrankGenerator {

    private List<Person> victimRecipient;
    private List<Person> witnessRecipient;
    private Prank prank = new Prank();
    private List<Message> messages = new ArrayList<>();
    private Message message;
    private List<Message> mailToSend = new ArrayList<>();
    SmtpClient smtp;

    public PrankGenerator(SmtpClient smtp){
        this.smtp = smtp;
        messages = prank.generateMessage();
        victimRecipient = prank.generateVictimRecipient();
        witnessRecipient = prank.generateWitnessRecipient();
    }

    public void generateGroup() throws Exception{
        Iterator<Person> victimsIterator = victimRecipient.iterator();
        Iterator<Message> messageIterator = messages.iterator();
        int nbGroupe = Protocol.NB_GROUP;
        int nbVictimByGroup = ((victimRecipient.size() - nbGroupe) / nbGroupe);
        Message messageTemp;

        if((nbVictimByGroup < nbGroupe) || (nbGroupe > messages.size())){
            throw new Exception("Il n'y a pas assez de victime par rapport au nombre de groupe");
        }
        else{

            for (int i = 0; i < nbGroupe; i++){
                messageTemp = messageIterator.next();
                message = new Message();
                message.setFrom(victimsIterator.next().getAddress());
                for(int j = 0; j < nbVictimByGroup; j++){
                    message.setTo(victimsIterator.next().getAddress());
                }
                message.setBody(messageTemp.getBody());
                message.setSubject(messageTemp.getSubject());
                if(victimsIterator.hasNext() && (i == nbGroupe - 1)){
                    message.addTo(victimsIterator.next().getAddress());
                }
                message.setCc(witnessRecipient.stream().map(Person::getAddress).collect(Collectors.toList()));
                mailToSend.add(message);
            }
        }
    }

    public void generatePrank(){
        Iterator<Message> mailToSendIterator = mailToSend.iterator();

        while(mailToSendIterator.hasNext()){
            smtp.sendMessage(mailToSendIterator.next());
        }
    }
}
