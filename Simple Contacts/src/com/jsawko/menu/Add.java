package com.jsawko.menu;

import com.jsawko.data.Organization;
import com.jsawko.data.Person;
import com.jsawko.data.Record;

import java.util.List;
import java.util.Scanner;

public class Add extends Menu {

    public static void addRecord(Scanner scanner, List<Record> records){
        System.out.println("Enter the type (person, organization):");
        String type = scanner.nextLine();
        if (type.equals("person")){
            addPerson(scanner, records);
        }else if (type.equals("organization")){
            addOrganization(scanner, records);
        }
    }

    private static void addPerson(Scanner scanner, List<Record> records){
        System.out.println("Enter the name:");
        String name = scanner.nextLine();

        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter the birth date:");
        String birthDate = scanner.nextLine();
        if (!Person.isBirthDayValid(birthDate)){
            System.out.println("Bad birth date!");
        }

        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        if (!Person.isGenderValid(gender)){
            System.out.println("Bad gender!");
        }

        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();

        Person person = new Person(name,phoneNumber,surname,birthDate,gender);
        records.add(person);

        System.out.println("The record added.");
    }

    private static void addOrganization(Scanner scanner, List<Record> records){
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();

        Record organization = new Organization(name,phoneNumber,address);
        records.add(organization);

        System.out.println("The record added.");
    }
}
