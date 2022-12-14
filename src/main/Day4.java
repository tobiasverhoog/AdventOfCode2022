package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day4 {

    public static void main(String[] args) {

        List<String> rows = new ArrayList<>();
        try {
            Files.lines(Paths.get("input/InputDay4.txt"))
                    .forEach(rows::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        int counter1 = 0;
        int counter2 = 0;
        for (String row :
                rows) {
            String firstElf = row.split(",")[0];
            String secondElf = row.split(",")[1];
            int A1 = Integer.parseInt(firstElf.split("-")[0]);
            int A2 = Integer.parseInt(firstElf.split("-")[1]);
            int B1 = Integer.parseInt(secondElf.split("-")[0]);
            int B2 = Integer.parseInt(secondElf.split("-")[1]);
            if ((A1 <= B1 && A2 >= B2) || (A1 >= B1 && A2 <= B2)) {
                counter1++;
            }
            if ((A1 >= B1 && A1 <= B2) || (B1 >= A1 && B1 <= A2)) {
                counter2++;
            }
        }

        System.out.println("Answer 1: " + counter1);
        System.out.println("Answer 2: " + counter2);

    }

}
