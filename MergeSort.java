public class MergeSort extends Sorter {
    int comp = 0;
    int copy = 0;

    @Override
    public void stats() {
        System.out.println("Merge Sort");
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Copies:        " + copy);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        int max = maxArray(arr);
        mergeSort(arr, 0, arr.length - 1, max);
    }

    private void mergeSort(int[] arr, int left, int right, int max) throws InterruptedException {
        if (left == right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid, max);
        printArrayPos(arr, left, mid, max);
        Thread.sleep(DELAY);
        mergeSort(arr, mid + 1, right, max);
        printArrayPos(arr, mid + 1, right, max);
        Thread.sleep(DELAY);
        merge(arr, left, mid, right, max);
        printArrayPos(arr, left, right,max);
        Thread.sleep(DELAY);
    }

    private void merge(int[] arr, int left, int mid, int right, int max) throws InterruptedException {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArr = new int[len1];
        for (int i = 0; i < len1; i++) {
            leftArr[i] = arr[left + i];
        }
        int[] rightArr = new int[len2];
        for (int j = 0; j < len2; j++) {
            rightArr[j] = arr[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int pos = left;
        while (i < len1 && j < len2) {
            comp++;
            if (leftArr[i] < rightArr[j]) {
                arr[pos] = leftArr[i]; i++;
            } else {
                arr[pos] = rightArr[j];
                j++;
            }
            copy++;
            pos++;
            printArrayPos(arr, left, right, max);
            Thread.sleep(DELAY);
        }
        while (i < len1) {
            arr[pos] = leftArr[i];
            pos++;
            i++;
            copy++;
            printArrayPos(arr, left, right, max);
            Thread.sleep(DELAY);
        }
        while (j < len2) {
            arr[pos] = rightArr[j];
            pos++;
            j++;
            copy++;
            printArrayPos(arr, left, right, max);
            Thread.sleep(DELAY);
        }
    }
}
