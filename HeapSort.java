public class HeapSort extends Sorter {
    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {

    }

    @Override
    public void sort(int[] arr) throws InterruptedException {

    }

    private void heapify(int[] arr, int size, int index) {
        int largest = index;
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        comp++;
        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        comp++;
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            swap++;

            heapify(arr, size, largest);
        }
    }


}
