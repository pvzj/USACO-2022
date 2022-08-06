import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class sleepycowherding {
    public static void main(String[] args) throws IOException {
        String fileName = "herding";
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] positions = {
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken()),
            Integer.parseInt(st.nextToken())
        };

        Arrays.sort(positions);

        int smallerGap = Math.min(positions[2]-positions[1], positions[1]-positions[0]);
        int largerGap = Math.max(positions[2]-positions[1], positions[1]-positions[0]);


        if (!(smallerGap == 1 && largerGap == 1)) {
            pw.println(getLeastMoves(smallerGap, largerGap));
            pw.println(getMostMoves(smallerGap, largerGap));
        } else {
            pw.println(0 + "\n" + 0);
        }


        pw.close();
        br.close();
    }

    private static int getLeastMoves(int smallerGap, int largerGap) {
        if (smallerGap == 2) {
            return 1;
        }
        return 2;
    }

    private static int getMostMoves(int smallerGap, int largerGap) {
        return largerGap - 1;
    }
}
