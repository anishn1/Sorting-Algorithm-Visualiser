public class QuickSort extends Sorter {

    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Quick Sort");
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Swaps:         " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        quickSort(arr, 0, arr.length - 1, maxArray(arr));
    }

    public void quickSort(int[] arr, int low, int high, int max) throws InterruptedException {
        if (low < high) {
            int pivot = partition(arr, low, high, max);
            quickSort(arr, low, pivot - 1, max);
            quickSort(arr, pivot + 1, high, max);
        }
    }

    public int partition(int[] arr, int low, int high, int max) throws InterruptedException {
        int i = low - 1;
        int pivot = arr[high];
        for (int j = low; j<high; j++) {
            comp++;
            if (arr[j] <= pivot) {
                i++;
                swap++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            printArrayPos(arr, i, j, max);
            Thread.sleep(DELAY);
        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        swap++;
        printArrayPos(arr, i+1, high, max);
        Thread.sleep(DELAY);
        return i+1;
    }
}
