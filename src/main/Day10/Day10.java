package main.Day10;

import main.Utils;

import java.util.ArrayList;
import java.util.Arrays;

public class Day10 {

    public static void main(String[] args) {
        int x = 1;
        int cycleNumber = 0;
        int answerSum = 0;
        ArrayList<Integer> interestingCycles = new ArrayList<>(Arrays.asList(20, 60, 100, 140, 180, 220));
        ArrayList<String> rows = new ArrayList<>(Utils.readFile("input/ExampleInput.txt"));

        for (String row :
                rows) {
            cycleNumber++;
            checkInterestingCycleAndAddSum();
            System.out.println("Cyclenumber: " + cycleNumber);
            if (!"noop".equals(row)) {
                cycleNumber++;

                String operation = row.split(" ")[1];
                x += Integer.parseInt(operation);
            }


        }
        System.out.println("Answer 1: " + answerSum);

    }

    private static void checkInterestingCycleAndAddSum() {
//        if (interestingCycles.contains(cycleNumber)) {
//            System.out.println("Interesting cycle: " + cycleNumber);
//            System.out.println("AnswerSum was: " + answerSum);
//            System.out.println("Value x is: " + x);
//            answerSum += cycleNumber * x;
//            System.out.println("AnswerSum is now: " + answerSum);
//        }
    }
}

