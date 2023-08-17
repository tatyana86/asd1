import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    Deque<Integer> deque = new Deque<>();
    Deque<Integer> empty = new Deque<>();


    @BeforeEach
    void generateTestData() {
        for(int i = 0; i < 10; i ++) {
            deque.addTail(i);
        }
    }

    @Test
    public void addAndRemoveTail() {
        deque.addTail(15);
        assertEquals(11, deque.size());
        assertEquals(15, deque.removeTail());
        assertEquals(10, deque.size());
    }

    @Test
    public void addAndRemoveFront() {
        deque.addFront(15);
        assertEquals(11, deque.size());
        assertEquals(15, deque.removeFront());
        assertEquals(10, deque.size());
    }

    @Test
    public void removeAndAddTailInEmpty() {
        assertEquals(0, empty.size());
        assertNull(empty.removeTail());

        empty.addTail(15);
        assertEquals(1, empty.size());
        assertEquals(15, empty.removeTail());
        assertEquals(0, empty.size());
    }

    @Test
    public void removeAndAddFrontInEmpty() {
        assertEquals(0, empty.size());
        assertNull(empty.removeFront());

        empty.addFront(15);
        assertEquals(1, empty.size());
        assertEquals(15, empty.removeFront());
        assertEquals(0, empty.size());
    }


}