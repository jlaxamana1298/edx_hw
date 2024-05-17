import java.util.Comparator;

/**
 * Your implementation of various iterative sorting algorithms.
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * NOTE: You should implement bubble sort with the last swap optimization.
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        int stopIndex = arr.length - 1;
        int lastSwapIndex = stopIndex;
        int swapMade = 1;
        
        //int swapsMade = 0;
        //int compsMade = 0;

        while (stopIndex != 0 && swapMade == 1) {
            int i = 0;
            swapMade = 0;
            while (i < stopIndex) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapMade = 1;
                    lastSwapIndex = i + 1;
                    //swapsMade += 1;
                }
                //compsMade += 1;
                i += 1;
            }
            stopIndex = lastSwapIndex - 1;
        }
        //System.out.println("Swaps made: " + swapsMade);
        //System.out.println("Comps made: " + compsMade);
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n^2)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int lastCheckingIndex = arr.length - 1; lastCheckingIndex > 0; lastCheckingIndex--) {
            int maxValueIndex = lastCheckingIndex;
            for (int currIndex = 0; currIndex < lastCheckingIndex; currIndex++) {
                if (comparator.compare(arr[currIndex], arr[maxValueIndex]) > 0) {
                    maxValueIndex = currIndex;
                }
            }
            T tempVal = arr[lastCheckingIndex];
            arr[lastCheckingIndex] = arr[maxValueIndex];
            arr[maxValueIndex] = tempVal;
        }

    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of: O(n^2)
     * And a best case running time of: O(n)
     *
     * You may assume that the passed in array and comparator
     * are both valid and will never be null.
     *
     * @param <T>        Data type to sort.
     * @param arr        The array that must be sorted after the method runs.
     * @param comparator The Comparator used to compare the data in arr.
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        for (int lastSortedIndex = 0; lastSortedIndex < arr.length - 1; lastSortedIndex++) {
            int currIndex = lastSortedIndex + 1;
            while (currIndex != 0 && comparator.compare(arr[currIndex], arr[currIndex - 1]) < 0) {
                T tempVal = arr[currIndex];
                arr[currIndex] = arr[currIndex - 1];
                arr[currIndex - 1] = tempVal;
                currIndex -= 1;
            }
        }
    }
}