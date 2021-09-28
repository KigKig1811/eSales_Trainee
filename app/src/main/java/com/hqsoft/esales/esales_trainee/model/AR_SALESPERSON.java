package com.hqsoft.esales.esales_trainee.model;

public class AR_SALESPERSON {
    public String SlsperID;
    public String Password;
    public String FullName;
    public String Address;

    public AR_SALESPERSON(String slsperID, String password, String fullName, String address) {
        SlsperID = slsperID;
        Password = password;
        FullName = fullName;
        Address = address;
    }

    public String getSlsperID() {
        return SlsperID;
    }

    public void setSlsperID(String slsperID) {
        SlsperID = slsperID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
