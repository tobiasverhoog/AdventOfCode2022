package test.Day10;

import main.Day10.CPU;
import main.Day10.Instruction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CPUTest {

    @Test
    void loadNextInstructionTest() {
        List<Instruction> example = new ArrayList<>(List.of(
                Instruction.NOOP,
                new Instruction(2, 3),
                Instruction.NOOP,
                new Instruction(2, -5)
        ));

        CPU cpu = new CPU(example);
        assertEquals(Instruction.NOOP, cpu.getCurrentInstruction());
        assertEquals(1, cpu.getCyclesRemaining());

        cpu.loadNextInstruction();
        assertEquals(new Instruction(2, 3), cpu.getCurrentInstruction());
        assertEquals(2, cpu.getCyclesRemaining());

        cpu.loadNextInstruction();
        assertEquals(Instruction.NOOP, cpu.getCurrentInstruction());
        assertEquals(1, cpu.getCyclesRemaining());

        cpu.loadNextInstruction();
        assertEquals(new Instruction(2, -5), cpu.getCurrentInstruction());
        assertEquals(2, cpu.getCyclesRemaining());
    }

    @Test
    void testTick() {
        List<Instruction> example = new ArrayList<>(List.of(
                Instruction.NOOP,
                new Instruction(2, 3),
                new Instruction(2, -5)
        ));

        CPU cpu = new CPU(example);

//        At the start of the first cycle
        assertEquals(1, cpu.getNextCycle());
        assertEquals(1, cpu.getX());
        assertEquals(1, cpu.getCyclesRemaining());
        assertEquals(Instruction.NOOP, cpu.getCurrentInstruction());

        cpu.tick();

//        At the end of the first cycle / start of the second cycle
        assertEquals(2, cpu.getNextCycle());
        assertEquals(1, cpu.getX());
        assertEquals(2, cpu.getCyclesRemaining());
        assertEquals(new Instruction(2, 3), cpu.getCurrentInstruction());

        cpu.tick();

//        At the end of the second cycle / start of the third cycle
        assertEquals(3, cpu.getNextCycle());
        assertEquals(1, cpu.getX());
        assertEquals(1, cpu.getCyclesRemaining());
        assertEquals(new Instruction(2, 3), cpu.getCurrentInstruction());

        cpu.tick();

//        At the end of the third cycle / start of the fourth cycle
        assertEquals(4, cpu.getNextCycle());
        assertEquals(4, cpu.getX());
        assertEquals(2, cpu.getCyclesRemaining());
        assertEquals(new Instruction(2, -5), cpu.getCurrentInstruction());

        cpu.tick();

//        At the end of the fourth cycle / start of the fifth cycle
        assertEquals(5, cpu.getNextCycle());
        assertEquals(4, cpu.getX());
        assertEquals(1, cpu.getCyclesRemaining());
        assertEquals(new Instruction(2, -5), cpu.getCurrentInstruction());

        cpu.tick();

//        At the end of the fifth cycle / start of the sixth cycle
        assertEquals(6, cpu.getNextCycle());
        assertEquals(-1, cpu.getX());
        assertEquals(0, cpu.getCyclesRemaining());
        assertEquals(new Instruction(2, -5), cpu.getCurrentInstruction());

    }
}