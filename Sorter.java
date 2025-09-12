public abstract class Sorter {
    public abstract void stats();
    public abstract void sort(int[] arr) throws InterruptedException;
    private static final int WIDTH = 100; // max num of # for each bar
    protected static final int DELAY = 25;
    protected int maxArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    protected void printArrayPos(int[] arr, int pos1, int pos2, int max) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----------------------------");
        stats();
        System.out.println("pos1 = " + pos1);
        System.out.println("pos2 = " + pos2);
//        int max = 0;
//        for (int i : arr) {
//            if (i > max) {
//                max = i;
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            int scaled = (arr[i] * WIDTH) / max;
            if (scaled < 1) {
                scaled = 1;
            }
            String bar = "#".repeat(scaled);
            if (i==pos1 || i==pos2) {
                System.out.printf("\u001B[32m%02d: >> %s%n\u001B[0m", arr[i], bar);
            } else {
                System.out.printf("%02d:    %s%n", arr[i], bar);
            }
        }
        System.out.println("-----------------------------");
    }
}
