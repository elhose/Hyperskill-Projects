package com.jsawko.data;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Person extends Record {
    private String surname;
    private String birthDate;
    private String gender;

    public Person(String name, String phoneNumber, String surname, String birthDate, String gender) {
        super(name, phoneNumber);
        this.surname = surname;
        this.birthDate = validateBirthDate(birthDate) ? birthDate : "[no data]";
        this.gender = validateGender(gender) ? gender : "[no data]";
    }

    private static boolean validateBirthDate(String gender){
        try {
            LocalDate localDate = LocalDate.parse(gender);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }

    private static boolean validateGender(String gender){
        switch (gender){
            case "M":
            case "F":
                return true;
            default: return false;
        }
    }

    public static boolean isBirthDayValid(String gender){
        return validateBirthDate(gender);
    }

    public static boolean isGenderValid(String gender){
        return validateGender(gender);
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        this.gender = validateGender(gender) ? gender : "[no data]";
    }

    @Override
    public String toString() {
        return  "Name: " + getName() + "\n" +
                "Surname: " + this.surname + "\n" +
                "Birth date: " + this.birthDate + "\n" +
                "Gender: " + this.gender + "\n" +
                "Number: " + getPhoneNumber() + "\n" +
                "Time created: " + getDateOfCreation().toString().substring(0,16) + "\n" +
                "Time last edit: " + getDateOfModification().toString().substring(0,16);
    }
}
