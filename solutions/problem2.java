
import java.io.*;

public class problem2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("../inputs/input2.txt"));
        String s = br.readLine().trim();

        // Step 1: reverse
        StringBuilder sb = new StringBuilder(s).reverse();
        String rev = sb.toString();

        // Step 2: remove every 3rd (1-based index)
        StringBuilder removed = new StringBuilder();
        for (int i = 0; i < rev.length(); i++) {
            if ((i + 1) % 3 != 0) {
                removed.append(rev.charAt(i));
            }
        }

        // Step 3: shift +2 ASCII
        StringBuilder shifted = new StringBuilder();
        for (char c : removed.toString().toCharArray()) {
            shifted.append((char)(c + 2));
        }

        // Step 4: count vowels
        int vowelCount = 0;
        for (char c : shifted.toString().toCharArray()) {
            char lower = Character.toLowerCase(c);
            if (lower=='a' || lower=='e' || lower=='i' || lower=='o' || lower=='u') {
                vowelCount++;
            }
        }

        System.out.println(vowelCount);

        PrintWriter out = new PrintWriter("clue2.txt");
        out.println(vowelCount);
        out.close();
    }
}