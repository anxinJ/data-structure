package codewars.kyu6;


import java.util.stream.Stream;

/**
 * Created by hewj on 17/6/14.
 */
public class ShortestWord {

    public static int findShort(String s) {
        int minLen = s.length();
        String[] words = s.split(" ");
        for(String word : words){
            if(word.length() < minLen) minLen = word.length();
        }
        return minLen;
    }

    public static int bestPractices(String s){
        return Stream.of(s.split(" ")).mapToInt(String::length).min().getAsInt();
    }
}
