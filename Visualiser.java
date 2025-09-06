public class Visualiser {
//     private static final int SIZE = 10; // sizeof array
     private static final int WIDTH = 100; // max num of # for bar

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {3,9,4,1,7,8,2,5,6};
        bubbleSort(arr);
        System.out.printf("%n%n%n num of comparisons = %d%n", num);
    }

    public static int num = 0;

    private static void printArray(int[] arr, int elem1, int elem2) {
        num++;
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
                System.out.printf("%d: [%s]%n", i, bar);
            } else {
                System.out.printf("%d:  %s%n", i, bar);
            }
        }
        System.out.println("-----------------------------");
    }

    private static void bubbleSort(int[] arr) throws InterruptedException {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
                printArray(arr, j, j+1);
                Thread.sleep(300);
            }
            if (!swapped) {
                break;
            }
        }
    }
}
