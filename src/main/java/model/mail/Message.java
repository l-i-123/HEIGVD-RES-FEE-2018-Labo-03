package model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elien on 27.04.2018.
 */
public class Message {

    private String body;
    private List<String> cc = new ArrayList<String>();
    private String from;
    private List<String> to = new ArrayList<String>();
    private String subject;

    public Message(){

    }

    public Message(String from, String to, String subject, String body){
        this.from = from;
        this.to.add(to);
        this.subject = subject;
        this.body = body;
    }

    public Message(String from, List<String> to, String subject, String body){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public List<String> getCc() {
        return cc;
    }

    public void setCc(List<String> cc) {
        this.cc.addAll(cc);
    }

    public void addCc(String cc) {
        this.cc.add(cc);
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public List<String> getTo() {
        return to;
    }

    public void setTo(List<String> to) {
        this.to = to;
    }

    public void addTo(String to){
        this.to.add(to);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


}
