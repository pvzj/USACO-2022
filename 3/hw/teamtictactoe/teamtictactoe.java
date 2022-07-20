import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;

public class teamtictactoe {
    private static HashSet<String> individualVictory = new HashSet<>();
    private static HashSet<String> groupVictory = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tttt.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));

        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            for (int j = 0; j < 3; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        String[] winningCombinations = findPossibleWinningCombinations(board);
        countVictories(winningCombinations);

        pw.println(individualVictory.size() + "\n" + groupVictory.size());
        pw.close();
        br.close();
    }

    private static void countVictories(String[] winningCombinations) {
        for (String s : winningCombinations) {
            String noDuplicateString = removeDuplicateLetters(s);
            if (noDuplicateString.length() == 1) {
                individualVictory.add(noDuplicateString);
            } else if (noDuplicateString.length() == 2) {
                groupVictory.add(noDuplicateString);
            }
        }
    }

    private static String removeDuplicateLetters(String s) {
        HashSet<Character> hs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            hs.add(s.charAt(i));
        }
        ArrayList<Character> arraylist = new ArrayList<>(hs);
        Collections.sort(arraylist);
        String finalString = "";
        for (char c : arraylist) {
            finalString += c;
        }
        return finalString;
    }

    private static String[] findPossibleWinningCombinations(char[][] board) {
        String[] finalList = new String[8];
        for (int i = 0; i < 3; i++) {
            finalList[i] = "" + board[i][0] + board[i][1] + board[i][2];
        }

        for (int i = 3; i < 6; i++) {
            finalList[i] = "" +  board[0][i-3] + board[1][i-3] + board[2][i-3];
        }

        finalList[6] = "" + board[0][0] + board[1][1] + board[2][2];
        finalList[7] = "" + board[0][2] + board[1][1] + board[2][0];
        return finalList;
    }


}
