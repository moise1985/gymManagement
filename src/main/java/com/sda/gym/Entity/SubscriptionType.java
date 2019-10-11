package com.sda.gym.Entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
public class SubscriptionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionTypeID;
    private String type;

    @OneToMany(mappedBy="subscriptionType") // numele field-ului din clasa Subscription care reprezinta tipul de abonament
    private List<Subscription> subscriptionList;

    @Override
    public String toString() {
        return "SubscriptionType{" +
                "subscriptionTypeID=" + subscriptionTypeID +
                ", type='" + type + '\'' +
                '}';
    }
}
