import java.util.Arrays;
public class exercise2 {
    public static void main(String[] args) {
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(sumFirstLast(array));
        swapTopBottom(array);
        System.out.println(Arrays.deepToString(array));
        reverseColumns(array);
        System.out.println(Arrays.deepToString(array));
    }

    private static int sumFirstLast(int[][] a) {
        return sumOfArray(a[0]) + sumOfArray(a[a.length-1]);
    }

    private static int sumOfArray(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    private static void swapTopBottom(int[][] a) {
        int[] temp = a[0];
        a[0] = a[a.length-1];
        a[a.length-1] = temp;
    }

    private static void reverseColumns(int[][] a) {
        for (int[] i : a) {
            reverseArray(i);
        }
    }

    private static void reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = a[0];
            a[0] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }
    }
}


