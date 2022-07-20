public class exercise1 {
    public static void main(String[] args) {
        System.out.println(findIndex("c", new String[] {"a", "b", "c", "d"}));
        System.out.println(findIndex("f", new String[] {"a", "b", "c", "d"}));
    }

    private static int findIndex(String name, String[] names) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(name)) {
                return i;
            }
        }
        return -1;
    }
}