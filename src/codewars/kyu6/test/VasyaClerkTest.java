package codewars.kyu6.test;

import codewars.kyu6.VasyaClerk;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/6/15.
 */
public class VasyaClerkTest {

    @Test
    public void test1() {
        assertEquals("YES", VasyaClerk.Tickets(new int[] {25, 25, 50}));
    }
    @Test
    public void test2() {
        assertEquals("NO", VasyaClerk.Tickets(new int []{25, 100}));
    }
    @Test
    public void test3() {
        assertEquals("NO", VasyaClerk.Tickets(new int[] {25, 50, 50}));
    }
}