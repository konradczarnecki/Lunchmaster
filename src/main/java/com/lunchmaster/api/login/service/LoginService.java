package com.lunchmaster.api.login.service;

import com.lunchmaster.api.login.dto.User;

public interface LoginService {

    User findUserByEmail(String email);
}
