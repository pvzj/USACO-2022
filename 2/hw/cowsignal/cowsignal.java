import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class cowsignal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String[] lines = new String[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i] = st.nextToken();
        }

        for (String s : lines) {
            for (int i = 0; i < k; i++) {
                pw.println(scaleLine(s, k));
            }
        }

        pw.close();
        br.close();
    }

    private static String scaleLine(String s, int k) {
        String newLine = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < k; j++) {
                newLine += s.charAt(i);
            }
        }
        return newLine;
    }
}
