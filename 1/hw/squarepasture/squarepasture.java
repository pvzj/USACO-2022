import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class squarepasture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("square.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());
        int x4 = Integer.parseInt(st.nextToken());
        int y4 = Integer.parseInt(st.nextToken());

        pw.println(findLargestSquare(x1, y1, x2, y2, x3, y3, x4, y4));
        pw.close();
        br.close();
    }

    private static int findLargestSquare(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        int bottomX = Math.min(x1, x3);
        int bottomY = Math.min(y1,y3);
        int topX = Math.max(x2, x4);
        int topY = Math.max(y2, y4);
        int sideLength = Math.max(topX - bottomX, topY - bottomY);
        return sideLength * sideLength;
    }
}
