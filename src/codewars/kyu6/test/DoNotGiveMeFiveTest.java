package codewars.kyu6.test;

import codewars.kyu6.DoNotGiveMeFive;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Don't give me five!
 * <p>
 * In this kata you get the start number and the end number of a region and should return the count of all numbers except numbers with a 5 in it. The start and the end number are both inclusive!
 * <p>
 * Examples:
 * <p>
 * 1,9 -> 1,2,3,4,6,7,8,9 -> Result 8
 * 4,17 -> 4,6,7,8,9,10,11,12,13,14,16,17 -> Result 12
 * The result may contain fives. ;-)
 * The start number will always be smaller than the end number. Both numbers can be also negative!
 * Created by hewj on 17/6/15.
 */
public class DoNotGiveMeFiveTest {

    @Test
    public void testNoFive() throws Exception {
        assertEquals("OH OH OH", 8, DoNotGiveMeFive.noFive(1, 9));
        assertEquals("OH OH OH", 12, DoNotGiveMeFive.noFive(4, 17));
        assertEquals("OH OH OH", 15, DoNotGiveMeFive.noFive(-6, 10));
        assertEquals("OH OH OH", 12, DoNotGiveMeFive.noFive(-17, -4));
    }
}