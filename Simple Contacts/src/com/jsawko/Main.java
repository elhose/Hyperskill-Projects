package com.jsawko;

import com.jsawko.data.Record;
import com.jsawko.menu.Add;
import com.jsawko.menu.ListRecords;
import com.jsawko.menu.Menu;
import com.jsawko.menu.Search;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfDataBase;
        try {
             nameOfDataBase = args[0];
        }catch (ArrayIndexOutOfBoundsException e){
             nameOfDataBase = "exampleDatabase.db";
        }

        //deserialization
        List<Record> records = deserialize(nameOfDataBase);


        String action;
        while (true) {
            Menu.showCommands();
            action = scanner.nextLine();
            switch (action) {

                case "add": {
                    Add.addRecord(scanner, records);
                    break;
                }
                case "list": {
                    ListRecords.infoRecords(scanner, records);
                    break;
                }
                case "search": {
                    Search.manageSearch(scanner,records);
                    break;
                }
                case "count": {
                    System.out.println("The Phone Book has " + records.size() + " records.");
                    break;
                }
                case "exit": {
                    //serialization
                    serialize(records,nameOfDataBase);
                    return;
                }
                default:
//                    System.out.println("Unknown input. Try Again.");
            }
            System.out.println();
        }


    }

    public static void serialize(List<Record> records, String arg){

        if (arg.equals(null)){
            arg = "exampleDatabase.db";
        }

        try(FileOutputStream fos = new FileOutputStream(arg);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){

            oos.writeObject(records);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<Record> deserialize(String arg){

        File file = new File(arg);

        if (arg.equals(null)){
            arg = "exampleDatabase.db";
        }else if (!file.exists() && !file.isDirectory() && !file.isFile()){
            return new ArrayList<>();
        }

        try(FileInputStream fis = new FileInputStream(arg);
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            @SuppressWarnings("unchecked")
            List<Record> records = new ArrayList<>();
            records = (List<Record>) ois.readObject();
            return records;


        }catch (IOException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}


