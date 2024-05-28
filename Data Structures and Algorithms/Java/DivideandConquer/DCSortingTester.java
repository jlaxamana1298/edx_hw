import java.util.Comparator;
import java.util.Arrays;

public class DCSortingTester {
    public static void main(String[] args) {
        final Comparator<Integer> INTEGER_COMPARATOR = Integer::compareTo;
        Integer[] testList = {4, 3, 1, 5, 2, 6, 7};
        int[] LSDtestList = {-2147483648, -800, -796, -785, -138, 104, 151, 258, 543, 908};

        System.out.println(Arrays.toString(testList));

        // Test MergeSort
        Sorting2.mergeSort(testList, INTEGER_COMPARATOR);
        System.out.println(Arrays.toString(testList));

        // Test LSD Radix
        Sorting2.lsdRadixSort(LSDtestList);
        System.out.println(Arrays.toString(LSDtestList));
    }
}