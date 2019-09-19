package com.jsawko.menu;

import com.jsawko.data.Organization;
import com.jsawko.data.Person;
import com.jsawko.data.Record;

import java.time.LocalDateTime;
import java.util.Scanner;

public  class Menu {

    public static void showCommands(){
        System.out.println("[menu] Enter action (add, list, search, count, exit): ");
    }

    protected static void listRecords(java.util.List<Record> records) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i) instanceof Person) {
                Person person = (Person) records.get(i);
                System.out.println(i + 1 + ". " + person.getName() + " " + person.getSurname());
            } else if (records.get(i) instanceof Organization) {
                Organization organization = (Organization) records.get(i);
                System.out.println(i + 1 + ". " + organization.getName());
            }

        }
    }

    protected static void printRecordInfo(int index, java.util.List<Record> records) {
        if (index <= 0 || index > records.size()){
            return;
        }else {
            if (records.get(index - 1) instanceof Person) {
                Person person = (Person) records.get(index - 1);
                System.out.println(person.toString());
            } else if (records.get(index - 1) instanceof Organization) {
                Organization organization = (Organization) records.get(index - 1);
                System.out.println(organization.toString());
            }
        }
    }

    protected static void manageRecord(Scanner scanner, java.util.List<Record> records, int index){

        if (index <= 0 || index > records.size()) {
            return;
        }else {
            while (true){
                System.out.println();
                System.out.println("[record] Enter action (edit, delete, menu):");
                String action = scanner.nextLine();
                switch (action){
                    case "edit":{
                        editRecord(scanner, records, index);
                        printRecordInfo(index ,records);
                        break;
                    } case "delete":{
                        removeRecord(records,index);
                        break;
                    } case "menu":{
                        return;
                    }
                }
            }
        }
    }

    private static void removeRecord(java.util.List<Record> records, int index) {
        if (records.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            records.remove(index - 1);
            System.out.println("The record removed!");
        }
    }

    private static void editRecord(Scanner scanner, java.util.List<Record> records, int index) {
        if (records.size() == 0) {
            System.out.println("No records to edit!");
        } else {

            if (records.get(index - 1) instanceof Person) {
                Person person = (Person) records.get(index - 1);
                System.out.println("Select a field (name, surname, birth, gender, number):");
                editPerson(scanner, person);
            } else if (records.get(index - 1) instanceof Organization) {
                Organization organization = (Organization) records.get(index - 1);
                System.out.println("Select a field (name, address, number):");
                editOrganization(scanner, organization);
            }
        }
    }

    private static void editPerson(Scanner scanner, Person person) {
        String action = scanner.nextLine();
        switch (action) {
            case "name": {
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                person.setName(name);
                person.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
            case "surname": {
                System.out.println("Enter surname:");
                String surname = scanner.nextLine();
                person.setSurname(surname);
                person.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
            case "birth": {
                System.out.println("Enter birth date:");
                String birthDate = scanner.nextLine();
                person.setBirthDate(birthDate);
                person.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
            case "gender": {
                System.out.println("Enter gender:");
                String gender = scanner.nextLine();
                person.setGender(gender);
                person.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
            case "number": {
                System.out.println("Enter number:");
                String phoneNumber = scanner.nextLine();
                person.setPhoneNumber(phoneNumber);
                person.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
        }
    }

    private static void editOrganization(Scanner scanner, Organization organization) {
        String action = scanner.nextLine();
        switch (action) {
            case "name": {
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                organization.setName(name);
                organization.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
            case "address": {
                System.out.println("Enter address:");
                String surname = scanner.nextLine();
                organization.setAddress(surname);
                organization.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
            case "number": {
                System.out.println("Enter number:");
                String phoneNumber = scanner.nextLine();
                organization.setPhoneNumber(phoneNumber);
                organization.setDateOfModification(LocalDateTime.now());
                System.out.println("Saved");
                break;
            }
        }
    }
}
