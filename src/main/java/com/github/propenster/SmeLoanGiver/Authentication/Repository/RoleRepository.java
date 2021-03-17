package com.github.propenster.SmeLoanGiver.Authentication.Repository;

import com.github.propenster.SmeLoanGiver.Authentication.Models.ERole;
import com.github.propenster.SmeLoanGiver.Authentication.Models.Role;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);
}
