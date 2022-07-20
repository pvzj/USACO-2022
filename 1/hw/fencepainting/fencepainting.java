import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class fencepainting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));

        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());



        pw.println(findTotalLength(a, b, c, d));
        br.close();
        pw.close();
    }

    private static int findTotalLength(int a, int b, int c, int d) {
        if ((c > b && d > b) || (a > c && a > d)) { // no overlap
            return (b-a) + (d-c);
        } else { // partially or completely overlapping
            int max = Math.max(Math.max(a, b), Math.max(c,d));
            int min = Math.min(Math.min(a,b), Math.min(c,d));
            return max - min;
        }
    }
}
