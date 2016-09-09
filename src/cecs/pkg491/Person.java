/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cecs.pkg491;

/**
 *
 * @author blake
 */
public class Person {
    
    private final String fname, lname;
    private String practice, phone, email, address;
    
    public Person(String fname, String lname, String practice, String phone){
        this.fname = fname;
        this.lname = lname;
        this.practice = practice;
        this.phone = phone;
    }
    
    
    public String getFirstName(){
        return fname;
    }
    
    public String getLastName(){
        return lname;
    }
    
    public String getPractice(){
        return practice;
    }
    
    public String getEmail(){
     return email;   
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setPractice(String practice){
        this.practice = practice;
    }
    
    public void setPhone(String phone){
        this.phone = phone;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
