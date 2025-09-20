package com.softnexis.model;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

    private int id;
    private String name;
    private String email;
    private String phone;

    public Contact() {
        this.id = ID_GENERATOR.getAndIncrement();
    }

    public Contact(String name, String email, String phone) {
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "Contact{" + id + "," + name + "," + email + "," + phone + "}";
    }
}
