package com.github.propenster.SmeLoanGiver.Repository;

import com.github.propenster.SmeLoanGiver.Entity.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<Airport, String> {

}
