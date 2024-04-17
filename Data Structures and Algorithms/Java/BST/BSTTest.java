import java.util.List;

public class BSTTest {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        bst.add(5);
        System.out.println(bst.getRoot().getData());

        bst.add(1);
        bst.add(6);
        bst.add(3);
        bst.add(2);
        bst.add(4);
        bst.add(4);
        bst.add(1);
        bst.add(-7);
        bst.remove(1);
        bst.remove(5);

        BSTTraversals<Integer> traversals = new BSTTraversals<>();
        List<Integer> inorderResult = traversals.inorder(bst.getRoot());
        System.out.println(inorderResult);
        System.out.println(bst.size());
    }
}