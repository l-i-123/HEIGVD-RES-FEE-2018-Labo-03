package model.prank;

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

public class PrankGenerator {

    private List<Person> victimRecipient;
    private List<Person> witnessRecipient;
    private Prank prank = new Prank();
    private List<Message> messages = new ArrayList<>();
    private Message message;
    private List<Message> mailToSend = new ArrayList<>();
    SmtpClient smtp;
    private int nbGroups;
    private static final int NB_MIN_VICTIMS_BY_GROUP = 2;

    public PrankGenerator(SmtpClient smtp, int nbGroups){
        this.smtp = smtp;
        this.nbGroups = nbGroups;
        messages = prank.generateMessage();
        victimRecipient = prank.generateVictimRecipient();
        witnessRecipient = prank.generateWitnessRecipient();
    }

    public void generateGroup() throws Exception{
        Iterator<Person> victimsIterator = victimRecipient.iterator();
        Iterator<Message> messageIterator = messages.iterator();
        int nbVictimeTotal = victimRecipient.size();
        int nbVictimByGroup = ((nbVictimeTotal - nbGroups) / nbGroups);

        Message messageTemp;
        int compteur = 0;

        if((nbVictimByGroup < NB_MIN_VICTIMS_BY_GROUP) || (nbGroups > messages.size())){
            throw new Exception("Nombre insuffisants de victime ou nombre de messages insuffisant");
        }
        else{
            for (int i = 0; i < nbGroups; i++){
                messageTemp = messageIterator.next();
                message = new Message();
                message.setFrom(victimsIterator.next().getAddress());

                for(int j = 0; j < nbVictimByGroup; j++){
                    message.setTo(victimsIterator.next().getAddress());
                }
                if((nbVictimeTotal - compteur) % nbGroups !=0){
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
