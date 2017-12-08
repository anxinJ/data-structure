package codewars.kyu6;

import java.math.BigInteger;

/**
 * I need to save some money to buy a gift. I think I can do something like
 * that:
 * 
 * First week (W0) I save nothing on Sunday, 1 on Monday, 2 on Tuesday... 6 on
 * Saturday, second week (W1) 2 on Monday... 7 on Saturday and so on according
 * to the table below where the days are numbered from 0 to 6.
 * 
 * Can you tell me how much I will have for my gift on Saturday evening after I
 * have saved 12? (Your function finance(6) should return 168 which is the sum
 * of the savings in the table).
 * 
 * Imagine now that we live on planet XY140Z-n where the days of the week are
 * numbered from 0 to n (integer n > 0) and where I save from week number 0 to
 * week number n included (in the table below n = 6).
 * 
 * How much money would I have at the end of my financing plan on planet
 * XY140Z-n?
 * 
 *	 --	Su	Mo	Tu	We	Th	Fr	Sa
 *	W6							12	
 *	W5						10	11	
 *	W4					8	9	10	
 *	W3				6	7	8	9	
 *	W2			4	5	6	7	8	
 *	W1		2	3	4	5	6	7	
 *	W0	0	1	2	3	4	5	6
 * 
 * finance(5) --> 105 finance(6) --> 168 finance(7) --> 252 finance(5000) -->
 * 62537505000 #Hint: try to avoid nested loops
 * 
 * @author jx
 *
 */
public class Finance {
	
	public static BigInteger finance(int n) {
		// (0+n)*(n+1)/2 + (2+n+1)*(n)/2 + (4+n+2)*(n-1)/2 ...
		BigInteger sum = BigInteger.ZERO;
		for(int i=n+1,j=0,k=0;i>0;i--,j+=2,k+=1) 
			sum = sum.add(new BigInteger("" + (j + n + k) * i));
		return sum.divide(new BigInteger("2"));
	}
	
	 /*
	    * SOLUTION EXPLANATION:
	    * Let's call each slot in the calendar a tile. We can make the following observations regarding the number of these tiles:
	    *   - The total number of tiles (including empty ones): (n+1) * (n+1)
	    *   - To calculate the total number of empty tiles, you simply need to take away the bottomleft-topright diagonal, and divide the rest by 2.
	    *     Therefore, the total number of empty tiles: n * (n+1) / 2 (simplified version of ((n+1)*(n+1) - (n+1)) / 2)
	    *   - So the total number of non-empty tiles is: (n+1) * (n+1) - n * (n+1) / 2
	    * 
	    * As for the values of these tiles: 
	    *   - Each nonempty tile on the topleft-bottomright diagonal has the value: n
	    *   - Each nonempty tile NOT on the topleft-bottomright diagonal can be paried in a way that the value of the pair is 2n. (think about folding the table along the diagonal)
	    *   - It follows from the above two observations that the total value is: (total number of non-empty tiles) * n
	    *   
	    * Therefore, the final formula: ((n+1)*(n+1) - n*(n+1)/2) * n
	    * 
	    * Note: it is possible to simplify the formula but I think this form shows the logic behind it better :) 
	    * */
	    public static BigInteger  bestPratices(int n) {
	        BigInteger totalNumberOfTiles = BigInteger.valueOf(n+1).multiply(BigInteger.valueOf(n+1));
	        BigInteger emptyTiles = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).divide(BigInteger.valueOf(2));
	        return BigInteger.valueOf(n).multiply(totalNumberOfTiles.subtract(emptyTiles));
	    }
}
