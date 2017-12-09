package com.lunchmaster.api.registration.service.impl;

import com.lunchmaster.api.login.dao.RoleDao;
import com.lunchmaster.api.login.dao.UserDao;
import com.lunchmaster.api.login.dto.Role;
import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.registration.dto.RegistrationDto;
import com.lunchmaster.api.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DatabaseRegistrationService  implements RegistrationService{

    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DatabaseRegistrationService(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveRegisteredUser(RegistrationDto dto) {
        User user = new User(dto);
        Role roleUser = roleDao.findByRolename("USER");

        List<Role> roles = new LinkedList<>();
        roles.add(roleUser);
        user.setRoles(roles);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userDao.saveAndFlush(user);
    }

    @Override
    public boolean isEmailUnique(String email) {
        return userDao.countByEmail(email) == 0;
    }

    @Override
    public boolean isMobileUnique(String mobile) {
        return userDao.countByMobile(mobile) == 0;
    }

    @Override
    public boolean isBankAccountUnique(String bankAccount) {
        return userDao.countByBankAccount(bankAccount) == 0;
    }
}
