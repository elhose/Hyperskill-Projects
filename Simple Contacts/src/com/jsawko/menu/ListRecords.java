package com.jsawko.menu;

import com.jsawko.data.Record;

import java.util.Scanner;


public class ListRecords extends Menu{

    public static void infoRecords(Scanner scanner, java.util.List<Record> records) {
        listRecords(records);
        if (records.size() == 0) {
            System.out.println("No records to show!");
        } else {
            System.out.println();
            System.out.println("[list] Enter action ([number], back):");
            String line = scanner.nextLine();
            if ("back".equals(line)) {
                return;
            }

            try {
                int index = Integer.parseInt(line);
                printRecordInfo(index, records);
                manageRecord(scanner, records, index);

            } catch (NumberFormatException e) {
//                System.out.println(e.getMessage());
            }
        }
    }

}
