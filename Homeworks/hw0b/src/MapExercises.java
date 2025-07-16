import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char c = 'a'; c <= 'z' ;++c) {
            int num = c - 'a' + 1;
            letterMap.put(c, num);
        }
        return letterMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> squareMap = new HashMap<>();
        for (int num : nums) {
            squareMap.put(num, num * num);
        }
        return squareMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String s: words) {
            if (wordCount.containsKey(s)) {
                int count = wordCount.get(s);
                count += 1;
                wordCount.put(s, count);
            } else {
                wordCount.put(s, 1);
            }
        }
        return wordCount;
    }
}