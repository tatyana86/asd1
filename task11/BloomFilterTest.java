import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    BloomFilter testFilter = new BloomFilter(10);

    @Test
    void isValue() {
        testFilter.add("0123456789");
        testFilter.add("1234567890");
        testFilter.add("2345678901");
        testFilter.add("3456789012");
        testFilter.add("4567890123");
        testFilter.add("5678901234");
        testFilter.add("6789012345");
        testFilter.add("7890123456");
        testFilter.add("8901234567");
        testFilter.add("9012345678");

        assertTrue(testFilter.isValue("0123456789"));
        assertTrue(testFilter.isValue("0123456789"));
        assertTrue(testFilter.isValue("2345678901"));
        assertTrue(testFilter.isValue("3456789012"));
        assertTrue(testFilter.isValue("4567890123"));
        assertTrue(testFilter.isValue("5678901234"));
        assertTrue(testFilter.isValue("6789012345"));
        assertTrue(testFilter.isValue("7890123456"));
        assertTrue(testFilter.isValue("8901234567"));
        assertTrue(testFilter.isValue("9012345678"));

        assertFalse(testFilter.isValue("123456789"));
    }

}