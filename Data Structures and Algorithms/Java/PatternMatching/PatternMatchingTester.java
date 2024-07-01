import java.util.List;
import java.util.Map;

public class PatternMatchingTester {
    public static void main(String[] args) {
        String pattern = "ABCD";
        String text = "BAADBACCD";

        CharacterComparator comparator = new CharacterComparator();
        List<Integer> matches = PatternMatching.boyerMoore(pattern, text, comparator);

        int comparissons = comparator.getComparisonCount();
        System.out.println(matches.toString());
        System.out.println(comparissons);
    }
}
