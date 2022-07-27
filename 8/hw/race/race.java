import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class race {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("race.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(br.readLine());
        }

        for (int i : x) {
            System.out.println(getMinTime(k, i));
        }

        pw.close();
        br.close();
    }

    private static int getMinTime(int k, int x) {
        return backTrack(k, 1, 0, 0, x);
    }

    private static int backTrack(int totalDistance, int currentSpeed, int currentPos, int iterationNumber, int targetSpeed) {
        System.out.println(currentSpeed + " " + currentPos + " " + iterationNumber);
        if (currentPos >= totalDistance) {
            if (currentSpeed == targetSpeed) {
                return iterationNumber;
            } else {
                return -1;
            }
        }

        if (currentSpeed <= 0) {
            return -1;
        }

        currentPos += currentSpeed;
        iterationNumber++;
        int lowerSpeed = backTrack(totalDistance, currentSpeed - 1, currentPos, iterationNumber, targetSpeed);
        int unchangedSpeed = backTrack(totalDistance, currentSpeed, currentPos, iterationNumber, targetSpeed);
        int raiseSpeed = backTrack(totalDistance, currentSpeed + 1, currentPos, iterationNumber, targetSpeed);

        return Math.max(lowerSpeed, Math.max(unchangedSpeed, raiseSpeed));
    }
}
