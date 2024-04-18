import java.util.NoSuchElementException;

/**
 * Your implementation of a MinHeap.
 */
public class MinHeap<T extends Comparable<? super T>> {

    /**
     * The initial capacity of the MinHeap.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 13;

     /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new MinHeap.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast a Comparable[] to a T[] to get the generic typing.
     */
    public MinHeap() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    /**
     * Adds an item to the heap. If the backing array is full (except for
     * index 0) and you're trying to add a new item, then double its capacity.
     *
     * Method should run in amortized O(log n) time.
     *
     * @param data The data to add.
     * @throws java.lang.IllegalArgumentException If the data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        if (size == backingArray.length - 1) {
            backingArray = resizeArray();
        }

        if (size == 0) {
            backingArray[1] = data;
            size += 1;
        }
        else {
            backingArray[size + 1] = data;
            size += 1;
            backingArray[size] = upHeap(data, size);
        }
    }

    /**
     * Removes and returns the min item of the heap. As usual for array-backed
     * structures, be sure to null out spots as you remove. Do not decrease the
     * capacity of the backing array.
     *
     * Method should run in O(log n) time.
     *
     * @return The data that was removed.
     * @throws java.util.NoSuchElementException If the heap is empty.
     */
    public T remove() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (size == 0) {
            throw new NoSuchElementException("List is MT");
        }

        T returnVal = backingArray[1];
        if (size == 1) {
            backingArray[1] = null;
            size -= 1;
        }
        else if (size > 1) {
            backingArray[1] = backingArray[size];
            backingArray[size] = null;
            size -= 1;
            downHeap(1);
        }

        return returnVal;
    }

    /**
     * Returns the backing array of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the heap.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    // resize array function
    private T[] resizeArray() {
        int newSize = backingArray.length * 2;
        T[] tempArray = (T[]) new Comparable[newSize];
        for (int i = 0; i < backingArray.length; i++) {
            tempArray[i] = backingArray[i];
        }
        return tempArray;
    }

    // Recursive upHeap function used in Add method
    private T upHeap(T data, int currIndex) {
        if (currIndex == 1) {
            return backingArray[currIndex];
        }

        int currParentIndex = currIndex / 2;
        int compareVal = data.compareTo(backingArray[currParentIndex]);
        if (compareVal < 0) {
            T tempVal = backingArray[currParentIndex];
            backingArray[currParentIndex] = backingArray[currIndex];
            backingArray[currIndex] = tempVal;

            backingArray[currParentIndex] = upHeap(backingArray[currParentIndex], currParentIndex);
        }

        return backingArray[currIndex];
    }

    // Recursive downHeap function used in Remove method
    private void downHeap(int currIndex) {
        int leftChildIndex = currIndex * 2;
        int rightChildIndex = leftChildIndex + 1;
        if (leftChildIndex > size) {
            return;
        }

        if (rightChildIndex > size && backingArray[leftChildIndex] != null) {
            int compareVal = backingArray[currIndex].compareTo(backingArray[leftChildIndex]);
            if (compareVal > 0) {
                T tempVal = backingArray[leftChildIndex];
                backingArray[leftChildIndex] = backingArray[currIndex];
                backingArray[currIndex] = tempVal;
            }
        }
        else if (backingArray[rightChildIndex] != null && backingArray[leftChildIndex] != null) {
            int compareVal = backingArray[leftChildIndex].compareTo(backingArray[rightChildIndex]);
            if (compareVal > 0) {
                compareVal = backingArray[currIndex].compareTo(backingArray[rightChildIndex]);
                if (compareVal > 0) {
                    T tempVal = backingArray[rightChildIndex];
                    backingArray[rightChildIndex] = backingArray[currIndex];
                    backingArray[currIndex] = tempVal;

                    downHeap(rightChildIndex);
                }
            }
            else if (compareVal < 0) {
                compareVal = backingArray[currIndex].compareTo(backingArray[leftChildIndex]);
                if (compareVal > 0) {
                    T tempVal = backingArray[leftChildIndex];
                    backingArray[leftChildIndex] = backingArray[currIndex];
                    backingArray[currIndex] = tempVal;

                    downHeap(leftChildIndex);
                }
            }
        }
    }
}