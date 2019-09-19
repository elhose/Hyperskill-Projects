package com.jsawko.data;

public class Organization extends Record {
    private String address;


    public Organization(String name, String phoneNumber, String address) {
        super(name, phoneNumber);
        this.address = address;
    }

    @Override
    public String toString() {
        return  "Organization name: " + getName() + "\n" +
                "Address: " + this.address + "\n" +
                "Number: " + getPhoneNumber() + "\n" +
                "Time created: " + getDateOfCreation().toString().substring(0,16) + "\n" +
                "Time last edit: " + getDateOfModification().toString().substring(0,16) ;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
