import java.util.List;

public class AVLTest {
    public static void main(String[] args) {
        AVL<Integer> testAVL = new AVL<>();

        testAVL.add(7);
        testAVL.add(4);
        testAVL.add(10);
        testAVL.add(2);
        testAVL.add(6);
        testAVL.add(8);
        testAVL.add(11);
        testAVL.add(0);
        testAVL.add(3);
        testAVL.add(5);
        testAVL.add(9);
        testAVL.add(1);

        testAVL.remove(4);

        AVLTraversals<Integer> traversals = new AVLTraversals<>();
        List<Integer> inorderResult = traversals.levelorder(testAVL.getRoot());
        System.out.println(inorderResult);
        System.out.println(testAVL.size());
    }
}
