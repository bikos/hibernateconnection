package com.mycompany.hibernatetry;
// Generated Feb 28, 2016 5:43:32 PM by Hibernate Tools 4.3.1



/**
 * Cds generated by hbm2java
 */
public class Cds  implements java.io.Serializable {


     private Integer userId;
     private String firstName;
     private String lastName;
     private Integer phone;

    public Cds() {
    }

    public Cds(String firstName, String lastName, Integer phone) {
       this.firstName = firstName;
       this.lastName = lastName;
       this.phone = phone;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getPhone() {
        return this.phone;
    }
    
    public void setPhone(Integer phone) {
        this.phone = phone;
    }




}

