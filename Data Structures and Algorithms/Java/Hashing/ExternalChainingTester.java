public class ExternalChainingTester {
    public static void main(String[] args) {
        ExternalChainingHashMap<Character, Integer> testHash = new ExternalChainingHashMap<>();
        ExternalChainingMapEntry<Character, Integer>[] table;

        testHash.put('a', 1);
        testHash.put('a', 3);
        testHash.put('n', 2);
        testHash.put('t', 9);
        testHash.put('b', 7);
        testHash.put('q', 8);
        testHash.put('y', 142);
        testHash.put('f', 8);
        testHash.put('q', 74);
        testHash.put('t', 8);
        testHash.put('8', 19);
        testHash.put('3', 12);


        table = testHash.getTable();

        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                ExternalChainingMapEntry<Character, Integer> currNode = table[i];
                while (currNode != null) {
                    if (currNode.getNext() == null) {
                        System.out.println(currNode);
                        currNode = currNode.getNext();
                    }
                    else {
                        System.out.print(currNode);
                        currNode = currNode.getNext();
                    }
                }
            }
            else {
                System.out.println(table[i]);
            }
        }
    }
}
