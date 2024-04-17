import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        root = helperAdd(data, root);
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        BSTNode<T> returnNode = new BSTNode<T>(data);
        root = helperRemove(data, root, returnNode);
        return returnNode.getData();
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

    // Add helper function
    private BSTNode<T> helperAdd(T data, BSTNode<T> currNode) {
        if (currNode == null) {
            BSTNode<T> returnNode = new BSTNode<>(data);
            size += 1;
            return returnNode;
        }
        
        int compareVal = data.compareTo(currNode.getData());
        if (compareVal > 0) {
            currNode.setRight(helperAdd(data, currNode.getRight()));
        }
        else if (compareVal < 0) {
            currNode.setLeft(helperAdd(data, currNode.getLeft()));
        }

        return currNode;
    }

    // Remove helper function
    private BSTNode<T> helperRemove(T data, BSTNode<T> currNode, BSTNode<T> retNode) {
        if (currNode == null) {
            throw new NoSuchElementException("Data was not found");
        }

        int compareVal = data.compareTo(currNode.getData());
        if (compareVal > 0) {
            currNode.setRight(helperRemove(data, currNode.getRight(), retNode));
        }
        else if (compareVal < 0) {
            currNode.setLeft(helperRemove(data, currNode.getLeft(), retNode));
        }
        else {
            retNode.setData(data);
            size -= 1;
            
            // Leaf node
            if (currNode.getLeft() == null && currNode.getRight() == null) {
                return null;
            }
            // If only right node
            else if (currNode.getLeft() == null) {
                return currNode.getRight();
            }
            // If only left node
            else if (currNode.getRight() == null) {
                return currNode.getLeft();
            }
            // If 2 children then use successor
            else {
                BSTNode<T> dummyNode = new BSTNode<T>(data);
                currNode.setRight(SuccessorReplace(currNode.getRight(), dummyNode));
                currNode.setData(dummyNode.getData());
            }
        }
        return currNode;
    }

    // Remove Successor function
    private BSTNode<T> SuccessorReplace(BSTNode<T> currNode, BSTNode<T> dummyNode) {
        if (currNode.getLeft() == null) {
            dummyNode.setData(currNode.getData());
            return currNode.getRight();
        }
        else {
            currNode.setLeft(SuccessorReplace(currNode.getLeft(), dummyNode));
        }
        return currNode;
    }
}