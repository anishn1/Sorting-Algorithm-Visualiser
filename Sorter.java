public abstract class Sorter {
    public abstract void stats();
    public abstract void sort(int[] arr) throws InterruptedException;
    protected static int width = 100; // max num of # for each bar
    protected static final int DELAY = 50;
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
        clearConsole();
        System.out.println("-----------------------------");
        stats();
        System.out.println("pos1 = " + pos1);
        System.out.println("pos2 = " + pos2);
        for (int i = 0; i < arr.length; i++) {
            int scaled = (arr[i] * width) / max;
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
    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
