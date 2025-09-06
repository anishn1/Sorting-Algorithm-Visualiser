public class Visualiser {
    // private static final int SIZE = 10; // sizeof array
    // private static final int WIDTH = 50; // max num of # for bar

    private static void printArray(int[] arr, int elem1, int elem2) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        for (int i : arr) {
            String bar = "#".repeat(i);
            if (i==elem1 || i==elem2) {
                System.out.printf("%d: [%s]%n", i, bar);
            } else {
                System.out.printf("%d:  %s%n", i, bar);
            }
        }
    }

}
