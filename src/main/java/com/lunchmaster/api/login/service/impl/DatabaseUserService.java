package com.lunchmaster.api.login.service.impl;

import com.lunchmaster.api.login.dao.UserDao;
import com.lunchmaster.api.login.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("databaseUserService")
public class DatabaseUserService implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findUserByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException(String.format("User with email %s not found", email));
        }

        return user;
    }
}
