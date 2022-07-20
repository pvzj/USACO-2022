import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
class Rectangle {
    public int x1,y1,x2,y2;

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int area() {
        return (x2-x1)*(y2-y1);
    }
}

public class blockedbillboard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        StringTokenizer st = null;
        Rectangle[] rectArray = new Rectangle[3];

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            rectArray[i] = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int aStillVisible = rectArray[0].area() - findRectOverlapArea(rectArray[0], rectArray[2]);
        int bStillVisible = rectArray[1].area() - findRectOverlapArea(rectArray[1], rectArray[2]);
        pw.println(aStillVisible + bStillVisible);
        pw.close();
        br.close();
    }

    private static int findRectOverlapArea(Rectangle a, Rectangle b) {
        return findOverlapLengthOnOneAxis(a.x1, a.x2, b.x1, b.x2) * findOverlapLengthOnOneAxis(a.y1, a.y2, b.y1, b.y2);
    }

    private static int findOverlapLengthOnOneAxis(int a, int b, int c, int d) {
        if ((c > b && d > b) || (a > c && a > d)) {
            return 0;
        } else if((d >= b && a >= c) || (b >= d && c >= a)) {
            return Math.min(b-a, d-c);
        } else {
            return Math.min(b-c, d-a);
        }
    }
}
