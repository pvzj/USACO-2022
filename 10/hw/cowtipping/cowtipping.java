import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class cowtipping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowtip.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
        int n = Integer.parseInt(br.readLine());
        boolean[][] cows = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') {
                    cows[i][j] = true;
                }
            }
        }
        pw.println(getMinFlips(cows, n));
        pw.close();
        br.close();
    }

    private static int getMinFlips(boolean[][] cows, int n) {
        int count = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (cows[i][j]) {
                    flipCows(cows, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void flipCows(boolean[][] cows, int x, int y) {
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                cows[i][j] = !cows[i][j];
            }
        }
    }
}
