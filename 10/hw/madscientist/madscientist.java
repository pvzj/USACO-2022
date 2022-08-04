import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class madscientist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

        int n = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String b = br.readLine();

        pw.println(getMinFlips(a, b, n));
        pw.close();
        br.close();
    }

    private static int getMinFlips(String a, String b, int n) {
        boolean wasPreviousFlipped = false;
        int groupCount = 0;

        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (!wasPreviousFlipped) {
                    groupCount++;
                    wasPreviousFlipped = true;
                }
            } else {
                wasPreviousFlipped = false;
            }
        }

        return groupCount;
    }
}
