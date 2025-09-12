import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class Visualiser {

    public static void main(String[] args) throws InterruptedException {
        int size = 20;                  // default size
        String algorithm = "bubble";    // default sort

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--help": {
                    help();
                    return;
                }
                case "--size": {
                    if (i+1 < args.length) {
                        try {
                            size = Integer.parseInt(args[i + 1]);
                            i++;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid size: " + args[i + 1]);
                            return;
                        }
                        if (size <= 0) {
                            System.out.println("Size must be positive");
                            return;
                        }
                    } else {
                        System.out.println("No size specified");
                        return;
                    }
                    break;
                }
                case "--sort": {
                    if (i+1 < args.length) {
                        algorithm = args[i + 1].toLowerCase();
                        i++;
                    } else {
                        System.out.println("No sort algorithm specified");
                        return;
                    }
                    break;
                }
                default: {
                    System.out.println("Unexpected argument " + args[i]);
                    return;
                }
            }
        }

        int[] arr = generateReverse(size);
        Sorter sorter;
        switch (algorithm) {
            case "bubble": {
                sorter = new BubbleSort();
                break;
            }
            case "selection": {
                sorter = new SelectionSort();
                break;
            }
            case "insertion": {
                sorter = new InsertionSort();
                break;
            }
            case "merge": {
                sorter = new MergeSort();
                break;
            }
            default: {
                System.out.println("Unexpected algorithm " + algorithm);
                return;
            }
        }
        sorter.sort(arr);

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

    private static int[] generateReverse(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
    private static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
    private static int[] generateRandom(int size) {
        int[] arr = generateSorted(size);
        Random r = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }
}
