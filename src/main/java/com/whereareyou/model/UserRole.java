package com.whereareyou.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by 家玮 on 2014/7/26.
 */
@Entity
@IdClass(value=UserRolePK.class)
@Table(name="USER_ROLES")
public class UserRole {
    @Id
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    @Id
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String user;
    private String role;
}
