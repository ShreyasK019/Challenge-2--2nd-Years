import java.io.*;
import java.util.*;

public class problem1 {

    public static String rotateRight(String s) {
        if (s.length() <= 1) return s;
        return s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
    }

    public static String rotateLeft(String s) {
        if (s.length() <= 1) return s;
        return s.substring(1) + s.charAt(0);
    }

    public static void main(String[] args) throws Exception {

        BufferedReader gridReader = new BufferedReader(new FileReader("../inputs/grid.txt"));
        BufferedReader dirReader = new BufferedReader(new FileReader("../inputs/directions.txt"));

        List<String> grid = new ArrayList<>();
        String line;

        while ((line = gridReader.readLine()) != null) {
            grid.add(line.trim());
        }

        // Directions: R L R L R
        String[] directions = dirReader.readLine().trim().split(" ");

        List<String> transformed = new ArrayList<>();

        for (String row : grid) {
            String current = row;

            for (String d : directions) {
                if (d.equals("R")) current = rotateRight(current);
                if (d.equals("L")) current = rotateLeft(current);
            }

            transformed.add(current);
        }

        int middleIndex = transformed.size() / 2;
        String middleRow = transformed.get(middleIndex);

        int sum = 0;
        for (char c : middleRow.toCharArray()) {
            sum += (int) c;
        }

        System.out.println(sum);

        // Write clue to file
        PrintWriter out = new PrintWriter("clue1.txt");
        out.println(sum);
        out.close();
    }
}