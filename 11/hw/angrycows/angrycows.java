import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class angrycows {
    private static HashSet<Integer> bales = new HashSet<>();
    public static void main(String[] args) throws IOException {
        String fileName = "angry";
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bales.add(Integer.parseInt(br.readLine()));
        }

        int max = -1;
        for (int i : bales) {
            // System.out.println();
            int val = getExplodedBales(i, 1, new HashSet<>(bales));
            if (val > max) {
                max = val;
            }
        }
        pw.println(max);

        pw.close();
        br.close();
    }

    private static int getExplodedBales(int start, int radius, HashSet<Integer> bales) {
        // System.out.println(start + " " + radius);
        bales.remove(start);
        int baleSum = 1;
        List<Integer> reactions = new ArrayList<>();

        for (int i = 1; i <= radius; i++) {
            if (bales.contains(start+i)) {
                reactions.add(start+i);
                bales.remove(start+i);
            }

            if (bales.contains(start-i)) {
                reactions.add(start-i);
                bales.remove(start-i);
            }
        }

        for (int i : reactions) {
            baleSum += getExplodedBales(i, radius+1, bales);
        }
        return baleSum;
    }
}
