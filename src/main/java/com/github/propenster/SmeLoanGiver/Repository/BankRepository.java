package com.github.propenster.SmeLoanGiver.Repository;

import com.github.propenster.SmeLoanGiver.Entity.Bank;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BankRepository extends MongoRepository<Bank, String> {

    Optional<Bank> findByCode(String code);

    Optional<Bank> findById(int id);
    @Query("{country : ?0}")
    List<Bank> findByCountry(String country);
}
