package com.artkufar.artkufar.Dao;

import com.artkufar.artkufar.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findByName(String name);
    Optional<User> findById(Long id);
    User findByNameAndArtistIsNotNull(String name);
    User findByNameAndBuyerIsNotNull(String name);
}
