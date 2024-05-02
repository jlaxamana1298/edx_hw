/**
 * Your implementation of the AVL tree rotations.
 */
public class AVL_temp<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Updates the height and balance factor of a node using its
     * setter methods.
     *
     * Recall that a null node has a height of -1. If a node is not
     * null, then the height of that node will be its height instance
     * data. The height of a node is the max of its left child's height
     * and right child's height, plus one.
     *
     * The balance factor of a node is the height of its left child
     * minus the height of its right child.
     *
     * This method should run in O(1).
     * You may assume that the passed in node is not null.
     *
     * This method should only be called in rotateLeft(), rotateRight(),
     * and balance().
     *
     * @param currentNode The node to update the height and balance factor of.
     */
    public void updateHeightAndBF(AVLNode<T> currentNode) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (currentNode.getLeft() == null) {
            // if both children are null then this is a leaf node
            if (currentNode.getRight() == null) {
                currentNode.setHeight(0);
                currentNode.setBalanceFactor(0);
            }
            // udpate based on right child BF and height
            else {
                currentNode.setHeight(currentNode.getRight().getHeight() + 1);
                currentNode.setBalanceFactor((-1) - currentNode.getRight().getHeight());
            }
        }
        else {
            // update based on left child BF and height
            if (currentNode.getRight() == null) {
                currentNode.setHeight(currentNode.getLeft().getHeight() + 1);
                currentNode.setBalanceFactor(currentNode.getLeft().getHeight() - (-1));
            }
            else {
                // find highest height
                if (currentNode.getLeft().getHeight() > currentNode.getRight().getHeight()) {
                    currentNode.setHeight(currentNode.getLeft().getHeight() + 1);
                    currentNode.setBalanceFactor(currentNode.getLeft().getHeight() - currentNode.getRight().getHeight());
                }
                else {
                    currentNode.setHeight(currentNode.getRight().getHeight() + 1);
                    currentNode.setBalanceFactor(currentNode.getLeft().getHeight() - currentNode.getRight().getHeight());
                }
            }
        }
    }

    /**
     * Method that rotates a current node to the left. After saving the
     * current's right node to a variable, the right node's left subtree will
     * become the current node's right subtree. The current node will become
     * the right node's left subtree.
     *
     * Don't forget to recalculate the height and balance factor of all
     * affected nodes, using updateHeightAndBF().
     *
     * This method should run in O(1).
     *
     * You may assume that the passed in node is not null and that the subtree
     * starting at that node is right heavy. Therefore, you do not need to
     * perform any preliminary checks, rather, you can immediately perform a
     * left rotation on the passed in node and return the new root of the subtree.
     *
     * This method should only be called in balance().
     *
     * @param currentNode The current node under inspection that will rotate.
     * @return The parent of the node passed in (after the rotation).
     */
    public AVLNode<T> rotateLeft(AVLNode<T> currentNode) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        AVLNode<T> rChild = currentNode.getRight();
        currentNode.setRight(rChild.getLeft());
        rChild.setLeft(currentNode);
        updateHeightAndBF(currentNode);
        updateHeightAndBF(rChild);
        return rChild;
    }

    /**
     * Method that rotates a current node to the right. After saving the
     * current's left node to a variable, the left node's right subtree will
     * become the current node's left subtree. The current node will become
     * the left node's right subtree.
     *
     * Don't forget to recalculate the height and balance factor of all
     * affected nodes, using updateHeightAndBF().
     *
     * This method should run in O(1).
     *
     * You may assume that the passed in node is not null and that the subtree
     * starting at that node is left heavy. Therefore, you do not need to perform
     * any preliminary checks, rather, you can immediately perform a right
     * rotation on the passed in node and return the new root of the subtree.
     *
     * This method should only be called in balance().
     *
     * @param currentNode The current node under inspection that will rotate.
     * @return The parent of the node passed in (after the rotation).
     */
    public AVLNode<T> rotateRight(AVLNode<T> currentNode) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        AVLNode<T> lChild = currentNode.getLeft();
        currentNode.setLeft(lChild.getRight());
        lChild.setRight(currentNode);
        updateHeightAndBF(currentNode);
        updateHeightAndBF(lChild);
        return lChild;
    }

    /**
     * This is the overarching method that is used to balance a subtree
     * starting at the passed in node. This method will utilize
     * updateHeightAndBF(), rotateLeft(), and rotateRight() to balance
     * the subtree. In part 2 of this assignment, this balance() method
     * will be used in your add() and remove() methods.
     *
     * The height and balance factor of the current node is first recalculated.
     * Based on the balance factor, a no rotation, a single rotation, or a
     * double rotation takes place. The current node is returned.
     *
     * You may assume that the passed in node is not null. Therefore, you do
     * not need to perform any preliminary checks, rather, you can immediately
     * check to see if any rotations need to be performed.
     *
     * This method should run in O(1).
     *
     * @param cur The current node under inspection.
     * @return The AVLNode that the caller should return.
     */
    public AVLNode<T> balance(AVLNode<T> currentNode) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        /* First, we update the height and balance factor of the current node. */
        updateHeightAndBF(currentNode);

        // if tree is right-heavy
        if (currentNode.getBalanceFactor() == -2) {
            // Check if right balance factor is 'opposite'
            if (currentNode.getRight().getBalanceFactor() == 1) {
                currentNode.setRight(rotateRight(currentNode.getRight()));
            }
            currentNode = rotateLeft(currentNode);
        // if tree is left-heavy
        } else if (currentNode.getBalanceFactor() == 2) {
            if (currentNode.getLeft().getBalanceFactor() == (-1)) {
                currentNode.setLeft(rotateLeft(currentNode.getLeft()));
            }
            currentNode = rotateRight(currentNode);
        }

        return currentNode;
    }
}