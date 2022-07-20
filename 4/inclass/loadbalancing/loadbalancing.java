// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;
// import java.io.PrintWriter;
// import java.util.HashSet;
// import java.util.StringTokenizer;
// import java.util.Arrays;
// import java.util.Set;
// import java.util.ArrayList;

// class Point {
//     public int x;
//     public int y;

//     Point(int x, int y) {
//         this.x = x;
//         this.y = y;
//     }
// }
// public class loadbalancing {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new FileReader("loadbalancing.in"));
//         PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("loadbalancing.out")));
//         StringTokenizer st = null;

//         st = new StringTokenizer(br.readLine());
//         int n = Integer.parseInt(st.nextToken());
//         int b = Integer.parseInt(st.nextToken());

//         Point[] cows = new Point[n];
//         for (int i = 0; i < n; i++) {
//             st = new StringTokenizer(br.readLine());
//             cows[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//         }

//         int m = getSmallestM(cows);


//         pw.println();
//         pw.close();
//         br.close();
//     }

//     private static int getSmallestM(Point[] cows) {
//         HashSet<Integer> xValues = new HashSet<>();
//         HashSet<Integer> yValues = new HashSet<>();

//         for (int i : cows) {
//             xValues.add(cows.x);
//             yValues.add(cows.y);
//         }

//         int[] noDuplicateX = setToSortedArray(xValues);
//         int[] noDuplicateY = setToSortedArray(yValues);

//         ArraysList<Point> arraylist = new ArrayList<>();
//         if (noDuplicateX.length % 2 == 0 && noDuplicateY.length % 2 == 0) {
//             int middleX = mean(middleIndexOfEvenArray(noDuplicateX), middleIndexOfEvenArray(noDuplicateX) + 1);
//             int middleY = mean(middleIndexOfEvenArray(noDuplicateY), middleIndexOfEvenArray(noDuplicateY) + 1);
//             possibleIntersectionPoints.add(new Point(middleX, middleX));
//         } else if (noDuplicateX.length % 2 == 1 && noDuplicateY.length % 2 == 1) {

//         } else {

//         }
//     }

//     private static int mean(int a, int b) {
//         return (a + b) / 2;
//     }

//     private static int middleIndexOfEvenArray(int[] array) {
//         return (array.length - 1) / 2;
//     }

//     private static int[] setToSortedArray(HashSet<Integer> hs) {
//         int[] array = new int[hs.size()];
//         int i = 0;
//         for (int value : hs) {
//             array[i++] = value;
//         }
//         Arrays.sort(array);
//         return array;
//     }



//     private static int findMaxQuadrant(int middleX, int middleY, int[] xValues, int[] yValues) {
//         for (int i = 0; i < xValues.length; i++) {

//         }
//         return 0;
//     }
// }
