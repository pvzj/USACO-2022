import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class promotioncounting {
    public static void main(String[] args) throws IOException {
        String fileName = "promote";
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        StringTokenizer st = null;
        int[] start = new int[4];
        int[] end = new int[4];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }
        int[] newUsers = new int[3];
        for (int i = 1; i < 4; i++) {
            newUsers[i-1] = end[i]-start[i];
        }

        newUsers[1] += newUsers[2];
        newUsers[0] += newUsers[1];
        for (int i = 0; i < 3; i++) {
            pw.println(newUsers[i]);
        }
        pw.close();
        br.close();
    }
}
