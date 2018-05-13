package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Dao.UserDao;
import com.artkufar.artkufar.Model.Artist;
import com.artkufar.artkufar.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistServiceImpl implements ArtistService {

    @Autowired
    UserDao userDao;

    @Override
    public Artist getByName(String name) {
        return null;
    }
}
