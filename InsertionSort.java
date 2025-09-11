public class InsertionSort extends Sorter {

    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Swaps:         " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        int max = maxArray(arr);
        for (int i = 1; i < arr.length - 1; i++) {
            int temp = arr[i];
            int j = i - 1;
            printArrayPos(arr, i, -1, max);
            Thread.sleep(DELAY);
            while (j >= 0 && arr[j]>temp) {
                printArrayPos(arr, j, j + 1, max);
                // noinspection BusyWait
                Thread.sleep(DELAY);
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
            printArrayPos(arr, j + 1, -1, max);
            Thread.sleep(DELAY);
        }
    }
}
