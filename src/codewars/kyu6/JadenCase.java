package codewars.kyu6;

import java.util.Arrays;

/**
 * Jaden Smith, the son of Will Smith, is the star of films such as The Karate Kid (2010) and After Earth (2013). Jaden is also known for some of his philosophy that he delivers via Twitter. When writing on Twitter, he is known for almost always capitalizing every word.
 * <p>
 * Your task is to convert strings to how they would be written by Jaden Smith. The strings are actual quotes from Jaden Smith, but they are not capitalized in the same way he originally typed them.
 * <p>
 * Example:
 * <p>
 * Not Jaden-Cased: "How can mirrors be real if our eyes aren't real"
 * Jaden-Cased:     "How Can Mirrors Be Real If Our Eyes Aren't Real"
 * Note that the Java version expects a return value of null for an empty string or null.
 * <p>
 * Created by hewj on 17/6/14.
 */
public class JadenCase {

    public String toJadenCase(String phrase) {
        if(phrase == null || "".equals(phrase.trim())) {
            return null;
        }
        char[] characters = phrase.toCharArray();
        for(int i=0;i<characters.length;i++){
            if(i== 0 || characters[i-1] == 32){
                characters[i] -= 32;
            }
        }
        return String.valueOf(characters);
    }

    static public String java8Solution(String phrase){

        if(phrase.length() == 0 || phrase == null)
            return null;

        String[] splittedString = phrase.split(" ");

        String[] jadenCaseString = Arrays.stream(splittedString)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .toArray(size -> new String[size]);

        return String.join(" ", jadenCaseString);
    }
}
