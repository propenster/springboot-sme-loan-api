package com.github.propenster.SmeLoanGiver.Authentication.Repository;

import com.github.propenster.SmeLoanGiver.Authentication.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
