import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NativeDictionaryTest {

    NativeDictionary<Integer> dict = new NativeDictionary<>(17, Integer.class);

    @Test
    void checkPut() {
        dict.put("book", 5);
        assertEquals(5, dict.get("book"));
        dict.put("book", 7);
        assertEquals(7, dict.get("book"));
    }

    @Test
    void checkIsKey() {
        assertFalse(dict.isKey("book"));
        dict.put("book", 5);
        assertTrue(dict.isKey("book"));
    }

    @Test
    void checkGet() {
        assertNull(dict.get(null));
        assertNull(dict.get("book"));
        dict.put("book", 5);
        assertEquals(5, dict.get("book"));
    }

}