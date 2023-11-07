package DAA_Practical;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Generate a random list of numbers
        int[] arr = new int[1000];
//    	int[]arr= {10,20,40,34,12};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(10000) + 1;
        }

        // Perform deterministic quick sort and measure the execution time
        long deterministicStartTime = System.currentTimeMillis();
        int[] deterministicSortedArr = deterministicQuickSort(arr.clone());
        long deterministicEndTime = System.currentTimeMillis();
        double deterministicTime = (deterministicEndTime - deterministicStartTime) / 1000.0;

        // Perform randomized quick sort and measure the execution time
        long randomizedStartTime = System.currentTimeMillis();
        int[] randomizedSortedArr = randomizedQuickSort(arr.clone());
        long randomizedEndTime = System.currentTimeMillis();
        double randomizedTime = (randomizedEndTime - randomizedStartTime) / 1000.0;

        System.out.printf("Deterministic Quick Sort Execution Time: %.6f seconds%n", deterministicTime);
        System.out.printf("Randomized Quick Sort Execution Time: %.6f seconds%n", randomizedTime);

        // Verify that the sorting is correct
        if (Arrays.equals(deterministicSortedArr, randomizedSortedArr)) {
            System.out.println("Correct");
        } else {
            System.out.println("Wrong");
        }
    }

    // Deterministic Quick Sort
    public static int[] deterministicQuickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int pivot = arr[0];
        int[] left = new int[0];
        int[] right = new int[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivot) {
                left = append(left, arr[i]);
            } else {
                right = append(right, arr[i]);
            }
        }

        int[] sortedLeft = deterministicQuickSort(left);
        int[] sortedRight = deterministicQuickSort(right);

        int[] result = new int[sortedLeft.length + 1 + sortedRight.length];
        System.arraycopy(sortedLeft, 0, result, 0, sortedLeft.length);
        result[sortedLeft.length] = pivot;
        System.arraycopy(sortedRight, 0, result, sortedLeft.length + 1, sortedRight.length);

        return result;
    }

    // Randomized Quick Sort
    public static int[] randomizedQuickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int pivotIndex = new Random().nextInt(arr.length);
        int pivot = arr[pivotIndex];

        int[] left = new int[0];
        int[] right = new int[0];
        int[] equal = new int[0];

        for (int element : arr) {
            if (element < pivot) {
                left = append(left, element);
            } else if (element > pivot) {
                right = append(right, element);
            } else {
                equal = append(equal, element);
            }
        }

        int[] sortedLeft = randomizedQuickSort(left);
        int[] sortedRight = randomizedQuickSort(right);

        int[] result = new int[sortedLeft.length + equal.length + sortedRight.length];
        System.arraycopy(sortedLeft, 0, result, 0, sortedLeft.length);
        System.arraycopy(equal, 0, result, sortedLeft.length, equal.length);
        System.arraycopy(sortedRight, 0, result, sortedLeft.length + equal.length, sortedRight.length);

        return result;
    }

    // Helper method to append an element to an array
    public static int[] append(int[] arr, int element) {
        int[] newArray = Arrays.copyOf(arr, arr.length + 1);
        newArray[arr.length] = element;
        return newArray;
    }
}
