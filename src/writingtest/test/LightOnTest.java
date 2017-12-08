package writingtest.test;

import org.junit.Assert;
import org.junit.Test;
import writingtest.LightOn;

import static org.junit.Assert.*;

/**
 * Created by hewj on 17/9/25.
 */
public class LightOnTest {

    @Test
    public void testLightOnNum() throws Exception {
        Assert.assertEquals(44, LightOn.lightOnNum(2015));
    }
}