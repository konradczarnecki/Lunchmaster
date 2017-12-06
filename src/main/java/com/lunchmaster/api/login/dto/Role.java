package com.lunchmaster.api.login.dto;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Created by m.slefarski on 2017-11-14.
 */

@Entity
@Table(name="role")
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rolename")
    private String rolename;

    public Role(){}

    @Override
    public String getAuthority() {
        return this.rolename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
