package codewars.kyu6.test;

import codewars.kyu6.ShortestWord;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/6/14.
 */
public class ShortestWordTest {

    @Test
    public void findShort() throws Exception {
        assertEquals(3, ShortestWord.findShort("bitcoin take over the world maybe who knows perhaps"));
        assertEquals(3, ShortestWord.findShort("turns out random test cases are easier than writing out basic ones"));
    }
}