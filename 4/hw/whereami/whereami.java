import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class whereami {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("whereami.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
        int n = Integer.parseInt(br.readLine());
        String colorString = br.readLine();
        pw.println(findSmallestK(n, colorString));
        pw.close();
        br.close();
    }

    private static int findSmallestK(int n, String colorString) {
        int smallestK = 0;
        boolean uniqueStringFound = false;
        while (!uniqueStringFound) {
            smallestK++;
            Set<String> hs = new HashSet<>();
            for (int i = 0; i <= colorString.length() - smallestK; i++) {
                hs.add(colorString.substring(i, i+smallestK));
            }
            System.out.println(hs);
            if (hs.size() == colorString.length() - smallestK + 1) {
                uniqueStringFound = true;
            }

        }
        return smallestK;
    }
}
