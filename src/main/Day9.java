package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day9 {

    private static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int euclid(Position other) {
            return Math.max(Math.abs(this.x - other.x), Math.abs(this.y - other.y));
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    private static class Move {

    }


    public void bla() {
        ArrayList<String> rows = new ArrayList<>(Utils.readFile("input/InputDay9.txt"));

        Position head = new Position(0, 0);
        Position prev;
        Position knot1 = new Position(0, 0);

        Set<Position> visited = new HashSet<>();

        for (String row : rows) {
            String[] split = row.split(" ");
            int travelDistance = Integer.parseInt(split[1]);

            for (int i = 0; i < travelDistance; i++) {
                prev = head;


                switch (split[0]) {
                    case "U":
                        head = new Position(head.x, head.y + 1);
                        break;
                    case "D":
                        head = new Position(head.x, head.y - 1);
                        break;
                    case "L":
                        head = new Position(head.x - 1, head.y);
                        break;
                    case "R":
                        head = new Position(head.x + 1, head.y);
                        break;
                }

                if (head.euclid(knot1) == 2) {
                    knot1 = prev;
                }

                visited.add(knot1);
            }
        }

        System.out.println(visited.size());
    }

    public static void main(String[] args) {
        Day9 m = new Day9();
        m.bla();
    }

}