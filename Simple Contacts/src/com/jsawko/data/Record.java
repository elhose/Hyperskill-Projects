package com.jsawko.data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public  class Record implements Serializable {
    private final String ID;
    private String name;
    private String phoneNumber;
    private final LocalDateTime dateOfCreation;
    private LocalDateTime dateOfModification;

    public String getName() {
        return name;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public LocalDateTime getDateOfModification() {
        return dateOfModification;
    }

    public void setDateOfModification(LocalDateTime dateOfModification) {
        this.dateOfModification = dateOfModification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (isPhoneNumberValid(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
    }

    private boolean hasNumber(){
        return phoneNumber.isEmpty();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Record(String name, String phoneNumber) {
        this.ID = UUID.randomUUID().toString();
        this.name = name;
        if (isPhoneNumberValid(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else {
            System.out.println("Wrong number format!");
            this.phoneNumber = "[no number]";
        }
        this.dateOfCreation = LocalDateTime.now();
        this.dateOfModification = dateOfCreation;

    }

    private static boolean isPhoneNumberValid(String phoneNumber){
        String oneGroup = "\\+?(\\(?[a-zA-Z0-9]{2,}\\)?)";
        String multipleGroups = "(\\(?[a-zA-Z0-9]{2,}\\)?[ -])+\\(?[a-zA-Z0-9]{2,}\\)?";
        String multipleGroupsWithPlus = "\\+?\\w?[ -](\\(?[a-zA-Z0-9]{2,}\\)?[ -])+[a-zA-Z0-9]{2,}";
        boolean matches = phoneNumber.matches(oneGroup) || phoneNumber.matches(multipleGroups) || phoneNumber.matches( multipleGroupsWithPlus);
        boolean multipleBrackets = phoneNumber.indexOf("(") == phoneNumber.lastIndexOf("(");
        return matches && multipleBrackets;
    }

    public String getID() {
        return ID;
    }
}