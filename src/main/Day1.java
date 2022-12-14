package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) {
    List<String> rows = new ArrayList<>();
        try{
            Files.lines(Paths.get("input/InputDay1.txt")).forEach(rows::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        int highScore1 = 0;
        int highScore2 = 0;
        int highScore3 = 0;
        int caloriesPerElf = 0;
        for (String value: rows) {
            if ("".equals(value)) {
                if (caloriesPerElf > highScore1) {
                    highScore3 = highScore2;
                    highScore2 = highScore1;
                    highScore1 = caloriesPerElf;
                } else if (caloriesPerElf > highScore2) {
                    highScore3 = highScore2;
                    highScore2 = caloriesPerElf;
                } else if (caloriesPerElf > highScore3) {
                    highScore3 = caloriesPerElf;
                }
                caloriesPerElf = 0;
            } else {
                caloriesPerElf += Integer.parseInt(value);
            }
        }
        System.out.println("High score 1 is: " + highScore1);
        System.out.println("High score 2 is: " + highScore2);
        System.out.println("High score 3 is: " + highScore3);
        System.out.println("Total high score is: " + (highScore1 + highScore2 + highScore3));
    }
}