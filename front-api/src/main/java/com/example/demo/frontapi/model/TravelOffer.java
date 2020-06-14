package com.example.demo.frontapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
 * Represents a travel offer DTO with source city, destination city and a price.
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TravelOffer {

    private String source;

    private String destination;

    private Double price;

}
