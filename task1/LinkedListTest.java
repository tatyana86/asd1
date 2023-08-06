import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    LinkedList emptyList = new LinkedList();
    LinkedList notEmptyList = new LinkedList();

    @BeforeEach
    void fillList() {

        notEmptyList.addInTail(new Node(1));
        notEmptyList.addInTail(new Node(1));
        notEmptyList.addInTail(new Node(5));
        notEmptyList.addInTail(new Node(2));
        notEmptyList.addInTail(new Node(5));
        notEmptyList.addInTail(new Node(6));
        notEmptyList.addInTail(new Node(7));
        notEmptyList.addInTail(new Node(7));

    }

    @Test
    public void removeOneHead() {

        assertTrue(notEmptyList.remove(1));
        assertEquals(1, notEmptyList.head.value);
        assertEquals(7, notEmptyList.count());

    }

    @Test
    public void removeTwoHead() {

        notEmptyList.removeAll(1);
        assertEquals(5, notEmptyList.head.value);
        assertEquals(6, notEmptyList.count());

    }

    @Test
    public void removeOneMiddle() {

        assertTrue(notEmptyList.remove(5));
        assertEquals(7, notEmptyList.count());

    }

    @Test
    public void removeTwoMiddle() {

        notEmptyList.removeAll(5);
        assertEquals(6, notEmptyList.count());

    }

    @Test
    public void removeOneTail() {

        assertTrue(notEmptyList.remove(7));
        assertEquals(7, notEmptyList.tail.value);
        assertEquals(7, notEmptyList.count());

    }

    @Test
    public void removeTwoTail() {

        notEmptyList.removeAll(7);
        assertEquals(6, notEmptyList.tail.value);
        assertEquals(6, notEmptyList.count());

    }

    @Test
    public void removeMissing() {

        assertFalse(notEmptyList.remove(10));
        assertEquals(8, notEmptyList.count());

    }

    @Test
    public void removeFromEmpty() {

        assertFalse(emptyList.remove(10));
        assertEquals(0, emptyList.count());

    }

    @Test
    public void removeAllFromEmpty() {

        emptyList.removeAll(10);
        assertEquals(0, emptyList.count());

    }

    @Test
    public void removeMissingElemFromOneSizeList() {

        emptyList.addInTail(new Node(1));

        assertFalse(emptyList.remove(10));
        assertEquals(1, emptyList.count());
        assertEquals(1, emptyList.head.value);
        assertEquals(1, emptyList.tail.value);

    }

    @Test
    public void removeExistElemFromOneSizeList() {

        emptyList.addInTail(new Node(1));

        assertTrue(emptyList.remove(1));
        assertEquals(0, emptyList.count());

    }

    @Test
    public void removeAllMissingElemFromOneSizeList() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(2));

        emptyList.removeAll(10);
        assertEquals(2, emptyList.count());
        assertEquals(1, emptyList.head.value);
        assertEquals(2, emptyList.tail.value);

    }

    @Test
    public void removeAllExistElemFromOneSizeList() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(1));

        emptyList.removeAll(1);
        assertEquals(0, emptyList.count());

    }

    @Test
    public void findAllInOneSizeList() {

        emptyList.addInTail(new Node(1));

        assertEquals(1, emptyList.findAll(1).size());

    }

    @Test
    public void findAllInEmptyList() {

        assertEquals(0, emptyList.findAll(1).size());

    }

    @Test
    public void findAllInNotEmptyList() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(1));

        assertEquals(2, emptyList.findAll(1).size());
        assertEquals(0, emptyList.findAll(0).size());

    }

    @Test
    public void assertInEmptyListByFirst() {

        emptyList.insertAfter(null, new Node(10));
        assertEquals(1, emptyList.count());
        assertEquals(10, emptyList.head.value);
        assertEquals(10, emptyList.tail.value);

    }

    @Test
    public void assertInOneSizeListByFirst() {

        emptyList.addInTail(new Node(10));

        emptyList.insertAfter(null, new Node(20));
        assertEquals(2, emptyList.count());
        assertEquals(20, emptyList.head.value);
        assertEquals(10, emptyList.tail.value);

    }

    @Test
    public void assertInNotEmptyListByFirst() {

        emptyList.addInTail(new Node(10));
        emptyList.addInTail(new Node(20));
        emptyList.addInTail(new Node(30));

        emptyList.insertAfter(null, new Node(40));
        assertEquals(4, emptyList.count());
        assertEquals(40, emptyList.head.value);
        assertEquals(30, emptyList.tail.value);

    }

    @Test
    public void assertInEmptyList() {

        Node node1 = new Node(100);

        emptyList.insertAfter(node1, new Node(10));
        assertEquals(0, emptyList.count());

    }

    @Test
    public void assertNodeInOneSizeList() {

        Node node1 = new Node(100);
        emptyList.addInTail(node1);

        emptyList.insertAfter(node1, new Node(10));
        assertEquals(2, emptyList.count());
        assertEquals(100, emptyList.head.value);
        assertEquals(10, emptyList.tail.value);

    }

    @Test
    public void assertInNotEmptyList() {

        Node node1 = notEmptyList.head;
        Node node2 = notEmptyList.tail;

        notEmptyList.insertAfter(node1, new Node(10));
        assertEquals(9, notEmptyList.count());
        assertEquals(1, notEmptyList.head.value);
        assertEquals(7, notEmptyList.tail.value);

        notEmptyList.insertAfter(node2, new Node(10));
        assertEquals(10, notEmptyList.count());
        assertEquals(1, notEmptyList.head.value);
        assertEquals(10, notEmptyList.tail.value);

        notEmptyList.insertAfter(null, new Node(10));
        assertEquals(11, notEmptyList.count());
        assertEquals(10, notEmptyList.head.value);
        assertEquals(10, notEmptyList.tail.value);

    }

}