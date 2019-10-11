package com.sda.gym.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionID;

    private Date startDate;
    private Date endDate;


    @ManyToOne
    @JoinColumn(name="clientID", nullable=false) // trebuie setat numele coloanei din tabela Subscription care ma duce la Client
    private Client client;

    @ManyToOne
    @JoinColumn(name="subscriptionTypeID", nullable=false) // trebuie setat numele coloanei din tabela SubscriptionType care ma duce la Subscription.
    private SubscriptionType subscriptionType;

    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionID=" + subscriptionID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", client=" + client +
                ", subscriptionType=" + subscriptionType +
                '}';
    }
}
