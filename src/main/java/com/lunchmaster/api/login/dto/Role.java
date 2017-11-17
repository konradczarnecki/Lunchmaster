package com.lunchmaster.api.login.dto;

import javax.persistence.*;

/**
 * Created by m.slefarski on 2017-11-14.
 */

@Entity
@Table(name="role")
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "rolename")
    private String rolename;


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
