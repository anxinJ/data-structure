package codewars.kyu6.test;

import codewars.kyu6.DigitalRoot;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/6/15.
 */
public class DigitalRootTest {

    @Test
    public void Tests() {
        assertEquals( "Nope!" , DigitalRoot.digital_root(168), 6);
    }

    @Test
    public void Test1s() {
        assertEquals( "Nope!" , DigitalRoot.cleverest(168), 6);
    }
}