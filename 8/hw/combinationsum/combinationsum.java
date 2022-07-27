import java.util.*;
public class combinationsum {
    public static void main(String[] args) {
        int[] array = {2,3,5};
        System.out.println(combinationSum(array, 8));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> l = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new ArrayList<>(), l, 0);
        return l;
    }

    private static void backtrack(int[] candidates, int target, int currentSum, List<Integer> currentNumbers, List<List<Integer>> l, int index) {
        if (currentSum > target) {
            return;
        } else if (currentSum == target) {
            ArrayList<Integer> a = new ArrayList<>(currentNumbers);
            l.add(a);
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            currentNumbers.add(candidates[i]);
            backtrack(candidates, target, currentSum + candidates[i], currentNumbers, l, i);
            currentNumbers.remove(currentNumbers.size() - 1);
        }
    }
}
