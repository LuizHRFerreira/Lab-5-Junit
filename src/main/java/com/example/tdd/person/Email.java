
package com.example.tdd.person;

public class Email {

    private int id;
    private String name;

    public Email() {
    }

    public Email(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
