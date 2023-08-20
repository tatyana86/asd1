import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderedListTest {
    OrderedList<Integer> emptyListAsc = new OrderedList<>(true);
    OrderedList<Integer> emptyListDesc = new OrderedList<>(false);

    OrderedList<Integer> listAsc = new OrderedList<>(true);
    OrderedList<Integer> listDesc = new OrderedList<>(false);

    @Test
    void addInEmptyAscList() {
        assertNull(emptyListAsc.head);
        assertNull(emptyListAsc.tail);
        assertEquals(0, emptyListAsc.count());

        emptyListAsc.add(10);

        assertEquals(10, emptyListAsc.head.value);
        assertEquals(10, emptyListAsc.tail.value);
        assertEquals(1, emptyListAsc.count());

        emptyListAsc.add(5);

        assertEquals(5, emptyListAsc.head.value);
        assertEquals(10, emptyListAsc.tail.value);
        assertEquals(2, emptyListAsc.count());

        emptyListAsc.add(15);

        assertEquals(5, emptyListAsc.head.value);
        assertEquals(15, emptyListAsc.tail.value);
        assertEquals(3, emptyListAsc.count());

        emptyListAsc.add(14);

        assertEquals(5, emptyListAsc.head.value);
        assertEquals(15, emptyListAsc.tail.value);
        assertEquals(4, emptyListAsc.count());

        emptyListAsc.add(1);

        assertEquals(1, emptyListAsc.head.value);
        assertEquals(15, emptyListAsc.tail.value);
        assertEquals(5, emptyListAsc.count());

        emptyListAsc.add(20);

        assertEquals(1, emptyListAsc.head.value);
        assertEquals(20, emptyListAsc.tail.value);
        assertEquals(6, emptyListAsc.count());
    }

    @Test
    void addInEmptyDescList() {
        assertNull(emptyListDesc.head);
        assertNull(emptyListDesc.tail);
        assertEquals(0, emptyListDesc.count());

        emptyListDesc.add(10);

        assertEquals(10, emptyListDesc.head.value);
        assertEquals(10, emptyListDesc.tail.value);
        assertEquals(1, emptyListDesc.count());

        emptyListDesc.add(5);

        assertEquals(10, emptyListDesc.head.value);
        assertEquals(5, emptyListDesc.tail.value);
        assertEquals(2, emptyListDesc.count());

        emptyListDesc.add(15);

        assertEquals(15, emptyListDesc.head.value);
        assertEquals(5, emptyListDesc.tail.value);
        assertEquals(3, emptyListDesc.count());

        emptyListDesc.add(14);

        assertEquals(15, emptyListDesc.head.value);
        assertEquals(5, emptyListDesc.tail.value);
        assertEquals(4, emptyListDesc.count());

        emptyListDesc.add(1);

        assertEquals(15, emptyListDesc.head.value);
        assertEquals(1, emptyListDesc.tail.value);
        assertEquals(5, emptyListDesc.count());

        emptyListDesc.add(19);

        assertEquals(19, emptyListDesc.head.value);
        assertEquals(1, emptyListDesc.tail.value);
        assertEquals(6, emptyListDesc.count());
    }

    @Test
    void findInEmptyList() {

        assertNull(emptyListAsc.find(5));
        assertNull(emptyListDesc.find(5));

    }

    @Test
    void findInAscList() {
        listAsc.add(10);
        listAsc.add(5);
        listAsc.add(15);
        listAsc.add(14);

        assertEquals(14, listAsc.find(14).value);
        assertEquals(10, listAsc.find(10).value);
        assertEquals(15, listAsc.find(15).value);
        assertEquals(5, listAsc.find(5).value);
        assertEquals(null, listAsc.find(7));
    }

    @Test
    void findInDescList() {
        listDesc.add(10);
        listDesc.add(5);
        listDesc.add(15);
        listDesc.add(14);

        assertEquals(14, listDesc.find(14).value);
        assertEquals(10, listDesc.find(10).value);
        assertEquals(15, listDesc.find(15).value);
        assertEquals(5, listDesc.find(5).value);
        assertEquals(null, listDesc.find(7));
    }

    @Test
    void delInAscList() {
        listAsc.add(10);
        listAsc.add(5);
        listAsc.add(15);
        listAsc.add(14);

        listAsc.delete(0);
        assertEquals(4, listAsc.count());

        listAsc.delete(5);
        assertEquals(3, listAsc.count());
        assertEquals(10, listAsc.head.value);
        assertEquals(14, listAsc.head.next.value);

        listAsc.delete(15);
        assertEquals(2, listAsc.count());
        assertEquals(14, listAsc.tail.value);
        assertEquals(14, listAsc.head.next.value);

        listAsc.delete(14);
        assertEquals(1, listAsc.count());
        assertEquals(10, listAsc.tail.value);
        assertEquals(10, listAsc.head.value);

        listAsc.delete(10);
        assertEquals(0, listAsc.count());
        assertNull(listAsc.tail);
        assertNull(listAsc.head);
    }

    @Test
    void delInDescList() {
        listDesc.add(10);
        listDesc.add(5);
        listDesc.add(15);
        listDesc.add(14);

        listDesc.delete(0);
        assertEquals(4, listDesc.count());

        listDesc.delete(5);
        assertEquals(3, listDesc.count());
        assertEquals(10, listDesc.tail.value);
        assertEquals(14, listDesc.tail.prev.value);

        listDesc.delete(15);
        assertEquals(2, listDesc.count());
        assertEquals(14, listDesc.head.value);
        assertEquals(10, listDesc.head.next.value);

        listDesc.delete(14);
        assertEquals(1, listDesc.count());
        assertEquals(10, listDesc.tail.value);
        assertEquals(10, listDesc.head.value);

        listDesc.delete(10);
        assertEquals(0, listDesc.count());
        assertNull(listDesc.tail);
        assertNull(listDesc.head);
    }
    
}
