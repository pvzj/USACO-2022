import java.util.Scanner;
public class scannerTemplate {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = s.next();
        }

        s.close();
    }
}
