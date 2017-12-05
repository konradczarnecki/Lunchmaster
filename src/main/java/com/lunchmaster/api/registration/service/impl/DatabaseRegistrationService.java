package com.lunchmaster.api.registration.service.impl;

import com.lunchmaster.api.login.dao.RoleDao;
import com.lunchmaster.api.login.dao.UserDao;
import com.lunchmaster.api.login.dto.Role;
import com.lunchmaster.api.login.dto.User;
import com.lunchmaster.api.registration.dto.RegistrationDto;
import com.lunchmaster.api.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DatabaseRegistrationService  implements RegistrationService{

    private UserDao userDao;
    private RoleDao roleDao;

    @Autowired
    public DatabaseRegistrationService(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User saveRegisteredUser(RegistrationDto dto) {
        User user = new User(dto);
        Role roleUser = roleDao.findByRolename("USER");

        List<Role> roles = new LinkedList<>();
        roles.add(roleUser);
        user.setRoles(roles);

        return userDao.saveAndFlush(user);
    }
}
