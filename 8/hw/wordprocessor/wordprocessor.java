import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class wordprocessor {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("word.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = st.nextToken();
        }
        List<String> formattedEssay = getFormattedEssay(words, k);
        for (String s : formattedEssay) {
            pw.println(s);
        }

        pw.close();
        br.close();
    }

    private static List<String> getFormattedEssay(String[] words, int k) {
        List<String> formattedEssay = new ArrayList<>();
        String current = "";
        for (int i = 0; i < words.length; i++) {
            String word = "";
            if (current.length() == 0) {
                word = current += words[i];
            } else {
                word = current + " " + words[i];
            }

            if (getLengthWithoutSpaces(word) > k) {
                formattedEssay.add(current);
                current = words[i];
            } else {
                current = word;
            }
        }
        formattedEssay.add(current);
        return formattedEssay;
    }

    private static int getLengthWithoutSpaces(String s) {
        int charCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                charCount++;
            }
        }
        return charCount;
    }
}