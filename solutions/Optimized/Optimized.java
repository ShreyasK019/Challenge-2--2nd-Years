import java.io.*;
import java.util.*;

public class problem1 {

    // Efficient right rotation
    public static String rotateRight(String s) {
        int n = s.length();
        if (n <= 1) return s;
        return s.charAt(n - 1) + s.substring(0, n - 1);
    }

    // Efficient left rotation
    public static String rotateLeft(String s) {
        int n = s.length();
        if (n <= 1) return s;
        return s.substring(1) + s.charAt(0);
    }

    public static void main(String[] args) throws Exception {

        // Read grid lines
        List<String> grid;
        try (BufferedReader gridReader = new BufferedReader(new FileReader("../inputs/grid.txt"))) {
            grid = gridReader.lines().map(String::trim).toList();
        }

        // Read directions (R L R L R)
        String[] directions;
        try (BufferedReader dirReader = new BufferedReader(new FileReader("../inputs/directions.txt"))) {
            directions = dirReader.readLine().trim().split(" ");
        }

        List<String> transformed = new ArrayList<>(grid.size());

        for (String row : grid) {
            String current = row;

            // Apply all rotations to the row
            for (String d : directions) {
                current = (d.equals("R")) ? rotateRight(current) : rotateLeft(current);
            }

            transformed.add(current);
        }

        // Middle row
        String middleRow = transformed.get(transformed.size() / 2);

        // Sum ASCII values
        int sum = 0;
        for (int i = 0; i < middleRow.length(); i++) {
            sum += middleRow.charAt(i);
        }

        System.out.println(sum);

        // Write result
        try (PrintWriter out = new PrintWriter("clue1.txt")) {
            out.println(sum);
        }
    }
}

