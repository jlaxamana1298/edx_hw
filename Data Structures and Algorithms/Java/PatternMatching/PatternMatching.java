import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Your implementations of the Boyer Moore string searching algorithm.
 */
public class PatternMatching {
    /**
     * Boyer Moore algorithm that relies on a last occurrence table.
     * This algorithm Works better with large alphabets.
     *
     * Make sure to implement the buildLastTable() method, which will be
     * used in this boyerMoore() method.
     *
     * Note: You may find the getOrDefault() method from Java's Map class useful.
     *
     * You may assume that the passed in pattern, text, and comparator will not be null.
     *
     * @param pattern    The pattern you are searching for in a body of text.
     * @param text       The body of text where you search for the pattern.
     * @param comparator You MUST use this to check if characters are equal.
     * @return           List containing the starting index for each match found.
     */
    public static List<Integer> boyerMoore(CharSequence pattern, CharSequence text, CharacterComparator comparator) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Initialize variables
        List<Integer> returnList = new ArrayList<>();
        int patternLength = pattern.length();
        int textLength = text.length();
        int currTextIndex = 0;
        int currPatternIndex = 0;

        // Corner case(s)
        if (patternLength > textLength) {
            return returnList;
        }

        // Create Last Occurance Table
        Map<Character, Integer> LastOccuranceTable = buildLastTable(pattern);

        // Comparissons Loop
        while (currTextIndex <= textLength - patternLength) {
            // Start character comparissons from right side of pattern
            currPatternIndex = patternLength - 1;

            // Compare characters and scan leftwards
            while (currPatternIndex >= 0 && comparator.compare(text.charAt(currTextIndex + currPatternIndex), pattern.charAt(currPatternIndex)) == 0) {
                currPatternIndex -= 1;
            }

            // If currPatternIndex = -1 then pattern was found
            if (currPatternIndex == -1) {
                returnList.add(currTextIndex);
                currTextIndex += 1;
            }
            // If no match, query last table to find shift
            else {
                int shiftAmount = LastOccuranceTable.getOrDefault(text.charAt(currTextIndex + currPatternIndex), -1);

                if (shiftAmount < currPatternIndex) {
                    currTextIndex = currTextIndex + currPatternIndex - shiftAmount;
                }
                else {
                    currTextIndex += 1;
                }
            }
        }

        return returnList;
    }

    /**
     * Builds the last occurrence table that will be used to run the Boyer Moore algorithm.
     *
     * Note that each char x will have an entry at table.get(x).
     * Each entry should be the last index of x where x is a particular
     * character in your pattern.
     * If x is not in the pattern, then the table will not contain the key x,
     * and you will have to check for that in your Boyer Moore implementation.
     *
     * Ex. pattern = octocat
     *
     * table.get(o) = 3
     * table.get(c) = 4
     * table.get(t) = 6
     * table.get(a) = 5
     * table.get(everything else) = null, which you will interpret in
     * Boyer-Moore as -1
     *
     * If the pattern is empty, return an empty map.
     * You may assume that the passed in pattern will not be null.
     *
     * @param pattern A pattern you are building last table for.
     * @return A Map with keys of all of the characters in the pattern mapping
     *         to their last occurrence in the pattern.
     */
    public static Map<Character, Integer> buildLastTable(CharSequence pattern) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Initialize variables
        int patternLength = pattern.length();
        Map<Character, Integer> LastOccuranceTable = new HashMap<>();

        // Loop to build Last Occurance Table
        for (int i = 0; i < patternLength; i++) {
            LastOccuranceTable.put(pattern.charAt(i), i);
        }

        return LastOccuranceTable;
    }
}