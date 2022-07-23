import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class Comparison {
    public int biggerCow;
    public int smallerCow;

    Comparison(int biggerCow, int smallerCow) {
        this.biggerCow = biggerCow;
        this.smallerCow = smallerCow;
    }

    public String toString() {
        return biggerCow + " " + smallerCow;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Comparison)) {
            return false;
        }
        Comparison other = (Comparison) o;
        return this.biggerCow == other.biggerCow && this.smallerCow == other.smallerCow;
    }

}

public class cowgymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> firstLine = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            firstLine.add(Integer.parseInt(st.nextToken()));
        }

        List<Map<Integer, Integer>> input = new ArrayList<>();
        for (int i = 0; i < k-1; i++) {
            st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> valueToIndex = new HashMap<>();
            for (int j = 0; j < n; j++) {
                valueToIndex.put(Integer.parseInt(st.nextToken()), j);
            }
            input.add(valueToIndex);
        }


        System.out.println(input);
        System.out.println(firstLine);
        List<Comparison> comps = firstLineToComparisons(firstLine);

        System.out.println();
        pw.println(getConsistentPairs(comps, input));
        pw.close();
        br.close();
    }

    private static int getConsistentPairs(List<Comparison> comps, List<Map<Integer, Integer>> input) {
        for (Map<Integer, Integer> m : input) {
            List<Comparison> removed = new ArrayList<>();
            for (Comparison c : comps) {
                int index1 = m.get(c.biggerCow);
                int index2 = m.get(c.smallerCow);
                if (index1 > index2) {
                    removed.add(c);
                }
            }
            comps.removeAll(removed);
        }
        return comps.size();
    }

    private static List<Comparison> firstLineToComparisons(List<Integer> l) {
        List<Comparison> returnList = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                returnList.add(new Comparison(l.get(i), l.get(j)));
            }
        }
        return returnList;
    }
}
