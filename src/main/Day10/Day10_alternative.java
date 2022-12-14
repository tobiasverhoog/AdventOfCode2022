package main.Day10;

import main.Utils;

import java.util.ArrayList;
import java.util.List;

public class Day10_alternative {
    public static void main(String[] args) {
        ArrayList<String> rows = new ArrayList<>(Utils.readFile("input/InputDay10.txt"));

        List<Instruction> instructions = Instruction.parseInstructions(rows);

        CPU cpu = new CPU(instructions);
        int signalStrengthSum = 0;

        ArrayList<Integer> interestingCycles = new ArrayList<>(List.of(
                20, 60, 100, 140, 180, 220
        ));
        while (cpu.getNextCycle() <= 220) {
            cpu.tick();
            if (interestingCycles.contains(cpu.getNextCycle())) {
                int signalStrength = cpu.getX() * cpu.getNextCycle();
                signalStrengthSum += signalStrength;
            }

        }
        System.out.println("Signal Strength sum is " + signalStrengthSum);
    }
}
