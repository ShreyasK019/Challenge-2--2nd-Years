import java.io.*;
import java.util.*;

public class problem3 {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("../inputs/states.txt"));
        String[] parts = br.readLine().trim().split(" ");

        int countDone = 0;

        for (String p : parts) {
            int num = Integer.parseInt(p);

            if (isPrime(num)) countDone++;
            else if (num % 2 == 0) countDone++;
            // odd composite → not done
        }

        System.out.println(countDone);

        PrintWriter out = new PrintWriter("clue3.txt");
        out.println(countDone);
        out.close();
    }
}