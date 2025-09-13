
import java.util.Random;


public class Visualiser {

    static int size = 20;                  // default size
    static String algorithm = "bubble";    // default sort
    static String arrType = "random";      // default array type
    static int nearlyPortion = 10;         // default nearly sorted portion
    public static void main(String[] args) throws InterruptedException {


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
                case "--array": {
                    if (i+1 < args.length) {
                        arrType = args[i+1].toLowerCase();
                        i++;
                        break;
                    } else {
                        System.out.println("No array type specified");
                        return;
                    }
                }
                case "--nearly": {
                    arrType = "nearly";
                    if (i+1 < args.length) {
                        nearlyPortion = Integer.parseInt(args[i+1]);
                        i++;
                    } else {
                        System.out.println("No nearly portion specified");
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

        int[] arr;
        switch (arrType) {
            case "random": {
                arr = generateRandom(size);
                break;
            }
            case "nearly": {
                arr = generateNearlySorted(size);
                break;
            }
            case "sorted": {
                arr = generateSorted(size);
                break;
            }
            case "reversed": {
                arr = generateReverse(size);
                break;
            }
            default: {
                System.out.println("Unexpected argument " + arrType);
                return;
            }
        }
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
            case "shaker": {
                sorter = new ShakerSort();
                break;
            }
            case "gnome": {
                sorter = new GnomeSort();
                break;
            }
            case "quick": {
                sorter = new QuickSort();
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
        System.out.println("  --array <type>         Choose array type: random (default), nearly, sorted, reversed");
        System.out.println("  --nearly <n%>          Set array type nearly sorted, with swap portion n% (default 10%)");
    }

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
    private static int[] generateNearlySorted(int size) {
        int[] arr = generateSorted(size);
        Random r = new Random();
        int swaps = Math.max(1, (size * nearlyPortion) /100); // 10% swapped
        for (int i = 0; i < swaps; i++) {
            int pos1 = r.nextInt(size);
            int pos2 = r.nextInt(size);
            int temp = arr[pos1];
            arr[pos1] = arr[pos2];
            arr[pos2] = temp;
        }
        return arr;
    }
}
