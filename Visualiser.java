public class Visualiser {
//     private static final int SIZE = 10; // sizeof array
     private static final int WIDTH = 100; // max num of # for bar

    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {3,9,4,1,7,8,2,5,6};
        int[] arr = {9,8,7,6,5,4,3,2,1};
//        bubbleSort(arr);
//        System.out.printf("%n%n%n num of comparisons = %d%n", num);
        insertionSort(arr);
        System.out.printf("%n%n%n num of comparisons = %d%n", num);
    }

    public static int num = 0;

    private static void printArrayValue(int[] arr, int elem1, int elem2) {
//        num++;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----------------------------");
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        for (int i : arr) {
            int scaled = (i * WIDTH) / max;
            if (scaled < 1) {
                scaled = 1;
            }
            String bar = "#".repeat(scaled);
            if (i==elem1 || i==elem2) {
//                System.out.printf("%d: >> %s%n", i, bar);
                System.out.printf("\u001B[32m%d:    %s%n\u001B[0m", i, bar);
            } else {
                System.out.printf("%d:    %s%n", i, bar);
            }
        }
        System.out.println("-----------------------------");
    }

    private static void printArrayPos(int[] arr, int pos1, int pos2) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----------------------------");
        System.out.println("pos1 = " + pos1);
        System.out.println("pos2 = " + pos2);
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int scaled = (arr[i] * WIDTH) / max;
            if (scaled < 1) {
                scaled = 1;
            }
            String bar = "#".repeat(scaled);
            if (i==pos1 || i==pos2) {
//                System.out.printf("%d: >> %s%n", i, bar);
                System.out.printf("\u001B[32m%d:    %s%n\u001B[0m", arr[i], bar);
            } else {
                System.out.printf("%d:    %s%n", arr[i], bar);
            }
        }
        System.out.println("-----------------------------");
    }

    private static void bubbleSort(int[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                num++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                printArrayPos(arr, j, j+1);
                Thread.sleep(300);
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void insertionSort(int[] arr) throws InterruptedException {
        for (int i = 1; i < arr.length - 1; i++) {
            int temp = arr[i];
            int j = i - 1;
            printArrayPos(arr, i, -1);
            Thread.sleep(300);
            while (j >= 0 && arr[j]>temp) {
                printArrayPos(arr, j, j + 1);
                Thread.sleep(300);
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
            printArrayPos(arr, j + 1, -1);
            Thread.sleep(300);
        }
    }



}
