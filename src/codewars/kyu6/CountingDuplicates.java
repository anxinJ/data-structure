package codewars.kyu6;

import java.util.HashMap;
import java.util.Map;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Count the number of Duplicates
 * <p>
 * Write a function that will return the count of distinct case-insensitive alphabetic characters
 * and numeric digits that occur more than once in the input string.
 * The input string can be assumed to contain only alphanumeric characters,
 * including digits, uppercase and lowercase alphabets.
 * <p>
 * Example
 * <p>
 * "abcde" -> 0 # no characters repeats more than once
 * "aabbcde" -> 2 # 'a' and 'b'
 * "aabbcdeB" -> 2 # 'a' and 'b'
 * "indivisibility" -> 1 # 'i'
 * "Indivisibilities" -> 2 # 'i' and 's'
 * "aa11" -> 2 # 'a' and '1'
 * Created by hewj on 17/6/14.
 */
public class CountingDuplicates {

    public static int duplicateCount(String text) {
        char[] characters = text.toCharArray();
        int dupCount = 0;
        Map<Character, Integer> charCounts = new HashMap<>();
        for(char character : characters){
            character = Character.toLowerCase(character);
            if(charCounts.get(character) == null){
                charCounts.put(character, 1);
            }else {
                charCounts.put(character, charCounts.get(character).intValue() + 1);
            }
        }
        for(Character character : charCounts.keySet()){
            if(charCounts.get(character) > 1) dupCount++;
        }
        // optimize with java8
//        Long countL = charCounts.values().stream().filter(i -> i > 1).count();
        return dupCount;
    }

    public static int bestPracticesAndCleverest(String text) {
        int ans = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0,1);
            text = text.substring(1);
            if (text.contains(firstLetter)) ans ++;
            text = text.replace(firstLetter, "");
        }
        return ans;
    }



    static int java8Solution(final String text) {
        return (int) charFrequenciesMap(text).values().stream()
                .filter(i -> i > 1)
                .count();
    }

    private static Map<Character, Long> charFrequenciesMap(final String text) {
        return text.codePoints()
                .map(Character::toLowerCase)
                .mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), counting()));
    }
}
