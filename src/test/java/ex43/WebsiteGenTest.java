package ex43;

import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WebsiteGenTest extends TestCase {

    public void testIndexGen() throws IOException {
        String path = "src/test/java/ex03";
        String name = "WebsiteTitle";
        String author = "Jeremy Rosales";

        File file2 = WebsiteGen.indexGen(path, name, author);
        BufferedReader reader1 = new BufferedReader(new FileReader("src/test/java/ex03/test.html"));
        BufferedReader reader2 = new BufferedReader((new FileReader(file2)));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        boolean x = line1.equals(line2);
        assertTrue(x);
    }
}