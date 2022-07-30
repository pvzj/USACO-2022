import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

class Station {
    public HashSet<Integer> reachableStations;
    Station() {
        reachableStations = new HashSet<>();
    }
    public String toString() {
        return reachableStations.toString();
    }
}
public class milkfactory {
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        n = Integer.parseInt(br.readLine());
        Station[] stations = new Station[n+1];
        StringTokenizer st = null;

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (stations[to] == null) {
                stations[to] = new Station();
            }

            stations[to].reachableStations.add(from);
        }

        pw.println(getLeastUniversalStation(stations));


        pw.close();
        br.close();
    }

    private static int getLeastUniversalStation(Station[] stations) {
        for (int i = 1; i < stations.length; i++) {
            if (stations[i] != null) {
                HashSet<Integer> hs = getConnectableStations(new HashSet<>(), stations[i].reachableStations, stations);
                if (hs.size() == n - 1) {
                    return i;
                }
            }

        }
        return -1;
    }


    private static HashSet<Integer> getConnectableStations(HashSet<Integer> res, HashSet<Integer> current, Station[] stations) {
        if (current == null || res.containsAll(current)) {
            return new HashSet<>();
        }

        for (int i : current) {
            res.add(i);
            if (stations[i] != null) {
                res.addAll(getConnectableStations(res, stations[i].reachableStations, stations));
            }
        }

        return res;
    }
}
