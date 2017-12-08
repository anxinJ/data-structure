package codewars.kyu6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codewars.kyu6.DigitPow;

public class DigitPowTest {
	
	@Test
	public void Test1() {
		assertEquals(1, DigitPow.digitPow(89, 1));
	}
	@Test
	public void Test2() {
		assertEquals(-1, DigitPow.digitPow(92, 1));
	}
	@Test
	public void Test3() {
		assertEquals(51, DigitPow.digitPow(46288, 3));
	}
}
