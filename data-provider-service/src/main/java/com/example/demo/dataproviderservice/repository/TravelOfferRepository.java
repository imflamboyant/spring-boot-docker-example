package com.example.demo.dataproviderservice.repository;

import com.example.demo.dataproviderservice.model.TravelOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TravelOfferRepository extends JpaRepository<TravelOffer, Long> {

    List<TravelOffer> findBySourceAndDestination(String source, String destination);

}
