import java.util.*;
public class LetterCombinationsOfAPhoneNumber {
    public static String[] combinations = new String[10];
    public static List<String> l = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
    }
    public static List<String> letterCombinations(String digits) {
        initializeCombinations();
        backtrack(digits, "", 0);
        return l;
    }

    private static void initializeCombinations() {
        combinations[2] = "abc";
        combinations[3] = "def";
        combinations[4] = "ghi";
        combinations[5] = "jkl";
        combinations[6] = "mno";
        combinations[7] = "pqrs";
        combinations[8] = "tuv";
        combinations[9] = "wxyz";
    }

    private static void backtrack(String digits, String str, int index) {
        if (digits.length() == index) {
            return;
        }

        int digit = digits.charAt(index) - 48;
        String letters = combinations[digit];
        for (int i = 0; i < letters.length(); i++) {
            char c = letters.charAt(i);
            str += c;

            backtrack(digits, str, index + 1);
            if (digits.length() == str.length()) {
                l.add(str);
            }

            str = str.substring(0, str.length() - 1);

        }



    }
}
