package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Model.User;

public interface UserService {
    void save(User user);
    User findById(Long id);
    User findByName(String name);
    User findByEmail(String email);
    void update(User user);
    User getArtistByName(String name);
    User getBuyerByName(String name);
}
