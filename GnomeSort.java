public class GnomeSort extends Sorter {

    int comp = 0;
    int swap = 0;

    @Override
    public void stats() {
        System.out.println("Gnome Sort");
        System.out.println("Number Comparisons:   " + comp);
        System.out.println("Number Swaps:         " + swap);
    }

    @Override
    public void sort(int[] arr) throws InterruptedException {
        int max = maxArray(arr);
        int i = 0;
        int n = arr.length;
        while (i < n) {
            if (i == 0) {
                i++;
            } else if (arr[i] > arr[i-1]) {
                i++;
                comp++;
            } else {
                comp++;
                int temp = arr[i];
                arr[i] = arr[i-1];
                arr[i-1] = temp;
                swap++;
                i--;
            }
            printArrayPos(arr, i-1, i, max);
            Thread.sleep(DELAY);
        }

    }
}
