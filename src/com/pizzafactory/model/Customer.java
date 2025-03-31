package com.pizzafactory.model;

public class Customer {
    private String name;
    private String contact;

    public Customer(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    // Getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Getters and setters
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }


}