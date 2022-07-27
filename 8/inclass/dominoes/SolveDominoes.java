import java.io.PipedOutputStream;
import java.util.*;

class Domino {
    private int first;
    private int second;

    Domino(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int first() {
        return first;
    }

    public int second() {
        return second;
    }

    public String toString() {
        return "(" + first + "|" + second + ")";
    }

    public boolean contains(int num) {
        return first == num || second == num;
    }
}

public class SolveDominoes {
    public static void main(String[] args) {
        // [(1|4), (2|6), (4|5), (1|5), (3|5)]
        List<Domino> dominoes = new ArrayList<Domino>();
        dominoes.add(new Domino(1, 4));
        dominoes.add(new Domino(2, 6));
        dominoes.add(new Domino(4, 5));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(3, 5));
        System.out.println(hasChain(dominoes, 5, 5));   // true
        System.out.println(hasChain(dominoes, 1, 5));   // true
        System.out.println(hasChain(dominoes, 1, 3));   // true
        System.out.println(hasChain(dominoes, 1, 6));   // false
        System.out.println(hasChain(dominoes, 1, 2));   // false
    }

    public static boolean hasChain(List<Domino> dominoes, int start, int end) {
        System.out.println(dominoes + " " + start + " " + end);
        List<Domino> potentialDominoes = new ArrayList<>();
        for (Domino d : dominoes) {
            if (d.contains(start)) {
                if (d.contains(end) && start != end) {
                    return true;
                }
                potentialDominoes.add(d);
            }
        }

        // System.out.println(potentialDominoes);

        if (potentialDominoes.size() == 0) {
            return false;
        }
        // int index = 0;
        for (int i = 0; i < potentialDominoes.size(); i++) {
            Domino d = potentialDominoes.remove(i);
            dominoes.remove(d);
            int other;
            if (d.first() == start) {
                other = d.second();
            } else {
                other = d.first();
            }

            if (hasChain(dominoes, other, end)) {
                return true;
            }
            potentialDominoes.add(i, d);
            dominoes.add(d);
        }


        return false;
    }
}


