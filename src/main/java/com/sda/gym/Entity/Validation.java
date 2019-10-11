package com.sda.gym.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Validation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int validationID;
    private Date curentDate;

    @ManyToOne
    @JoinColumn(name="clientID", nullable=false)
    private Client client;

}
