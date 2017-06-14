package codewars.kyu6.test;

import codewars.kyu6.Persist;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/6/14.
 */
public class PersistTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, Persist.persistence(39));
        assertEquals(0, Persist.persistence(4));
        assertEquals(2, Persist.persistence(25));
        assertEquals(4, Persist.persistence(999));
    }
}