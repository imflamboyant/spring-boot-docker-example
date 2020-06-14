package com.example.demo.dataproviderservice.service;

import com.example.demo.dataproviderservice.model.TravelOffer;

import java.util.List;


public interface TravelOfferService {

    /**
     * Returns travel offers that match passed source and destination. If none passed, returns all offers from the repository.
     *
     * @param source      source
     * @param destination destination
     * @return list of offers
     */
    List<TravelOffer> findBySourceAndDestination(String source, String destination);

}
