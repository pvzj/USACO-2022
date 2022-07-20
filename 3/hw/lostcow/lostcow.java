import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class lostcow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        pw.println(findTotalDistance(0, y-x));
        pw.close();
        br.close();
    }

    private static int findTotalDistance(int x, int y) {
        int finalDistance = 0;
        x = 1;
        boolean foundCow = false;

        while (!foundCow) {
            if (Math.abs(x) >= Math.abs(y) && ((x > 0 && y > 0) || (x < 0 && y < 0))) {
                finalDistance += Math.abs((x/-2) - y);
                foundCow = true;
            } else {
                finalDistance += Math.abs((x/-2) - x);
            }
            x *= -2;

        }
        return finalDistance;
    }
}
