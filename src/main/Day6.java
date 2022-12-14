package main;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day6 {
    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        try {
            Files.lines(Paths.get("input/InputDay6.txt"))
                    .forEach(rows::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        String input = rows.get(0);

        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char ch :
                input.toCharArray()) {
            characterArrayList.add(ch);
        }

        int answer = 0;

        ArrayList<Character> currentBlock = new ArrayList<>();
        for (int i = 13; i < characterArrayList.size(); i++) {
            currentBlock.clear();
            for (int j = 0; j < 13; j++) {
                currentBlock.add((characterArrayList.get(i - j)));
            }

            if (blockHasMarker(currentBlock)) {
                answer = i;
                break;
            }
        }
        System.out.println("Answer: " + answer);
    }

    private static boolean blockHasMarker(ArrayList<Character> block) {
        boolean currentBlockHasMarker = true;
        block.sort(null);
        for (int i = 1; i < block.size(); i++) {
            if (block.get(i) == block.get(i - 1)) {
                currentBlockHasMarker = false;
            }
        }
        return currentBlockHasMarker;
    }
}
