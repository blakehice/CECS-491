/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author blake
 */
public class Person {

    private final SimpleStringProperty fname, lname;
    private SimpleStringProperty practice, phone, email, address, company,
        suite, city ,state, zipcode;
    private SimpleDoubleProperty miles;
    private SimpleIntegerProperty years, Attorneys;

    

    public Person(String fname, String lname, String company, String address, 
            String suite, String city, String state, String zipcode,String phone, 
            String practice, String email, double miles, int years, int Attorneys) {
        this.fname = new SimpleStringProperty(fname);
        this.lname = new SimpleStringProperty(lname);
        this.company = new SimpleStringProperty(company);
        this.address = new SimpleStringProperty(address);
        this.suite = new SimpleStringProperty(suite);
        this.city = new SimpleStringProperty(city);
        this.state = new SimpleStringProperty(state);
        this.zipcode = new SimpleStringProperty(zipcode);
        this.phone = new SimpleStringProperty(phone);
        this.practice = new SimpleStringProperty(practice);
        this.email = new SimpleStringProperty(email);
        this.miles = new SimpleDoubleProperty(miles);
        this.years = new SimpleIntegerProperty(years);
        this.Attorneys = new SimpleIntegerProperty(Attorneys);
    }

    public String getFirstName() {
        return fname.get();
    }

    public String getLastName() {
        return lname.get();
    }
    
    public String getCompany() {
       return company.get();
    }
    
    public String getAddress() {
       return address.get();
    }
    
    public String getSuite() {
       return suite.get();
    }
    
    public String getCity() {
       return city.get();
    }
    
    public String getState() {
       return state.get();
    }
    
    public String getZIP() {
       return zipcode.get();
    }
    
    public String getPhone() {
       return phone.get();
    }

    public String getPractice() {
        return practice.get();
    }

    public String getEmail() {
        return email.get();
    }
    
    public double getMiles() {
       return miles.get();
    }
    
    public int getYears() {
       return years.get();
    }

    public int getAttorneys() {
       return Attorneys.get();
    }
    
    public void setCompany(String company) {
       this.company = new SimpleStringProperty(company);
    }
    
    public void setAddress(String address) {
       this.address = new SimpleStringProperty(address);
    }
    
    public void setSuite(String suite) {
       this.suite = new SimpleStringProperty(suite);
    }
    
    public void setCity(String city) {
       this.city = new SimpleStringProperty(city);
    }

    public void setState(String state) {
        this.state = new SimpleStringProperty(state);
    }
    
    public void setZIP(String zipcode) {
       this.zipcode = new SimpleStringProperty(zipcode);
    }

    public void setPhone(String phone) {
        this.phone = new SimpleStringProperty(phone);
    }
    
    public void setPractice(String practice) {
       this.practice = new SimpleStringProperty(practice);
    }
    
    public void setEmail(String email) {
       this.email = new SimpleStringProperty(email);
    }
    
    public void setMiles(double miles) {
       this.miles = new SimpleDoubleProperty(miles);
    }
    
    public void setYears(int years) {
       this.years = new SimpleIntegerProperty(years);
    }
    
    public void setAttorneys(int Attorneys) {
       this.Attorneys = new SimpleIntegerProperty(Attorneys);
    }

    @Override
    public String toString() {
        return fname + " " + lname + " " + company + " " + address + " " +
                suite + " " + city + " " + state + " " + zipcode + " " + phone +
                " " + practice + " " + email + " " + miles + " " + years + " " +
                Attorneys;
    }
}
