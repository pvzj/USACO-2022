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

public class blockedbillboard2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        Rectangle lawnMower = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Rectangle cowFeed = new Rectangle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        // System.out.println(isPointInsideRectangle(2, -1, cowFeed));
        // System.out.println(numberOfCorners(cowFeed, lawnMower));
        pw.println(findMinTarpSize(cowFeed, lawnMower));
        pw.close();
        br.close();
    }

    private static int findMinTarpSize(Rectangle cowFeed, Rectangle lawnMower) {
        int numberOfCorners = numberOfCorners(cowFeed, lawnMower);
        if (numberOfCorners == 0 || numberOfCorners == 1) {
            return lawnMower.area();
        } else if (numberOfCorners == 4) {
            return 0;
        } else {
            return lawnMower.area() - findRectOverlapArea(cowFeed, lawnMower);
        }
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

    private static int isPointInsideRectangle(int x, int y, Rectangle rect) {
        if (rect.x2 >= x && x >= rect.x1 && rect.y2 > y && y >= rect.y1) {
            return 1;
        }
        return 0;
    }

    private static int numberOfCorners(Rectangle cowFeed, Rectangle lawnMower) {
        return isPointInsideRectangle(lawnMower.x1, lawnMower.y1, cowFeed) + isPointInsideRectangle(lawnMower.x2, lawnMower.y1, cowFeed) + isPointInsideRectangle(lawnMower.x1, lawnMower.y2, cowFeed) + isPointInsideRectangle(lawnMower.x2, lawnMower.y2, cowFeed);
    }
}
