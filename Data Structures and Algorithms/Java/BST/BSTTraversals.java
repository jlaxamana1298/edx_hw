import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class BSTTraversals<T extends Comparable<? super T>> {

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
    public List<T> preorder(BSTNode<T> root) {
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
    public List<T> inorder(BSTNode<T> root) {
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
    public List<T> postorder(BSTNode<T> root) {
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
}