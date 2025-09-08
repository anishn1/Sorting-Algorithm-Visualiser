public class Visualiser {
//     private static final int SIZE = 10; // sizeof array
     private static final int WIDTH = 150; // max num of # for bar

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {15,14,13,12,11,20,19,18,17,16,5,4,3,2,1,10,9,8,7,6};
//        bubbleSort(arr);
//        selectionSort(arr);
        insertionSort(arr);
    }

    private static void printArrayPos(int[] arr, int pos1, int pos2, int comp, int swap) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("-----------------------------");
        System.out.println("comp = " + comp);
        System.out.println("swap = " + swap);
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
                System.out.printf("\u001B[32m%02d: >> %s%n\u001B[0m", i, bar);
            } else {
                System.out.printf("%02d:    %s%n", arr[i], bar);
            }
        }
        System.out.println("-----------------------------");
    }

    private static void bubbleSort(int[] arr) throws InterruptedException {
        int comp = 0;
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                comp++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                    swapped = true;
                }
                printArrayPos(arr, j, j+1, comp, swap);
                Thread.sleep(100);
            }
            if (!swapped) {
                break;
            }
        }
    }

    private static void insertionSort(int[] arr) throws InterruptedException {
        int comp = 0;
        int swap = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            int temp = arr[i];
            int j = i - 1;
            printArrayPos(arr, i, -1, comp, swap);
            Thread.sleep(100);
            while (j >= 0 && arr[j]>temp) {
                printArrayPos(arr, j, j + 1, comp, swap);
                // noinspection BusyWait
                Thread.sleep(100);
                arr[j + 1] = arr[j];
                j--;
                comp++;
                swap++;
            }
            if (j >= 0) {
                comp++;
            }
            arr[j + 1] = temp;
            swap++;
            printArrayPos(arr, j + 1, -1, comp, swap);
            Thread.sleep(100);
        }
    }

    private static void selectionSort(int[] arr) throws InterruptedException {
        int comp = 0;
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int minId = i;
            for (int j = i + 1; j < arr.length; j++) {
                printArrayPos(arr, minId, j, comp, swap);
                Thread.sleep(100);
                comp++;
                if (arr[j] < arr[minId]) {
                    minId = j;
                    swap++;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minId];
            arr[minId] = temp;
        }
    }

}
