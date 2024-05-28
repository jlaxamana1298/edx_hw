import java.util.Comparator;
import java.util.Arrays;

public class DCSortingTester {
    public static void main(String[] args) {
        final Comparator<Integer> INTEGER_COMPARATOR = Integer::compareTo;
        Integer[] testList = {4, 3, 1, 5, 2, 6, 7};

        System.out.println(Arrays.toString(testList));

        // Test MergeSort
        Sorting2.mergeSort(testList, INTEGER_COMPARATOR);
        System.out.println(Arrays.toString(testList));
    }
}