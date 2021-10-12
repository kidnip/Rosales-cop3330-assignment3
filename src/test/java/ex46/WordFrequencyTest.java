package ex46;

import junit.framework.TestCase;

import java.util.HashMap;

public class WordFrequencyTest extends TestCase {

    public void testGetFrequencies() {
        String[] test1 = {"dog", "dog", "dog"};
        HashMap<String, Integer> testMap1 = new HashMap<>();
        testMap1.put("dog", 3);

        HashMap<String, Integer> testMap2 = WordFrequency.getFrequencies(test1);
        int x = testMap1.get("dog");
        int y = testMap2.get("dog");
        assertEquals(x, y);
    }
}