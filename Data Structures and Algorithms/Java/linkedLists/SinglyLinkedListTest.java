public class SinglyLinkedListTest {
    public static void main(String[] args) {
        // Create SinglyLinkedList object
        SinglyLinkedList<Integer> numList = new SinglyLinkedList<>();

        // Add elements to front
        numList.addToFront(2);
        numList.addToFront(1);

        // Add elements to back
        numList.addToBack(8);
        numList.addToBack(9);

        // Print size of list
        int listSize = numList.size();
        System.out.println("Size of list: " + listSize);

        // Print values in list
        int i = 0;
        SinglyLinkedListNode<Integer> currNode = numList.getHead();
        while (i < listSize) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
            i += 1;
        }

        // Remove from back of list
        int removed;
        removed = numList.removeFromBack();
        System.out.println("Removed: " + removed);

        // Remove from front of list
        removed = numList.removeFromFront();
        System.out.println("Removed: " + removed);

        // Print size of list
        listSize = numList.size();
        System.out.println("Size of list: " + listSize);

        // Print values in list
        i = 0;
        currNode = numList.getHead();
        while (i < listSize) {
            System.out.println(currNode.getData());
            currNode = currNode.getNext();
            i += 1;
        }
    }
}
