package com.jsawko.menu;

import com.jsawko.data.Organization;
import com.jsawko.data.Person;
import com.jsawko.data.Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search extends Menu {
    public static List<Record> searchRecords(Scanner scanner, List<Record> records){
            System.out.println("Enter search query:");
            String searchString = scanner.nextLine();
            List<Record> foundRecords = new ArrayList<>();
            for (Record record: records){
                if (record.getName().contains(searchString)){
                    foundRecords.add(record);
                }
            }
            System.out.println("Found " + foundRecords.size() + " results:");
            listRecords(foundRecords);
            return foundRecords;

    }

    public static void manageSearch(Scanner scanner, List<Record> records){
        List<Record> foundRecords = searchRecords(scanner,records);


            System.out.println();
            System.out.println("[search] Enter action ([number], back, again):");
            String action = scanner.nextLine();
            switch (action){
                case "again":{
                    manageSearch(scanner,records);
                    break;
                } case "back":{
                    return;
                } default:{
                    try {
                        int index = Integer.parseInt(action);
                        printRecordInfo(index, foundRecords);
                        manageRecord(scanner,foundRecords,index);
                        mergeLists(foundRecords,records);
                    }catch (NumberFormatException e){
//                        e.printStackTrace();
                    }
                }
            }
    }

    private static void mergeLists(List<Record> foundRecords, List<Record> records){
        for (Record foundRecord: foundRecords){
            for (Record record: records){
                if (foundRecord.getID().equals(record.getID())){
                    record = modifyRecord(foundRecord);
                }
            }
        }
    }

    private static Record modifyRecord(Record foundRecord){
        if (foundRecord instanceof Person){
            return new Person(foundRecord.getName(), foundRecord.getPhoneNumber(), ((Person) foundRecord).getSurname(), ((Person) foundRecord).getBirthDate(), ((Person) foundRecord).getGender());
        }else if (foundRecord instanceof Organization){
            return new Organization(foundRecord.getName(), foundRecord.getPhoneNumber(), ((Organization) foundRecord).getAddress());
        }else return null;
    }
}
