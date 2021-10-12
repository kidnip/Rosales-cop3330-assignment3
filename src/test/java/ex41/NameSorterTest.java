package ex41;

import junit.framework.TestCase;

import java.util.Arrays;

public class NameSorterTest extends TestCase {

    public void testSort() {
        String[] test1Names = {"Jeremy", "Andrew", "Rosales"};
        String[] test2Names = {"Andrew", "Jeremy", "Rosales"};
        int n = 3;

        String[] result = NameSorter.sort(test1Names, n);
        boolean x = Arrays.equals(result, test2Names);
        assertTrue(x);
    }
}