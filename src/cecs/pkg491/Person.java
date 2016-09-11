/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author blake
 */
public class Person {

    private final SimpleStringProperty fname, lname;
    private SimpleStringProperty practice, phone, email, address;

    public Person(String fname, String lname, String practice, String phone) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.practice = new SimpleStringProperty(practice);
        this.phone = new SimpleStringProperty(phone);
    }

    public Person(String fname, String lname, String practice, String phone, String email, String address) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.practice = new SimpleStringProperty(practice);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.address = new SimpleStringProperty(address);

    }

    public String getFirstName() {
        return fname.get();
    }

    public String getLastName() {
        return lname.get();
    }

    public String getPractice() {
        return practice.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getAddress() {
        return address.get();
    }

    public void setPractice(String practice) {
        this.practice = new SimpleStringProperty(practice);
    }

    public void setPhone(String phone) {
        this.phone = new SimpleStringProperty(phone);
    }

    public void setAddress(String address) {
        this.address = new SimpleStringProperty(address);
    }

    public String toString() {
        return fname + " " + lname + " " + practice + " " + phone + " "
                + email + " " + address;
    }
}
