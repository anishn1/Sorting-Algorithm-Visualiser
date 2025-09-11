import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Visualiser {
//     private static final int SIZE = 10; // sizeof array

    public static void main(String[] args) throws InterruptedException {
//        int[] arr = {15,14,13,12,11,20,19,18,17,16,5,4,3,2,1,10,9,8,7,6};
        int[] arr = generateReverseArray(20);

        if (args.length == 0) {
            Sorter sorter = new MergeSort();
            sorter.sort(arr);
        }
        for (String i : args) {
            switch (i) {
                case "--help": {
                    help();
                    return;
                }
                default: {
                    Sorter sorter = new MergeSort();
                    sorter.sort(arr);
                }
            }
        }
    }

    private static void help() {
        System.out.println("Usage:    java Visualiser [options]");
        System.out.println("Options:");
        System.out.println("  --help                 Print this help message");
        System.out.println("  --sort <algorithm>     Choose algorithm: bubble (default), selection, insertion, merge");
        System.out.println("  --size <num>           Set array size (default 20)");
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
