import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static void main(String[] args) {

        List<String> rows = new ArrayList<>();
        try {
            Files.lines(Paths.get("input/InputDay3.txt"))
                    .forEach(rows::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        String[][] fullList = new String[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            int mid = rows.get(i).length() / 2;
            fullList[i] = new String[]{rows.get(i).substring(0, mid), rows.get(i).substring(mid)};
        }

        int sumOfPriorities = 0;

        for (String[] row : fullList
        ) {
            String firstHalf = row[0];
            String secondHalf = row[1];

            for (char ch : firstHalf.toCharArray()) {
                if (stringContainsChar(secondHalf, ch)) {
                    sumOfPriorities += convertCharToIntValue(ch);
                    System.out.println("First half is: " + firstHalf);
                    System.out.println("Second half is: " + secondHalf);
                    System.out.println("This char is in both: " + ch);
                    System.out.println("This char has value: " + convertCharToIntValue(ch));
                    break;
                }
            }

        }
        System.out.println("Answer 1: " + sumOfPriorities);

        int sumOfBadges = 0;
        for (int i = 0; i < rows.size(); i += 3) {
            String elf1 = rows.get(i);
            String elf2 = rows.get(i + 1);
            String elf3 = rows.get(i + 2);
            String group = elf1 + elf2 + elf3;

            for (char ch : group.toCharArray()) {
                if (stringContainsChar(elf1, ch) && stringContainsChar(elf2, ch) && stringContainsChar(elf3, ch)) {
                    sumOfBadges += convertCharToIntValue(ch);
                    System.out.println("Elf1: " + elf1);
                    System.out.println("Elf2: " + elf2);
                    System.out.println("Elf3: " + elf3);
                    System.out.println("Badge is: " + ch);
                    break;
                }
            }
        }
        System.out.println("Answer 2: " + sumOfBadges);
    }


    private static void fullListPrinter(String[][] fullList) {
        for (String[] stringArray :
                fullList) {
            for (String str :
                    stringArray) {
                System.out.println(str);
            }
        }
    }

    private static int convertCharToIntValue(char c) {
        if (Character.isUpperCase(c)) {
            return c - 'A' + 27;
        } else {
            return c - 'a' + 1;
        }
    }

    private static boolean stringContainsChar(String str, char c) {
        for (char characterInString : str.toCharArray()) {
            if (c == characterInString) {
                return true;
            }
        }
        return false;
    }


}
