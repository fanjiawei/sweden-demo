package com.whereareyou.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by 家玮 on 2014/10/4.
 */
@Entity
@Table(name = "INPUT_VALUE")
public class InputValue {
    private Long id;
    private Date date;
    private Integer value;
    private String name;

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "DATE_CREATED")
    @Temporal(TemporalType.DATE)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "VAL")
    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

}
