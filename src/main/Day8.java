package main;

import java.util.List;

public class Day8 {

    static Integer[][] grid;

    public static void main(String[] args) {
        List<String> rows = Utils.readFile("input/InputDay8.txt");

        grid = new Integer[rows.size()][];

        for (int i = 0; i < rows.size(); i++) {
            String row = rows.get(i);
            Integer[] treeRow = new Integer[row.length()];
            for (int j = 0; j < row.length(); j++) {
                treeRow[j] = Integer.valueOf(row.substring(j, j+1));
            }
            grid[i] = treeRow;

        }

        int visibleTreeCounter = 0;
        int scenicHighScore = 0;

        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (hasLineOfSightToEdge(i, j)) {
                    visibleTreeCounter++;
                }
                int scenicScore = calculateScenicScore(i, j);
                if (scenicScore > scenicHighScore) {
                    scenicHighScore = scenicScore;
                }
            }
        }

        System.out.println("Answer 2: " + scenicHighScore);

        int topRow = grid[0].length;
        int bottomRow = topRow;
        int leftRow = grid.length - 2;
        int rightRow = leftRow;
        int visibleTrees = visibleTreeCounter + topRow + bottomRow + leftRow + rightRow;
        System.out.println("Answer 1: " + visibleTrees);

    }

    private static int calculateScenicScore(int x, int y) {

        return scoreWest(x, y) * scoreEast(x, y) * scoreNorth(x, y) * scoreSouth(x, y);
    }

    private static int scoreWest(int x, int y) {
        int score = 0;
        for (int i = x - 1; i >= 0 ; i--) {
            score++;
            if (grid[y][x] <= grid[y][i]) {
                break;
            }
        }
        return score;
    }
    private static int scoreEast(int x, int y) {
        int score = 0;
        for (int i = x + 1; i < grid.length; i++) {
            score++;
            if (grid[y][x] <= grid[y][i]) {
                break;
            }
        }
        return score;
    }
    private static int scoreNorth(int x, int y) {
        int score = 0;
        for (int i = y - 1; i >= 0 ; i--) {
            score++;
            if (grid[y][x] <= grid[i][x]) {
                break;
            }
        }
        return score;
    }
    private static int scoreSouth(int x, int y) {
        int score = 0;
        for (int i = y + 1; i < grid[y].length; i++) {
            score++;
            if (grid[y][x] <= grid[i][x]) {
                break;
            }
        }
        return score;
    }

    private static boolean hasLineOfSightToEdge(int x, int y) {

//        check west
        boolean isVisible = checkWest(x, y);
        if (isVisible) return true;

//        check east
        isVisible = checkEast(x, y);
        if (isVisible) return true;

//        check north
        isVisible = checkNorth(x, y);
        if (isVisible) return true;

//        check south
        isVisible = checkSouth(x, y);
        return isVisible;
    }

    private static boolean checkSouth(int x, int y) {
        for (int i = y + 1; i < grid[y].length; i++) {
            if (grid[y][x] <= grid[i][x]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkNorth(int x, int y) {
        for (int i = y - 1; i >= 0 ; i--) {
            if (grid[y][x] <= grid[i][x]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkEast(int x, int y) {
        for (int i = x + 1; i < grid.length; i++) {
            if (grid[y][x] <= grid[y][i]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWest(int x, int y) {
        for (int i = x - 1; i >= 0 ; i--) {
            if (grid[y][x] <= grid[y][i]) {
                return false;
            }
        }
        return true;
    }
}
