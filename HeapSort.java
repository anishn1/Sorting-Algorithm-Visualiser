public class HeapSort extends Sorter {
    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Heap Sort");
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Swaps:         " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        int size = arr.length;
        int max = maxArray(arr);
        for (int i = size/2 - 1; i >= 0; i--) {
            heapify(arr, size, i);
            printArrayPos(arr, i, -1, max);
            Thread.sleep(DELAY);
        }
        for (int i = size-1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            swap++;
            printArrayPos(arr, 0, i, max);
            Thread.sleep(DELAY);


            heapify(arr, i, 0);
            printArrayPos(arr, 0, i, max);
            Thread.sleep(DELAY);
        }
    }

    private void heapify(int[] arr, int size, int index) throws InterruptedException {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if (left < size) {
            comp++;
            if (arr[left] > arr[largest]) {
                largest = left;
            }
        }
        if (right < size) {
            comp++;
            if (arr[right] > arr[largest]) {
                largest = right;
            }
        }
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            swap++;

            printArrayPos(arr, index, largest, maxArray(arr));
            Thread.sleep(DELAY);

            heapify(arr, size, largest);
        }
    }
}
