package com.example.demo.frontapi.service;

import com.example.demo.frontapi.model.TravelOffer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class TravelOfferAggregatorServiceImpl implements TravelOfferAggregatorService {

    @Value("${app.offerProviderUrl}")
    private String providerServiceUrl;

    private final RestTemplate restTemplate;

    @Override
    public TravelOffer getCheapestOfferFor(String source, String destination) {
        TravelOffer[] offers = this.restTemplate.getForObject(this.providerServiceUrl, TravelOffer[].class, source, destination);
        Optional<TravelOffer> cheapestOffer = Stream.of(offers).reduce((a, b) -> a.getPrice() < b.getPrice() ? a : b);
        return cheapestOffer.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No offer found for the given criteria"));
    }

}
