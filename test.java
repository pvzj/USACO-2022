import java.util.*;
public class test {
    public static void main(String[] args) {
        // List<List<Integer>> a = new ArrayList<>();
        // List<List<Integer>> b = new ArrayList<>();
        // b.add(new ArrayList<Integer>(Arrays.asList(1)));
        // b.add(new ArrayList<Integer>(Arrays.asList(2)));
        // b.add(new ArrayList<Integer>(Arrays.asList(3)));

        // System.out.println(a);
        // System.out.println(b);
        // // List<List<Integer>> temp = new ArrayList<>();
        // // temp.addAll(b);
        // // for (int i = 0; i < temp.size(); i++) {
        // //     temp.get(i).add(100);
        // // }
        // // a.addAll(b);
        // // a.addAll(temp);
        // // System.out.println(a);
        // // System.out.println(b);
        // a = copyAndAugment(b);
        // System.out.println(a);
        // System.out.println(b);
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }

        for (int i : l) {
            if (i == 4 || i == 5) {
                l.remove(i);
            }
        }
    }

    private static List<Integer> cloneAndAppend(List<Integer> l, int value) {
        List<Integer> newList = new ArrayList<>();
        newList.addAll(l);
        newList.add(value);
        return newList;
    }

    private static List<List<Integer>> copyAndAugment(List<List<Integer>> l) {
        List<List<Integer>> newList = new ArrayList<>();
        newList.addAll(l);
        for (List<Integer> element : l) {
            newList.add(cloneAndAppend(element, 3));
        }

        return newList;
    }
}
