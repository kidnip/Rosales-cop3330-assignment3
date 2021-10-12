package ex44;

import junit.framework.TestCase;

public class ProductSearchTest extends TestCase {

    public void testParseFile() {
        Products[] test1 =
                {
                        new Products("Widget", 25.00f, 5)
                };
        Products[] test2 = ProductSearch.parseFile("src/test/java/ex44/test.json", "products");
        boolean x = test1[0].getName().equals(test2[0].getName())
        && test1[0].getPrice() == test2[0].getPrice()
                && test1[0].getQuantity() == test2[0].getQuantity();
        assertTrue(x);
    }
}