import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class neighboringCows {
    public boolean hasbeenVisited;
    public List<String> neighbors;

    neighboringCows() {
        neighbors = new ArrayList<String>();
    }
}

class ListComparator<String extends Comparable<String>> implements Comparator<List<String>> {

    @Override
    public int compare(List<String> o1, List<String> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }

}

public class livestocklineup {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        HashMap<String, neighboringCows> hm = new HashMap<>();

        hm.put("Beatrice", new neighboringCows());
        hm.put("Belinda", new neighboringCows());
        hm.put("Bella", new neighboringCows());
        hm.put("Bessie", new neighboringCows());
        hm.put("Betsy", new neighboringCows());
        hm.put("Blue", new neighboringCows());
        hm.put("Buttercup", new neighboringCows());
        hm.put("Sue", new neighboringCows());


        // neighboringCows[] nc = {
        //     new neighboringCows("Beatrice"),
        //     new neighboringCows("Belinda"),
        //     new neighboringCows("Bella"),
        //     new neighboringCows("Bessie"),
        //     new neighboringCows("Betsy"),
        //     new neighboringCows("Blue"),
        //     new neighboringCows("Buttercup"),
        //     new neighboringCows("Sue")
        // };

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cow1 = st.nextToken();
            for (int j = 0; j < 4; j++) {
                st.nextToken();
            }
            String cow2 = st.nextToken();
            hm.get(cow1).neighbors.add(cow2);
            hm.get(cow2).neighbors.add(cow1);
        }

        List<List<String>> groups = getGroups(hm);
        System.out.println(groups);

        System.out.println(getReverseList(new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e"))));

        for (int i = 0; i < groups.size(); i++) {
            groups.set(i, getOptimalOrder(groups.get(i)));
        }

        Collections.sort(groups, new ListComparator<>());

        for (List<String> l : groups) {
            for (String s : l) {
                pw.println(s);
            }
        }


        pw.close();
        br.close();
    }

    private static List<String> getOptimalOrder(List<String> l) {
        List<String> reversedList = getReverseList(l);
        int index = 0;
        while (index < l.size()) {
            String s1 = l.get(index);
            String s2 = reversedList.get(index);
            if (s1.compareTo(s2) < 0) {
                return l;
            } else if (s1.compareTo(s2) > 0) {
                return reversedList;
            }
            index++;
        }
        return l;
    }

    private static List<String> getReverseList(List<String> l) {
        List<String> newList = new ArrayList<>(l);
        for (int i = 0; i < newList.size() / 2; i++) {
            String temp = newList.get(i);
            newList.set(i, newList.get(l.size() - i - 1));
            newList.set(newList.size() - i - 1, temp);
        }
        return newList;
    }

    private static List<List<String>> getGroups(HashMap<String, neighboringCows> hm) {
        List<List<String>> l = new ArrayList<>();
        for (String s : hm.keySet()) {
            l.add(getChain(s, hm));
        }

        return l;
    }

    private static List<String> getChain(String cow, HashMap<String, neighboringCows> hm) {
        neighboringCows nc = hm.get(cow);
        List<String> cowsInChain = new ArrayList<>();
        if (nc.hasbeenVisited) {
            return cowsInChain;
        }

        nc.hasbeenVisited = true;
        cowsInChain.add(cow);
        for (String s : nc.neighbors) {
            cowsInChain.addAll(getChain(s, hm));
        }

        return cowsInChain;
    }

    // private static List<Constraint> getConstraintOrder(String[] sortedCowOrder, Constraint[] constraints) {
    //     List<ConstraintSegment> existingSegments = new ArrayList<>();

    //     for (String s : sortedCowOrder) {
    //         int index = getIndexOfCowInList(s, existingSegments);
    //         if (index == -1) {
    //             existingSegments.add(new ConstraintSegment(new ArrayList<>(Arrays.asList(s))));
    //         } else {

    //         }
    //     }
    //     return null;
    // }

    // private static int getIndexOfCowInList(String s, List<ConstraintSegment> l) {
    //     for (int i = 0; i < l.size(); i++) {
    //         if (l.get(i).cows.contains(s)) {
    //             return i;
    //         }
    //     }
    //     return -1;
    // }
}
