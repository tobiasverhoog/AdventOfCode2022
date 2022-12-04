import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    public static void main(String[] args) {
        List<String> rows = new ArrayList<>();
        try{
            Files.lines(Paths.get("input/InputDay2.txt"))
                    .forEach(rows::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        int totalScore = 0;

        for (String row :
                rows) {
           String otherAction = row.split(" ")[0];
           String myAction = calculateMyAction(row);
           totalScore += scoredValueOf(myAction);
           totalScore += scoreOfWinOrLose(myAction, otherAction);
        }

        System.out.println("Answer2, Total score: " + totalScore);

    }

    private static String calculateMyAction(String row) {
        switch (row) {
            case "A X":
            case "B Z":
            case "C Y":
                return "Z";
            case "A Y":
            case "B X":
            case "C Z":
                return "X";
            case "A Z":
            case "B Y":
            case "C X":
                return "Y";
        }
        return "";
    }

    private static int scoreOfWinOrLose(String myAction, String otherAction) {
        if ("X".equals(myAction)) {
            switch (otherAction) {
                case "A":
                    return 3;
                case "B":
                    return 0;
                case "C":
                    return 6;
            }
        }
        if ("Y".equals(myAction)) {
            switch (otherAction) {
                case "A":
                    return 6;
                case "B":
                    return 3;
                case "C":
                    return 0;
            }
        }
        if ("Z".equals(myAction)) {
            switch (otherAction) {
                case "A":
                    return 0;
                case "B":
                    return 6;
                case "C":
                    return 3;
            }
        }
        return 0;
    }

    private static int scoredValueOf(String myAction) {
        switch (myAction) {
            case "X":
                return 1;
            case "Y":
                return 2;
            case "Z":
                return 3;
        }
        return 0;
    }
}
