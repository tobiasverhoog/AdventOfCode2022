import java.util.List;

public class Day8 {

    public static void main(String[] args) {
        List<String> rows = Utils.readFile("input/ExampleInput.txt");

        Integer[][] grid = new Integer[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);
            Integer[] treeRow = new Integer[row.length()];
            for (int j = 0; j < row.length(); j++) {
                treeRow[j] = Integer.valueOf(row.substring(j, j+1));
            }

        }


    }
}
