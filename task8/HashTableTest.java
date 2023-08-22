import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    int size = 17;
    int step = 3;
    HashTable ht = new HashTable(size, step);

    @Test
    void hashFun() {
        String key = "check";
        char[] array = key.toCharArray();
        int slot = 0;

        for(int i = 0; i < key.length(); i ++) {
            slot += array[i];
        }

        assertEquals(slot % size, ht.hashFun("check"));
    }

    @Test
    void seekSlot() {
        String key1 = "check";
        int expectSlot1 = ht.seekSlot(key1);
        int slot1 = ht.put(key1);

        assertEquals(expectSlot1, slot1);

        int expectSlot2 = ht.seekSlot(key1);
        int slot2 = ht.put(key1);

        assertEquals(expectSlot2, slot2);
        assertEquals(slot1 + step, slot2);
    }

    @Test
    void seekSlotFail() {
        String key = "check";
        for(int i = 0; i < size; i ++) {
            ht.put(key);
        }

        assertEquals(-1, ht.put(key));
    }

    @Test
    void put() {
        String key = "check";
        assertNotEquals(-1, ht.put(key));
    }

    @Test
    void find() {
        String key = "check";

        assertEquals(-1, ht.find(key));

        int slot1 = ht.put(key);
        assertEquals(slot1, ht.find(key));

    }
}