import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day5 {
    public static void main(String[] args) {

        List<String> instructions = new ArrayList<>();
        try {
            Files.lines(Paths.get("input/InputDay5-instructions.txt"))
                    .forEach(instructions::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        ArrayList<Character>[] listOfStacks = new ArrayList[9];

        listOfStacks[0] = new ArrayList<>(Arrays.asList('Q', 'G', 'P', 'R', 'L', 'C', 'T', 'F'));
        listOfStacks[1] = new ArrayList<>(Arrays.asList('J', 'S', 'F', 'R', 'W', 'H', 'Q', 'N'));
        listOfStacks[2] = new ArrayList<>(Arrays.asList('Q', 'M', 'P', 'W', 'H', 'B', 'F'));
        listOfStacks[3] = new ArrayList<>(Arrays.asList('F', 'D', 'T', 'S', 'V'));
        listOfStacks[4] = new ArrayList<>(Arrays.asList('Z', 'F', 'V', 'W', 'D', 'L', 'Q'));
        listOfStacks[5] = new ArrayList<>(Arrays.asList('S', 'L', 'C', 'Z'));
        listOfStacks[6] = new ArrayList<>(Arrays.asList('F', 'D', 'V', 'M', 'B', 'Z'));
        listOfStacks[7] = new ArrayList<>(Arrays.asList('B', 'J', 'T'));
        listOfStacks[8] = new ArrayList<>(Arrays.asList('H', 'P', 'S', 'L', 'G', 'B', 'N', 'Q'));

        for (String row :
                instructions) {
            int amount = Integer.parseInt(row.split(" ")[1]);
            int fromStack = Integer.parseInt(row.split(" ")[3]);
            int toStack = Integer.parseInt(row.split(" ")[5]);
            for (int i = 0; i < amount; i++) {
                listOfStacks[toStack-1].add(i, listOfStacks[fromStack-1].get(0));
                listOfStacks[fromStack-1].remove(0);
            }
            

        }
        StringBuilder answer = new StringBuilder();
        for (ArrayList<Character> stack :
                listOfStacks) {
            answer.append(stack.get(0));
        }
        System.out.println("Answer: " + answer);
    }
}
