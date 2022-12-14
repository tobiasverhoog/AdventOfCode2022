package main.Day10;

import java.util.ArrayList;
import java.util.List;

public class CPU {
    private List<Instruction> instructions = new ArrayList<>();
    private int x = 1;
    private int nextCycle = 1;
    private Instruction currentInstruction;
    private int cyclesRemaining;
    private int instructionIndex = 0;

    public CPU(List<Instruction> instructions) {
        this.instructions = instructions;
        this.currentInstruction = instructions.get(0);
        this.cyclesRemaining = instructions.get(0).cycles();
    }

    public void loadNextInstruction() {
        if (instructionIndex < instructions.size() - 1) {
            instructionIndex++;
            this.currentInstruction = instructions.get(instructionIndex);
            this.cyclesRemaining = currentInstruction.cycles();
        }
    }

    public void tick() {
        cyclesRemaining--;
        if (cyclesRemaining <= 0) {
            x += currentInstruction.value();
            loadNextInstruction();
        }
        nextCycle++;
    }

    public Instruction getCurrentInstruction() {
        return currentInstruction;
    }

    public int getCyclesRemaining() {
        return cyclesRemaining;
    }

    public int getNextCycle() {
        return nextCycle;
    }

    public int getX() {
        return x;
    }
}
