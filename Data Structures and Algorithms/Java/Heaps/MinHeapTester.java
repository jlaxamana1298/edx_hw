import java.util.ArrayList;
import java.util.Arrays;

public class MinHeapTester {
    public static void main(String[] args) {
        MinHeap<Integer> testHeap = new MinHeap<>();

        testHeap.add(0);
        testHeap.add(7);
        testHeap.add(14);
        testHeap.add(21);
        testHeap.add(28);
        testHeap.add(35);
        testHeap.add(42);
        testHeap.add(49);
        testHeap.add(56);
        System.out.println(Arrays.toString(testHeap.getBackingArray()));
        int removedVal = testHeap.remove();
        System.out.println(removedVal);
        System.out.println(Arrays.toString(testHeap.getBackingArray()));
        removedVal = testHeap.remove();
        System.out.println(removedVal);
        System.out.println(Arrays.toString(testHeap.getBackingArray()));
    }
}