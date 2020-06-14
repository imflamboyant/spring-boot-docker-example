package com.example.demo.dataproviderservice.controller;

import com.example.demo.dataproviderservice.model.TravelOffer;
import com.example.demo.dataproviderservice.service.TravelOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TravelOfferController {

    private final TravelOfferService travelOfferService;

    /**
     * Returns all travel offers that fit the criteria. If no source and destination are passed, returns all travel offers.
     *
     * @param source      travel source
     * @param destination travel destination
     * @return list of offers
     */
    @GetMapping("traveloffers")
    public List<TravelOffer> getTravelOffers(@RequestParam(required = false) String source, @RequestParam(required = false) String destination) {
        return travelOfferService.findBySourceAndDestination(source, destination);
    }

}
