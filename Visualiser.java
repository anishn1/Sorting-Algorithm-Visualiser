public class Visualiser {
//     private static final int SIZE = 10; // sizeof array

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {15,14,13,12,11,20,19,18,17,16,5,4,3,2,1,10,9,8,7,6};
        Sorter sorter = new MergeSort();
        sorter.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
