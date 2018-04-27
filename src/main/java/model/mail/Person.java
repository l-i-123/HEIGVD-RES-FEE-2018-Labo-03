package model.mail;

/**
 * Created by elien on 27.04.2018.
 */
public class Person {

    private String firstName;
    private String lastName;
    private String address;

    public Person(String firstName, String lastName, String address){
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}
