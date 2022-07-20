import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.*;
import java.util.Arrays;

class Entry implements Comparable<Entry> {
    public String cowName;
    public int milkProduced;

    Entry(String cowName, int milkProduced) {
        this.cowName = cowName;
        this.milkProduced = milkProduced;
    }

    @Override
    public int compareTo(Entry o) {
        return this.milkProduced - o.milkProduced;
    }
}
public class dontbelast {

    public static Entry[] cows =  {
        new Entry("Bessie", 0),
        new Entry("Elsie", 0),
        new Entry("Daisy", 0),
        new Entry("Gertie", 0),
        new Entry("Annabelle", 0),
        new Entry("Maggie", 0),
        new Entry("Henrietta", 0)
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int milkProduced = Integer.parseInt(st.nextToken());
            addToTotalLog(name, milkProduced);
        }

        Arrays.sort(cows);

        Entry M = cows[0];
        boolean hasPrinted = false;
        for (int i = 1; i < cows.length; i++) {
            Entry current = cows[i];
            if (current.milkProduced > M.milkProduced) {
                if (i == cows.length - 1 || current.milkProduced < cows[i+1].milkProduced) {
                    pw.println(current.cowName);
                } else {
                    pw.println("Tie");
                }
                hasPrinted = true;
                break;
            }
        }

        if (!hasPrinted) { //all numbers the same case
            pw.println("Tie");
        }
        pw.close();
        br.close();
    }

    private static void addToTotalLog(String name, int milkProduced) {
        for (int i = 0; i < cows.length; i++) {
            if (name.equals(cows[i].cowName)) {
                cows[i].milkProduced += milkProduced;
                return;
            }
        }
    }
}
