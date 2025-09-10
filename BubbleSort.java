public class BubbleSort extends Sorter {

    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Number Comparisons: " + comp);
        System.out.println("Number Swaps:       " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
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
                printArrayPos(arr, j, j+1);
                Thread.sleep(50);
            }
            if (!swapped) {
                break;
            }
        }
    }
}
