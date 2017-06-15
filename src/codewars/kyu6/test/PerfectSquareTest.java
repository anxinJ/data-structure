package codewars.kyu6.test;

import codewars.kyu6.PerfectSquare;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/6/14.
 */
public class PerfectSquareTest {

    @Test
    public void shouldWorkForSomeExamples() throws Exception {
        assertEquals("negative numbers aren't square numbers", false, PerfectSquare.isSquare(-1));
        assertEquals("3 isn't a square number", false,  PerfectSquare.isSquare(3));
        assertEquals("4 is a square number",    true,   PerfectSquare.isSquare(4));
        assertEquals("25 is a square number",   true,   PerfectSquare.isSquare(25));
        assertEquals("26 isn't a square number",false,  PerfectSquare.isSquare(26));
    }
    @Test
    public void shouldWorkForRandomSquareNumbers() throws Exception {
        Random rand = new Random();
        for(int i = 0; i < 100; ++i){
            int randomNum = rand.nextInt(0x0fff);
            int randomSq = randomNum * randomNum;
            assertEquals(String.format("%d is a square number", randomSq), true, PerfectSquare.isSquare(randomSq));
        }
    }
}