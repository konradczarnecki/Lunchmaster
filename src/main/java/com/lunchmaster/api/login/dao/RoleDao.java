package com.lunchmaster.api.login.dao;

import com.lunchmaster.api.login.dto.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {

    Role findByRolename(String rolename);
}
