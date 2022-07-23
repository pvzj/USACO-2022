import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class backandforth {
    public static Set<Integer> sumSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
        ArrayList<Integer> barn1Buckets = bucketToList(br.readLine());
        ArrayList<Integer> barn2Buckets = bucketToList(br.readLine());

        getPossibleReadings(barn1Buckets, barn2Buckets, 0, 1000);
        System.out.println(sumSet);
        pw.println(sumSet.size());
        pw.close();
        br.close();
    }

    private static void getPossibleReadings(ArrayList<Integer> barnA, ArrayList<Integer> barnB, int iterationNumber, int sum) {
        // System.out.println(barnA + " " + barnB + " " + iterationNumber + " " + sum + " " + sumSet);
        if (iterationNumber == 4) {
            sumSet.add(sum);
            return;
        }
        // List<Integer> barnACopy = new ArrayList<>(barnA);
        // List<Integer> barnBcopy = new ArrayList<>(barnB);
        if (iterationNumber % 2 == 0) {
            for (int i = 0; i < barnA.size(); i++) {
                int bucket = barnA.remove(i);
                barnB.add(bucket);
                getPossibleReadings(barnA, barnB, iterationNumber+1, sum - bucket);
                // System.out.println(barnA + " " + barnB + " " + iterationNumber + " " + sum + " " + sumSet + "c");
                // System.out.println(bucket + "c");
                barnB.remove(Integer.valueOf(bucket));
                barnA.add(0, bucket);
                // System.out.println(barnA);
                // System.out.println(barnA + " " + barnB + " " + iterationNumber + " " + sum + " " + sumSet + "d");
            }
        } else {
            for (int i = 0; i < barnB.size(); i++) {
                int bucket = barnB.remove(i);
                barnA.add(bucket);
                getPossibleReadings(barnA, barnB, iterationNumber+1, sum + bucket);
                // System.out.println(barnA + " " + barnB + " " + iterationNumber + " " + sum + " " + sumSet + "d");
                // System.out.println(bucket + "d");
                barnA.remove(Integer.valueOf(bucket));
                barnB.add(0,bucket);
                // System.out.println(barnB);
                // System.out.println(barnA + " " + barnB + " " + iterationNumber + " " + sum + " " + sumSet + "d");
            }
        }

    }

    // private static void transferBucket(ArrayList<Integer> x, ArrayList<Integer> y, int index) {
    //     y.add(x.remove(index));
    // }

    private static ArrayList<Integer> bucketToList(String s) {
        ArrayList<Integer> l = new ArrayList<>();
        StringTokenizer st = null;
        st = new StringTokenizer(s);
        for (int i = 0; i < 10; i++) {
            l.add(Integer.parseInt(st.nextToken()));
        }
        return l;
    }
}
