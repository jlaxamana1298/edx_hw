import java.util.List;

public class TraversalsTester {
    public static void main(String[] args) {
        /*
         * 
         
        TreeNode<Integer> testRootNode = new TreeNode<Integer>(50);
        testRootNode.setLeft(new TreeNode<Integer>(25));
        testRootNode.getLeft().setLeft(new TreeNode<Integer>(10));
        testRootNode.setRight(new TreeNode<Integer>(100));
        testRootNode.getRight().setLeft(new TreeNode<Integer>(75));
        testRootNode.getRight().setRight(new TreeNode<Integer>(125));
        testRootNode.getRight().getRight().setLeft(new TreeNode<Integer>(110));
*/
        TreeNode<Integer> testRootNode = null;

        Traversals<Integer> traversals = new Traversals<>();

        List<Integer> preorderResult = traversals.preorder(testRootNode);
        System.out.println(preorderResult);

        List<Integer> inorderResult = traversals.inorder(testRootNode);
        System.out.println(inorderResult);

        List<Integer> postorderResult = traversals.postorder(testRootNode);
        System.out.println(postorderResult);
    }
}
