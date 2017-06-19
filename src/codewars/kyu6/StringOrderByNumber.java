package codewars.kyu6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Your task is to sort a given string. Each word in the String will contain a single number. This number is the position the word should have in the result.
 * <p>
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * <p>
 * If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.
 * <p>
 * For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"
 * Created by hewj on 17/6/19.
 */
public class StringOrderByNumber {

    public static String order(String words) {
        if(words == null || "".equals(words.trim())) return "";
        Map<Integer, String> numString = new HashMap<>();
        String[] wordArr = words.split(" ");
        for(String word : wordArr){
            Integer num = getIntegerFromString(word);
            if(numString.get(num) == null){
                numString.put(num, word);
            }else{
                numString.put(num, numString.get(num) + " " + word);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=9;i++){
            if(numString.get(i) != null) sb.append(numString.get(i)).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }

    private static Integer getIntegerFromString(String s){
        for(int i=0;i<s.length();i++){
            if(48 <= s.charAt(i) && s.charAt(i) <= 57) return Character.getNumericValue(s.charAt(i));
        }
        return -1;
    }

    public static String cleverest(String words) {
        return Arrays.stream(words.split(" "))
                .sorted(Comparator.comparing(s -> Integer.valueOf(s.replaceAll("\\D", ""))))
                .collect(Collectors.joining(" "));
    }
}
