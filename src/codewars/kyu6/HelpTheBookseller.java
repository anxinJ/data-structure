package codewars.kyu6;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * A bookseller has lots of books classified in 26 categories labeled A, B, ...
 * Z. Each book has a code c of 3, 4, 5 or more capitals letters. The 1st letter
 * of a code is the capital letter of the book category. In the bookseller's
 * stocklist each code c is followed by a space and by a positive integer n (int
 * n >= 0) which indicates the quantity of books of this code in stock.
 * 
 * In a given stocklist all codes have the same length and all numbers have
 * their own same length (can be different from the code length).
 * 
 * For example an extract of one of the stocklists could be:
 * 
 * L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"}. or
 * 
 * L = ["ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"]. In this
 * stocklist all codes have a length of five and all numbers have a length of
 * two.
 * 
 * You will be given a stocklist (e.g. : L) and a list of categories in capital
 * letters e.g :
 * 
 * M = {"A", "B", "C", "W"} or
 * 
 * M = ["A", "B", "C", "W"] and your task is to find all the books of L with
 * codes belonging to each category of M and to sum their quantity according to
 * each category.
 * 
 * For the lists L and M of example you have to return the string (in
 * Haskell/Clojure a list of pairs):
 * 
 * (A : 20) - (B : 114) - (C : 50) - (W : 0) where A, B, C, W are the
 * categories, 20 is the sum of the unique book of category A, 114 the sum
 * corresponding to "BKWRK" and "BTSQZ", 50 corresponding to "CDXEF" and 0 to
 * category 'W' since there are no code beginning with W.
 * 
 * If L or M are empty return string is "" (Clojure should return an empty array
 * instead).
 * 
 * @author jx
 *
 */
public class HelpTheBookseller {
	
	// 1st parameter is the stocklist (L in example),
	// 2nd parameter is list of categories (M in example)
	public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
		if(lstOfArt.length == 0 || lstOf1stLetter.length == 0) return "";
		Map<String, Integer> map = new TreeMap<>();
		for(String art : lstOfArt) {
			String firstLetter = String.valueOf(art.charAt(0));
			if(map.containsKey(firstLetter))
				map.put(firstLetter, map.get(firstLetter) + Integer.valueOf(art.split("\\s+")[1]));
			else
				map.put(firstLetter, Integer.valueOf(art.split("\\s+")[1]));
		}
		StringBuilder sb = new StringBuilder();
		for(String letter : lstOf1stLetter) {
			sb.append("(").append(letter).append(" : ");
			if(map.containsKey(letter))
				sb.append(map.get(letter));
			else
				sb.append("0");
			sb.append(")").append(" - ");
		}
		return sb.length() == 0? "" : sb.substring(0, sb.length() - 3);
	}
	
	private static class Book {
        public final String category;
        public final String code;
        public final int quantity;

        public Book(String label) {
            category = label.substring(0,1);
            code = label.split(" ")[0].substring(1);
            quantity = Integer.parseInt(label.split(" ")[1]);
        }
    }
	
	public static String bestPratices(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0)
          return "";
        Map<String, Integer> categoryCounts = Arrays.stream(lstOfArt)
                .map(Book::new)
                .collect(Collectors.groupingBy(book -> book.category,
                         Collectors.summingInt(book -> book.quantity)));
        return Arrays.stream(lstOf1stLetter)
                .map(initial -> String.format("(%s : %d)", 
                                              initial, categoryCounts.getOrDefault(initial, 0)))
                .collect(Collectors.joining(" - "));
    }
	
	public static String bestPratices1(String[] lstOfArt, String[] lstOf1stLetter) {
		int sum = 0;
		boolean hasRunOnce = false;
		String stock = "";
		for (int i = 0; i < lstOf1stLetter.length; i++) {
			for (int j = 0; j < lstOfArt.length; j++) {
				if (lstOf1stLetter[i].charAt(0) == lstOfArt[j].charAt(0)) {
					sum += Integer.parseInt(lstOfArt[j].substring(lstOfArt[j].indexOf(" ") + 1));
				}
				if (j == lstOfArt.length - 1) {
					if (!hasRunOnce) {
						stock += "(" + lstOf1stLetter[i] + " : " + sum + ")";
						sum = 0;
						hasRunOnce = true;
					} else {
						stock += " - (" + lstOf1stLetter[i] + " : " + sum + ")";
						sum = 0;
					}
				}
			}
		}
		return stock;
	}
}
