import java.util.*;
public class permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1, 2, 3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> returnList = new ArrayList<>();

        if (nums.length == 1) {
            returnList.add(new ArrayList<Integer>(Arrays.asList(nums[0])));
            return returnList;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 1, nums.length)) + " a");
        List<List<Integer>> permutedList = permute(Arrays.copyOfRange(nums, 1, nums.length));

        int addOnNum = nums[0];
        System.out.println(permutedList + " d");
        for (int i = 0; i < permutedList.size(); i++) {
            for (int j = 0; j <= permutedList.get(i).size(); j++) {

                List<Integer> l = new ArrayList<>(permutedList.get(i));
                System.out.println(l + " dfadfs");
                l.add(j, addOnNum);
                System.out.println(l + " dfadf");
                returnList.add(l);
                System.out.println(returnList);
            }
        }

        return returnList;
    }
}
