package com.kd.example.spring.model;

public class Role implements Comparable<Role> {
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Role r) {
        return this.name.compareTo(r.getName());
    }
}
