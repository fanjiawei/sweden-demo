package com.whereareyou.model;



import org.eclipse.persistence.annotations.UuidGenerator;

import javax.persistence.*;

/**
 * Created by 家玮 on 2014/7/26.
 */
@Entity
@Table(name="USERS",uniqueConstraints = @UniqueConstraint(columnNames = {"USERNAME"}))
@UuidGenerator(name="USER_ID_GEN")
public class User {

    @Id
    @GeneratedValue(generator = "USER_ID_GEN")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @Column(name="USERNAME")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name="PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="PASSWORD_SALT")
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    private String id;
    private String username;
    private String password;
    private String passwordSalt;
}
