public class ShakerSort extends Sorter {

    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Shaker Sort");
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Swaps:         " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        int max = maxArray(arr);
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;

        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i++) {
                comp++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap++;
                    swapped = true;
                }
                printArrayPos(arr, i, i + 1, max);
                Thread.sleep(DELAY);
            }
            if (!swapped) {break;}
            swapped = false;
            end--;
            for (int i = end - 1; i >= start; i--) {
                comp++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap++;
                    swapped = true;
                }
                printArrayPos(arr, i, i + 1, max);
                Thread.sleep(DELAY);
            }
            start++;
        }
    }
}
