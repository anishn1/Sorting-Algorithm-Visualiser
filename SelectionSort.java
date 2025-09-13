public class SelectionSort extends Sorter {

    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Selection Sort");
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Swaps:         " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        int max = maxArray(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            int minId = i;
            for (int j = i + 1; j < arr.length; j++) {
                printArrayPos(arr, minId, j, max);
                Thread.sleep(DELAY);
                comp++;
                if (arr[j] < arr[minId]) {
                    minId = j;
                }
            }
            int temp = arr[i];
            swap++;
            arr[i] = arr[minId];
            arr[minId] = temp;
        }
    }
}
