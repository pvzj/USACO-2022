import java.util.*;
public class subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> returnList = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            returnList.add(l);
            returnList.add(new ArrayList<>());
            return returnList;
        }
        int current = nums[nums.length - 1];
        List<List<Integer>> lowerList = subsets(Arrays.copyOfRange(nums, 0, nums.length - 1));
        returnList = copyAndAugment(lowerList, current);
        return returnList;
    }

    private static List<Integer> cloneAndAppend(List<Integer> l, int value) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(l);
        newList.add(value);
        return newList;
    }

    private static List<List<Integer>> copyAndAugment(List<List<Integer>> l, int value) {
        List<List<Integer>> newList = new ArrayList<>();
        newList.addAll(l);
        for (List<Integer> element : l) {
            newList.add(cloneAndAppend(element, value));
        }

        return newList;
    }
}
