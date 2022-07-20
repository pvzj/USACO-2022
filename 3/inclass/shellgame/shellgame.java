import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class shellgame {
    private static int[] scores = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));

        StringTokenizer st = null;

        int n = Integer.parseInt(br.readLine());

        int[] state = {0, 1, 2};
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            // System.out.println(a+" " + b + " " + g);
            simulateShellRound(state, g, a, b);
        }
        // System.out.println(Arrays.toString(scores));
        pw.println(Math.max(Math.max(scores[0], scores[1]), scores[2]));
        pw.close();
        br.close();
    }

    private static void simulateShellRound(int[] state, int guess, int a, int b) {
        swap(state, a, b);
        scores[state[guess-1]]++;
    }

    private static void swap(int[] array, int a, int b) {
        int temp = array[a-1];
        array[a-1] = array[b-1];
        array[b-1] = temp;
    }
}
