package com.example.demo.frontapi.service;

import com.example.demo.frontapi.model.TravelOffer;
import org.springframework.web.server.ResponseStatusException;


public interface TravelOfferAggregatorService {

    /**
     * Fetches the offers based on source and destination criteria from the offers provider and returns the cheapest one.
     * If none found, throws {@link ResponseStatusException} with HTTP NOT_FOUND status.
     *
     * @param source      source
     * @param destination destination
     * @return the cheapest offer found
     */
    TravelOffer getCheapestOfferFor(String source, String destination);

}
