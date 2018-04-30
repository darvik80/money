package xyz.crearts.money;

import junit.framework.TestCase;

public class SimpleTest extends TestCase {
    protected int value1, value2;

    protected void setUp(){
        value1 = 3;
        value2 = 3;
    }

    public void testFailed() {
        double result = value1 + value2;
        assertTrue(result == 6);
    }
}
