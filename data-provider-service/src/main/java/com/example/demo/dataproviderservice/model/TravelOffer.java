package com.example.demo.dataproviderservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * Represents a travel offer consisting of source, destination and price. Also represents an entity in the database.
 */
@Entity
@Getter
@NoArgsConstructor
public class TravelOffer {

    @Id
    @GeneratedValue
    private Long id;

    private String source;

    private String destination;

    private Double price;

    public TravelOffer(String source, String destination, Double price) {
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

}
