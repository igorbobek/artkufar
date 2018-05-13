package com.artkufar.artkufar.Service;

import com.artkufar.artkufar.Dao.RoleDao;
import com.artkufar.artkufar.Dao.UserDao;
import com.artkufar.artkufar.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Override
    public void save(User user) {
        if(user.getArtist() != null){
            user.getRoles().add(roleDao.findByRole("ARTIST"));
        }else{
            user.getRoles().add(roleDao.findByRole("BUYER"));
        }
        userDao.save(user);
    }

    @Override
    public void update(User user){
        userDao.save(user);
    }

    @Nullable
    @Override
    public User findById(Long id) {
        if(userDao.findById(id).isPresent()){
            return userDao.findById(id).get();
        }
        return null;
    }

    @Nullable
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Secured("ROLE_ADMIN")
    @Nullable
    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User getArtistByName(String name) {
        return userDao.findByNameAndArtistIsNotNull(name);
    }

    @Override
    public User getBuyerByName(String name) {
        return userDao.findByNameAndBuyerIsNotNull(name);
    }
}
