package ex42;

import junit.framework.TestCase;

import java.util.Arrays;

public class DataParseTest extends TestCase {

    public void testParse() {
        String[][] testArray1 = {{"one", "two"},
                                {"three", "four"},
                                {"five", "six"}};
        String[] testArray2 = {"one,two", "three,four", "five,six"};
        int n = 3;

        String[][] result = DataParse.parse(testArray2, n);
        boolean x = Arrays.deepEquals(testArray1, result);
        assertTrue(x);
    }
}