package codewars.kyu6.test;

import codewars.kyu6.CountingDuplicates;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/6/15.
 */
public class CountingDuplicatesTest {

    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("indivisibility"));
    }
}