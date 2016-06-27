package com.getman.repository;

import com.getman.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Sergii Getman
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findOneByName(String lcLogin);
}
