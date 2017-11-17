package com.lunchmaster.api.login.service;

import com.lunchmaster.api.login.dto.User;

public interface LoginService {

    boolean authorize(User loggedUser);
    User getUserByEmail(String email);
}
