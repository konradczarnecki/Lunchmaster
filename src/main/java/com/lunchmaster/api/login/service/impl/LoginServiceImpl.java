package com.lunchmaster.api.login.service.impl;

import com.lunchmaster.api.login.dao.UserDao;
import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private UserDao dao;

    @Autowired
    public LoginServiceImpl(UserDao dao){

        this.dao = dao;
    }

    public boolean authorize(User loggedUser) {

        User fromDb = dao.findUserByEmail(loggedUser.getEmail());
        return fromDb != null && fromDb.getPassword().equals(loggedUser.getLoginPwd());
    }

    public User getUserByEmail(String email){

        return dao.findUserByEmail(email);
    }
}
