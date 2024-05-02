import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class AVLTraversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(AVLNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (root == null) {
            return null;
        }

        List<T> returnList = new ArrayList<>();

        returnList.add(root.getData());
        if (root.getLeft() != null) {
            returnList.addAll(preorder(root.getLeft()));
        }
        if (root.getRight() != null) {
            returnList.addAll(preorder(root.getRight()));
        }

        return returnList;
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(AVLNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (root == null) {
            return null;
        }
        
        List<T> returnList = new ArrayList<>();

        if (root.getLeft() != null) {
            returnList.addAll(inorder(root.getLeft()));
        }
        returnList.add(root.getData());
        if (root.getRight() != null) {
            returnList.addAll(inorder(root.getRight()));
        }

        return returnList;
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(AVLNode<T> root) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (root == null) {
            return null;
        }

        List<T> returnList = new ArrayList<>();

        if (root.getLeft() != null) {
            returnList.addAll(postorder(root.getLeft()));
        }
        if (root.getRight() != null) {
            returnList.addAll(postorder(root.getRight()));
        }
        returnList.add(root.getData());

        return returnList;
    }

    // level order addition for easier verification of AVL
    public List<T> levelorder(AVLNode<T> root) {
        if (root == null) {
            return null;
        }

        List<T> returnList = new ArrayList<>();

        Queue<AVLNode<T>> tempQueue = new LinkedList<>();
        /*
         * offer() adds element to queue immediately if it will not violate
         * capacity restrictions. Returns False if container is full
         * add() will throw an exception if container is full instead
         */
        tempQueue.offer(root);

        while (!(tempQueue.isEmpty())) {
            AVLNode<T> currNode = tempQueue.poll();
            returnList.add(currNode.getData());

            // Enqueue left child
            if (currNode.getLeft() != null) {
                tempQueue.offer(currNode.getLeft());
            }
            // Enqueue right child
            if (currNode.getRight() != null) {
                tempQueue.offer(currNode.getRight());
            }
        }

        return returnList;
    }
}