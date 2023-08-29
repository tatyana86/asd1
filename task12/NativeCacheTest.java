import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {

    NativeCache<Integer> cache = new NativeCache<>(5, Integer.class);

    @Test
    void checkPut() {
        cache.put("book", 5);
        assertEquals(5, cache.get("book"));
        cache.put("book", 7);
        assertEquals(7, cache.get("book"));
    }

    @Test
    void checkIsKey() {
        assertFalse(cache.isKey("book"));
        cache.put("book", 5);
        assertTrue(cache.isKey("book"));
    }

    @Test
    void checkGet() {
        assertNull(cache.get(null));
        assertNull(cache.get("book"));
        cache.put("book", 5);
        assertEquals(5, cache.get("book"));
    }

    @Test
    void checkAutoDeleteItem() {
        cache.put("a", 10);
        cache.put("b", 20);
        cache.put("c", 30);
        cache.put("d", 40);
        cache.put("e", 50);

        assertTrue(cache.isKey("a"));
        assertTrue(cache.isKey("c"));
        assertTrue(cache.isKey("d"));
        assertTrue(cache.isKey("e"));
        cache.put("f", 60);
        assertFalse(cache.isKey("b"));
        assertTrue(cache.isKey("f"));

        for(int i = 0; i < cache.hits.length; i ++) {
            assertEquals(1, cache.hits[i]);
        }
    }

    @Test
    void checkCorrectHits() {
        cache.put("a", 10);
        cache.put("b", 20);
        cache.put("c", 30);
        cache.put("d", 40);
        cache.put("e", 50);

        assertTrue(cache.isKey("a"));
        assertTrue(cache.isKey("a"));
        cache.put("a", 100);

        cache.put("b", 10000);

        assertTrue(cache.isKey("c"));
        cache.put("c", 200);
        cache.put("c", 300);

        assertTrue(cache.isKey("d"));
        assertEquals(40, cache.get("d"));
        cache.put("d", 300);

        assertTrue(cache.isKey("e"));
        assertTrue(cache.isKey("e"));
        assertTrue(cache.isKey("e"));

        cache.put("f", 60);
        assertFalse(cache.isKey("b"));

        assertTrue(cache.isKey("f"));
        assertTrue(cache.isKey("f"));
        assertTrue(cache.isKey("f"));

        for(int i = 0; i < cache.hits.length; i ++) {
            assertEquals(3, cache.hits[i]);
        }
    }
}