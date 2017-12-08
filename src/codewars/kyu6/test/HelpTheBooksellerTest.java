package codewars.kyu6.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import codewars.kyu6.HelpTheBookseller;

public class HelpTheBooksellerTest {
	
	@Test
	public void test1() { 
		String art[] = new String[]{"ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600"};
    		String cd[] = new String[] {"A", "B"};
    		assertEquals("(A : 200) - (B : 1140)",
    				HelpTheBookseller.stockSummary(art, cd));
	}
}
