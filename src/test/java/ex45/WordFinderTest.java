package ex45;

import junit.framework.TestCase;

import java.util.Arrays;

public class WordFinderTest extends TestCase {

    public void testReplaceFile() {
        String test1 = "orange orange orange";
        byte[] byteTest1 = test1.getBytes();

        byte[] byteTest2 = WordFinder.replaceFile("src/test/java/ex45/text.txt", "apple", "orange");
        boolean x = Arrays.equals(byteTest1, byteTest2);
        assertTrue(x);
    }
}