package com.lunchmaster.api.login.dao;

import com.lunchmaster.api.login.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);

    int countByEmail(String email);

    int countByMobile(String mobile);

    int countByBankAccount(String bankAccount);
}
