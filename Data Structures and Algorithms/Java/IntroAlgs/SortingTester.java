import java.util.Comparator;
import java.util.Arrays;

public class SortingTester {
    public static void main(String[] args) {
        final Comparator<Integer> INTEGER_COMPARATOR = Integer::compareTo;
        Integer[] testList = {4, 3, 1, 5, 2, 6, 7};

        System.out.println(Arrays.toString(testList));

        // Test Bubble Sort
        //Sorting.bubbleSort(testList, INTEGER_COMPARATOR);
        //System.out.println(Arrays.toString(testList));
        // Test Selection Sort
        //Sorting.selectionSort(testList, INTEGER_COMPARATOR);
        //System.out.println(Arrays.toString(testList));
        // Test Insertion Sort
        Sorting.insertionSort(testList, INTEGER_COMPARATOR);
        System.out.println(Arrays.toString(testList));
    }
}
