import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class Point {
    public int x;
    public int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null  || !(o instanceof Point)) {
            return false;
        }

        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }

    public String toString() {
        return x + " " + y;
    }
}

public class mowingthefield {
    private static HashMap<String, Integer> visited = new HashMap<>();
    private static Point currentPos = new Point(0, 0);
    private static int time = 0;
    private static ArrayList<Integer> possibleX = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String fileName = "mowing";
        BufferedReader br = new BufferedReader(new FileReader(fileName + ".in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".out")));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String direction = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            for (int j = 0; j < value; j++) {
                move(direction);
            }
        }
        int min = Integer.MAX_VALUE;
        if (possibleX.size() != 0) {
            for (int i = 0; i < possibleX.size(); i++) {
                int val = possibleX.get(i);
                if (val < min) {
                    min = val;
                }
            }
        } else {
            min = -1;
        }

        pw.println(min);
        pw.close();
        br.close();
    }

    private static void move(String direction) {
        time++;

        if (direction.equals("N")) {
            currentPos.y++;
        } else if (direction.equals("E")) {
            currentPos.x++;
        } else if (direction.equals("S")) {
            currentPos.y--;
        } else {
            currentPos.x--;
        }

        if (visited.containsKey(currentPos.toString())) {
            possibleX.add(time - visited.get(currentPos.toString()));
        }
        visited.put(currentPos.toString(), time);
    }
}
