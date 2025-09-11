import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Visualiser {
//     private static final int SIZE = 10; // sizeof array

    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {15,14,13,12,11,20,19,18,17,16,5,4,3,2,1,10,9,8,7,6};
        int[] arr = generateReverseArray(20);
        Sorter sorter = new MergeSort();
        sorter.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

//    private static int[] generateRandomArray(int size) {
//        List<Integer> list = new ArrayList<>(size);
//        for (int i = 0; i < size; i++) {
//            list.set(i, i + 1);
//        }
//        Collections.shuffle(list);
//        int[] arr = list.toArray(new Integer[0]);
//        return arr;
//    }

    private static int[] generateReverseArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}
