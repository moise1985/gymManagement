package com.sda.gym.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientID;
    private String firstName;
    private String lastName;
    private String CNP;
    private String cardNumber;
    private String emailAddress;

    @OneToMany(mappedBy="client") // numele field-ului din clasa Subscription care reprezinta clientul.
    private List<Subscription> subscriptionList;

    @OneToMany(mappedBy="client") // numele field-ului din clasa Validation care reprezinta clientul.
    private List<Validation> validationList;

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientID=" + clientID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", CNP='" + CNP + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
