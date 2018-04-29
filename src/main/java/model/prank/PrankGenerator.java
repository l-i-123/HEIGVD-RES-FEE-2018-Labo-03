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
    private static final int NB_MIN_VICTIMS_BY_GROUP = 2;

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
        int nbVictimeTotal = victimRecipient.size();
        int nbVictimByGroup = ((nbVictimeTotal - nbGroupe) / nbGroupe);

        Message messageTemp;
        int compteur = 0;

        if((nbVictimByGroup < NB_MIN_VICTIMS_BY_GROUP) || (nbGroupe > messages.size())){
            throw new Exception("Nombre insuffisant de victime ou nombre de message insuffisant");
        }
        else{
            for (int i = 0; i < nbGroupe; i++){
                messageTemp = messageIterator.next();
                message = new Message();
                message.setFrom(victimsIterator.next().getAddress());

                for(int j = 0; j < nbVictimByGroup; j++){
                    message.setTo(victimsIterator.next().getAddress());
                }
                if((nbVictimeTotal - compteur) % nbGroupe !=0){
                    message.addTo(victimsIterator.next().getAddress());
                    compteur++;
                }

                message.setBody(messageTemp.getBody());
                message.setSubject(messageTemp.getSubject());

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
