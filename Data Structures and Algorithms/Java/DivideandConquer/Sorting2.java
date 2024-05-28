import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of various divide & conquer sorting algorithms.
 */

public class Sorting2 {

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(n log n)
     * And a best case running time of: O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: You may need to create a helper method that merges two arrays
     * back into the original T[] array. If two data are equal when merging,
     * think about which subarray you should pull from first.
     *
     * You may assume that the passed in array and comparator are both valid
     * and will not be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array to be sorted.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Base case
        if (arr.length <= 1) {
            return;
        }

        // Find where to split array
        int arrLen = arr.length;
        int midPoint = arr.length / 2;

        // Create 2 sub-arrays for L and R halves
        T[] LArr = (T[]) new Object[midPoint - 0];
        T[] RArr = (T[]) new Object[arrLen - midPoint];

        for (int i = 0; i < midPoint; i++) {
            LArr[i] = arr[i];
        }
        for (int i = midPoint, j = 0; i < arr.length; i++, j++) {
            RArr[j] = arr[i];
        }

        // Recursive call on LArr, RArr
        mergeSort(LArr, comparator);
        mergeSort(RArr, comparator);

        // Call helper function to merge back to original array
        mergeSortHelper(arr, comparator, LArr, RArr);
        return;
    }

    // Helper mergeSort
    private static <T> void mergeSortHelper(T[] arr, Comparator<T> comparator, T[] LArr, T[] RArr) {
        // Comparison Loops
        int LArrIdx = 0;
        int RArrIdx = 0;
        int mainCurrIdx = 0;

        while (LArrIdx < LArr.length && RArrIdx < RArr.length) {
            // If left <= right, add left value
            if (comparator.compare(LArr[LArrIdx], RArr[RArrIdx]) <= 0) {
                arr[mainCurrIdx] = LArr[LArrIdx];
                LArrIdx += 1;
                mainCurrIdx += 1;
            }
            // if right > left, add right value
            else {
                arr[mainCurrIdx] = RArr[RArrIdx];
                RArrIdx += 1;
                mainCurrIdx += 1;
            }
        }

        // empty out leftovers from LArr, RArr
        while (LArrIdx < LArr.length) {
            arr[mainCurrIdx] = LArr[LArrIdx];
            LArrIdx += 1;
            mainCurrIdx += 1;
        }
        while (RArrIdx < RArr.length) {
            arr[mainCurrIdx] = RArr[RArrIdx];
            RArrIdx += 1;
            mainCurrIdx += 1;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of: O(kn)
     * And a best case running time of: O(kn)
     *
     * Feel free to make an initial O(n) passthrough of the array to
     * determine k, the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * You may use an ArrayList or LinkedList if you wish, but it should only
     * be used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with merge sort. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * You may assume that the passed in array is valid and will not be null.
     *
     * @param arr The array to be sorted.
     */
    public static void lsdRadixSort(int[] arr) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Create buckets for possible digits
        List<LinkedList<Integer>> digitBuckets = new ArrayList<>(19);
        for (int i = 0; i < 19; i++) {
            digitBuckets.add(new LinkedList<>());
        }


        // Find max magnitude value
        int maxPositive = 0;
        int minNegative = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= maxPositive) {
                maxPositive = arr[i];
            }
            if (arr[i] <= minNegative) {
                minNegative = arr[i];
            }
        }

        long absMinNegative = (long) Math.abs((long) minNegative);
        long absMaxPositive = (long) Math.abs((long) maxPositive);
        long maxVal = 0;
        if (absMinNegative >= absMaxPositive) {
            maxVal = minNegative;
        }
        else {
            maxVal = maxPositive;
        }

        // Find number of digits in max number
        int numDigits = 0;
        long tempMaxVal = maxVal;
        if (maxVal == 0) {
            numDigits = 1;
        }
        while (tempMaxVal != 0) {
            tempMaxVal = tempMaxVal / 10;
            numDigits += 1;
        }

        // LSD Radix Loops
        int currDigitDivisor = 10;
        for (int currDigit = 1; currDigit <= numDigits; currDigit++) {
            // Fill buckets
            for (int i = 0; i < arr.length; i++) {
                // Find bucket
                int bucket;
                if (currDigit == 1) {
                    bucket = arr[i] % 10;
                }
                else {
                    bucket = (arr[i] / currDigitDivisor) % 10;
                }
                // Add to bucket
                bucket = bucket + 9;
                LinkedList<Integer> digitBucket = digitBuckets.get(bucket);
                digitBucket.add(arr[i]);
            }

            // Remove from buckets
            int currIdx = 0;
            for (int i = 0; i < 19; i++) {
                LinkedList<Integer> digitBucket = digitBuckets.get(i);
                while (!digitBucket.isEmpty()) {
                    arr[currIdx] = digitBucket.removeFirst();
                    currIdx += 1;
                }
            }

            // Increase digit selection
            if (currDigit > 1) {
                currDigitDivisor *= 10;
            }
        }
    }
}