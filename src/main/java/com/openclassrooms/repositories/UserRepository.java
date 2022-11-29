package com.openclassrooms.repositories;


import com.openclassrooms.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    List<User> findAll();

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
