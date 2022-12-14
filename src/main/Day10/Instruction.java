package main.Day10;

import java.util.ArrayList;
import java.util.List;

public record Instruction(int cycles, int value) {

    public static final Instruction NOOP = new Instruction(1, 0);

    public static Instruction parseInstruction(String input) {
        if ("noop".equals(input)) {
            return NOOP;
        }
        String operation = input.split(" ")[1];
        return new Instruction(2, Integer.parseInt(operation));
    }
    public static List<Instruction> parseInstructions(ArrayList<String> input) {
        List<Instruction> instructions = new ArrayList<>();
        for (String row :
                input) {
            instructions.add(parseInstruction(row));
        }
        return instructions;
    }
}
