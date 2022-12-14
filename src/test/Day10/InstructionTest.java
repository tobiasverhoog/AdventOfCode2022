package test.Day10;

import main.Day10.Instruction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {

    @Test
    void parseInstructionNOOP() {
        Instruction result = Instruction.parseInstruction("noop");
        Instruction expected = Instruction.NOOP;

        assertEquals(expected, result);
    }

    @Test
    void parseInstructionAddX() {
        Instruction result = Instruction.parseInstruction("addx 2");
        Instruction expected = new Instruction(2, 2);
        assertEquals(expected, result);

        result = Instruction.parseInstruction("addx -7");
        expected = new Instruction(2, -7);
        assertEquals(expected, result);
    }

    @Test
    void parseInstructions() {
        ArrayList<String> sample = new ArrayList<>(List.of(
                "addx 15",
                "addx -11",
                "noop",
                "addx 6",
                "noop"
        ));
        List<Instruction> result = Instruction.parseInstructions(sample);
        List<Instruction> expected = new ArrayList<>(List.of(
                new Instruction(2, 15),
                new Instruction(2, -11),
                Instruction.NOOP,
                new Instruction(2, 6),
                Instruction.NOOP
        ));
        assertEquals(expected, result);
    }
}