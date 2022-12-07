import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day6_alternative {
    public static void main(String[] args) {
        List<String> rows = readFile("input/InputDay6.txt");

        String s = rows.get(0);
        int answer = IntStream
                .range(0, s.length())
                .filter(i -> s.substring(i, i + 14).chars().distinct().count() == 14)
                .findFirst()
                .getAsInt() + 14;

        System.out.println("Answer: " + answer);
    }

    private static List<String> readFile(String path) {
        List<String> rows = new ArrayList<>();
        try {
            Files.lines(Paths.get(path))
                    .forEach(rows::add);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return rows;
    }
}
