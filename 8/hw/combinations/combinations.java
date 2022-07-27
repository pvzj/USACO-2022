import java.util.*;
public class combinations {
    public static void main(String[] args) {
        System.out.println(combine(20,16));
    }

    public static List<List<Integer>> combine(int n, int k) {
        int[] nums = getArrayFrom1ToN(n);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, k);
        return res;
    }

    private static int[] getArrayFrom1ToN(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> curr, int[] nums, int k) {
        // System.out.println(curr + " " + Arrays.toString(nums));
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            curr.add(num);
            backtrack(res, curr, Arrays.copyOfRange(nums, i + 1, nums.length), k);
            curr.remove(curr.size() - 1);
        }
    }
}
