package com.lunchmaster.api.registration.service;

import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.registration.dto.RegistrationDto;

public interface RegistrationService {

    User saveRegisteredUser(RegistrationDto dto);

    boolean isEmailUnique(String email);

    boolean isMobileUnique(String mobile);

    boolean isBankAccountUnique(String bankAccount);
}
