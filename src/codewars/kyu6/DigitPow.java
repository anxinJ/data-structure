package codewars.kyu6;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Some numbers have funny properties. For example:
 * 
 * 89 --> 8¹ + 9² = 89 * 1
 * 
 * 695 --> 6² + 9³ + 5⁴= 1390 = 695 * 2
 * 
 * 46288 --> 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 = 46288 * 51 Given a positive
 * integer n written as abcd... (a, b, c, d... being digits) and a positive
 * integer p we want to find a positive integer k, if it exists, such as the sum
 * of the digits of n taken to the successive powers of p is equal to k * n. In
 * other words:
 * 
 * Is there an integer k such as : (a ^ p + b ^ (p+1) + c ^(p+2) + d ^ (p+3) +
 * ...) = n * k If it is the case we will return k, if not return -1.
 * 
 * Note: n, p will always be given as strictly positive integers.
 * 
 * digPow(89, 1) should return 1 since 8¹ + 9² = 89 = 89 * 1 digPow(92, 1)
 * should return -1 since there is no k such as 9¹ + 2² equals 92 * k
 * digPow(695, 2) should return 2 since 6² + 9³ + 5⁴= 1390 = 695 * 2
 * digPow(46288, 3) should return 51 since 4³ + 6⁴+ 2⁵ + 8⁶ + 8⁷ = 2360688 =
 * 46288 * 51
 * 
 * @author jx
 *
 */
public class DigitPow {
	
	public static long digitPow(int n, int p) {
		List<Integer> nums = Arrays.stream(String.valueOf(n).split("")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
		BigDecimal sum = BigDecimal.ZERO;
		for(Integer num : nums) 
			sum = sum.add(new BigDecimal(num).pow(p++));
		BigDecimal bigN = new BigDecimal(n);
		return sum.remainder(bigN).compareTo(BigDecimal.ZERO) == 0?sum.divide(bigN).longValue() : -1;
	}
	
	public static long bestPratices(int n, int p) {
		String intString = String.valueOf(n);
		long sum = 0;
		for (int i = 0; i < intString.length(); ++i, ++p)
			sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
		return (sum % n == 0) ? sum / n : -1;
	}
}
