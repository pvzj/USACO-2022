import java.util.*;
public class abcs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] nums = new int[7];
        for (int i = 0; i < 7; i++) {
            nums[i] = s.nextInt();
        }

        Arrays.sort(nums);
        int a = nums[0];
        int abc = nums[6];
        int b = nums[1];
        int c = abc - a - b;

        System.out.println(a + " " + b + " " + c);


    }
}
