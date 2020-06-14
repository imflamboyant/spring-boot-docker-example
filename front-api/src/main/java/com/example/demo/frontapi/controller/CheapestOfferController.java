package com.example.demo.frontapi.controller;

import com.example.demo.frontapi.model.TravelOffer;
import com.example.demo.frontapi.service.TravelOfferAggregatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CheapestOfferController {

    private final TravelOfferAggregatorService travelOfferAggregatorService;

    /**
     * Returns the cheapest travel offer for the given criteria of source and destination. If the offer is not found, 404 HTTP response is returned.
     *
     * @param source      source
     * @param destination destination
     * @return cheapest travel offer
     */
    @GetMapping("cheapestoffer")
    public TravelOffer getCheapestOffer(@RequestParam String source, @RequestParam String destination) {
        return this.travelOfferAggregatorService.getCheapestOfferFor(source, destination);
    }

}
