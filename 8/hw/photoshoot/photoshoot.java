import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class photoshoot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("photo.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] order = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }




        List<Integer> correctOrder = getOrder(order);
        boolean isFirst = true;
        for (int i : correctOrder) {
            if (isFirst) {
                pw.print(i);
                isFirst = false;
            } else {
                pw.print(" " + i);
            }

        }
        pw.close();
        br.close();
    }

    private static List<Integer> getOrder(int[] order) {
        for (int i = 1; i < order[0]; i++) {
            TreeSet<Integer> sequence = new TreeSet<>();
            List<Integer> sequenceList = new ArrayList<>();
            int current = i;
            for (int j = 0; j < order.length; j++) {
                int prevLength = sequence.size();
                sequence.add(current);
                sequenceList.add(current);
                current = order[j] - current;


                if (prevLength == sequence.size()) {
                    break;
                }
            }

            sequence.add(current);
            sequenceList.add(current);


            if (isSequential(sequence)) {
                return sequenceList;
            }


        }
        return null;
    }

    private static boolean isSequential(TreeSet<Integer> sequence) {
        int index = 1;
        for (int element : sequence) {
            if (element != index) {
                return false;
            }
            index++;
        }
        return true;
    }
}
