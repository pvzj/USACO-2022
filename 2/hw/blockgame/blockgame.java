import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class blockgame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));

        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] finalArray = new int[26];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] lineArray = convertLineToArray(st.nextToken(), st.nextToken());
            for (int j = 0; j < 26; j++) {
                finalArray[j] += lineArray[j];
            }
        }

        for (int i : finalArray) {
            pw.println(i);
        }


        pw.close();
        br.close();
    }

    private static int[] convertLineToArray(String a, String b) {
        int[] finalArray = new int[26];
        int[] aLetters = convertStringToLetterArray(a);
        int[] bLetters = convertStringToLetterArray(b);
        for (int i = 0; i < 26; i++) {
            finalArray[i] = Math.max(aLetters[i], bLetters[i]);
        }
        return finalArray;
    }

    private static int[] convertStringToLetterArray(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letters[c - 97]++;
        }
        return letters;
    }
}
