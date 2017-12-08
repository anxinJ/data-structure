package codewars.kyu6;

/**
 * Write a function that receives two strings and returns n, where n is equal to the number of characters we should shift the first string forward to match the second.
 * <p>
 * For instance, take the strings "fatigue" and "tiguefa". In this case, the first string has been rotated 5 characters forward to produce the second string, so 5 would be returned.
 * <p>
 * If the second string isn't a valid rotation of the first string, the method returns -1.
 * Examples:
 * <p>
 * "coffee", "eecoff" => 2
 * "eecoff", "coffee" => 4
 * "moose", "Moose" => -1
 * "isn't", "'tisn" => 2
 * "Esham", "Esham" => 0
 * "dog", "god" => -1
 * Created by hewj on 17/6/19.
 */
public class CalculateRotation {

    static int shiftedDiff(String first, String second){
        char[] chracters = first.toCharArray();
        int count = -1;
        for(int i=0;i<chracters.length;i++){

        }
        return count;
    }

}
