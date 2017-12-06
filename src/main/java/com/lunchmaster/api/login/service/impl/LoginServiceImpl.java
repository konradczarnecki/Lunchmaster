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

    public User findUserByEmail(String email){
        return dao.findUserByEmail(email);
    }
}
