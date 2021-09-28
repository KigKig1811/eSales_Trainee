package com.hqsoft.esales.esales_trainee.model;

public class AR_CUSTOMER {
    private String CustID;
    private String Name;
    private String Address;
    private String Phone;

    public AR_CUSTOMER(String custID, String name, String address, String phone) {
        CustID = custID;
        Name = name;
        Address = address;
        Phone = phone;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String custID) {
        CustID = custID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
