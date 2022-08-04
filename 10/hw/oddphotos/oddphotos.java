import java.util.*;

public class oddphotos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            int num = s.nextInt();
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println(getMaxGroups(evenCount, oddCount));

    }

    private static int getMaxGroups(int evens, int odds) {
        int matchingPairs = 2 * Math.min(evens, odds);
        if (evens > odds) {
            return matchingPairs+1;
        } else if (evens < odds) {
            odds -= evens;

            if (odds % 3 == 0) {
                return matchingPairs + (odds / 3) * 2;
            } else if (odds % 3 == 1) {
                return matchingPairs + (odds - 2) / 3 * 2 + 1;
            } else {
                return matchingPairs + (odds / 3) * 2 + 1;
            }
        } else {
            return matchingPairs;
        }
    }
}
