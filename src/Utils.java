import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    static List<String> readFile(String path) {
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
