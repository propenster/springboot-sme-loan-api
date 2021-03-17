package com.github.propenster.SmeLoanGiver.Repository;

import com.github.propenster.SmeLoanGiver.Entity.NewSMEAccountRequest;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface SMEAccountOpeningRepository extends MongoRepository<NewSMEAccountRequest, String> {

    @Query("{ 'AccountNumber' : ?0 }")
    Optional<NewSMEAccountRequest> findByAccountNumber(long accountNumber);


}
