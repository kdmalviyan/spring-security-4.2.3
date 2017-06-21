package com.kd.example.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLE")
public class Role implements Serializable {
    public Role(String name) {
        this.name = name;
    }

    public Role() {
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Column(name = "ROLE_ID")
    private Integer id;
    @Column(name = "ROLE_NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
