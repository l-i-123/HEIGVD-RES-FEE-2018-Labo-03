package model.mail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by elien on 27.04.2018.
 */
public class Group {

    private List<Person> group = new ArrayList<Person>();

    public List<Person> getGroup() {
        return group;
    }

    public void setGroup(List<Person> group) {
        this.group = group;
    }

    public void addMembers(Person person){

    }

}
