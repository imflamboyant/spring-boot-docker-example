package com.example.demo.dataproviderservice.service;

import com.example.demo.dataproviderservice.model.TravelOffer;
import com.example.demo.dataproviderservice.repository.TravelOfferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TravelOfferServiceImpl implements TravelOfferService {

    private static final double MAX_PRICE = 1000.00;

    private final TravelOfferRepository travelOfferRepository;

    @Override
    public List<TravelOffer> findBySourceAndDestination(String source, String destination) {
        if (source == null && destination == null) {
            return travelOfferRepository.findAll();
        } else {
            return travelOfferRepository.findBySourceAndDestination(source, destination);
        }
    }

    /**
     * Just some dummy data preparation and filling the database with example values.
     */
    @PostConstruct
    void prepareData() {
        travelOfferRepository.saveAll(List.of(
                new TravelOffer("Novi Sad", "Brisbane", Math.random() * MAX_PRICE),
                new TravelOffer("Novi Sad", "Brisbane", Math.random() * MAX_PRICE),
                new TravelOffer("Novi Sad", "Brisbane", Math.random() * MAX_PRICE),
                new TravelOffer("Novi Sad", "Brisbane", Math.random() * MAX_PRICE),
                new TravelOffer("Brisbane", "Novi Sad", Math.random() * MAX_PRICE),
                new TravelOffer("Brisbane", "Novi Sad", Math.random() * MAX_PRICE),
                new TravelOffer("Brisbane", "Novi Sad", Math.random() * MAX_PRICE),
                new TravelOffer("Brisbane", "Novi Sad", Math.random() * MAX_PRICE)
        ));
    }
}
