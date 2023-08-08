import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    LinkedList2 emptyList = new LinkedList2();
    LinkedList2 notEmptyList = new LinkedList2();

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
        assertEquals(null, notEmptyList.head.prev);
        assertEquals(7, notEmptyList.tail.prev.value);

    }

    @Test
    public void removeOneTail() {

        assertTrue(notEmptyList.remove(7));
        assertEquals(7, notEmptyList.tail.value);
        assertEquals(7, notEmptyList.count());
        assertEquals(6, notEmptyList.tail.prev.value);

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
        assertEquals(null, emptyList.head);
        assertEquals(null, emptyList.tail);

    }

    @Test
    public void removeExistElemFromOneSizeList() {

        emptyList.addInTail(new Node(1));

        assertTrue(emptyList.remove(1));
        assertEquals(0, emptyList.count());
        assertEquals(null, emptyList.head);
        assertEquals(null, emptyList.tail);

    }

    @Test
    public void removeExistElemFromTwoSizeList() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(2));

        assertTrue(emptyList.remove(1));
        assertEquals(1, emptyList.count());
        assertEquals(2, emptyList.head.value);
        assertEquals(2, emptyList.tail.value);
        assertEquals(null, emptyList.head.prev);
        assertEquals(null, emptyList.head.next);
        assertEquals(null, emptyList.tail.prev);
        assertEquals(null, emptyList.tail.next);

    }

    @Test
    public void removeExistElemFromThreeSizeList() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(2));
        emptyList.addInTail(new Node(3));

        assertTrue(emptyList.remove(2));
        assertEquals(2, emptyList.count());
        assertEquals(3, emptyList.head.next.value);
        assertEquals(1, emptyList.tail.prev.value);

    }

    @Test
    public void removeAllFromEmptyList1() {

        emptyList.removeAll(1);
        assertEquals(0, emptyList.count());
        assertEquals(null, emptyList.head);
        assertEquals(null, emptyList.tail);

    }

    @Test
    public void removeAllFromOneSizeList1() {

        emptyList.addInTail(new Node(1));

        emptyList.removeAll(1);
        assertEquals(0, emptyList.count());
        assertEquals(null, emptyList.head);
        assertEquals(null, emptyList.tail);

    }

    @Test
    public void removeAllFromTwoSizeList1() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(1));

        emptyList.removeAll(1);
        assertEquals(0, emptyList.count());
        assertEquals(null, emptyList.head);
        assertEquals(null, emptyList.tail);

    }

    @Test
    public void removeAllFromThreeSizeList1() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(2));

        emptyList.removeAll(1);
        assertEquals(1, emptyList.count());
        assertEquals(2, emptyList.head.value);
        assertEquals(2, emptyList.tail.value);
        assertEquals(null, emptyList.head.prev);
        assertEquals(null, emptyList.head.next);
        assertEquals(null, emptyList.tail.prev);
        assertEquals(null, emptyList.tail.next);

    }

    @Test
    public void removeAllFromThreeSizeList2() {

        emptyList.addInTail(new Node(1));
        emptyList.addInTail(new Node(2));
        emptyList.addInTail(new Node(1));

        emptyList.removeAll(1);
        assertEquals(1, emptyList.count());
        assertEquals(2, emptyList.head.value);
        assertEquals(2, emptyList.tail.value);
        assertEquals(null, emptyList.head.prev);
        assertEquals(null, emptyList.head.next);
        assertEquals(null, emptyList.tail.prev);
        assertEquals(null, emptyList.tail.next);

    }

    @Test
    public void findMissing() {

        assertEquals(null, notEmptyList.find(100));

    }

    @Test
    public void findNode() {

        assertEquals(6, notEmptyList.find(7).prev.value);

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
    public void insertInEmptyListByFirst() {

        emptyList.insertAfter(null, new Node(10));
        assertEquals(1, emptyList.count());
        assertEquals(10, emptyList.head.value);
        assertEquals(10, emptyList.tail.value);

    }

    @Test
    public void insertInOneSizeListByFirst() {

        emptyList.addInTail(new Node(10));

        emptyList.insertAfter(null, new Node(20));
        assertEquals(2, emptyList.count());
        assertEquals(20, emptyList.head.value);
        assertEquals(10, emptyList.tail.value);
        assertEquals(10, emptyList.head.next.value);
        assertEquals(null, emptyList.head.prev);
        assertEquals(20, emptyList.tail.prev.value);

    }

    @Test
    public void insertInEmptyList() {

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
        assertEquals(10, emptyList.head.next.value);
        assertEquals(null, emptyList.head.prev);
        assertEquals(100, emptyList.tail.prev.value);
        assertEquals(null, emptyList.tail.next);

    }

    @Test
    public void assertInNotEmptyList() {

        Node node1 = notEmptyList.head;
        Node node2 = notEmptyList.tail;

        notEmptyList.insertAfter(node1, new Node(10));
        assertEquals(9, notEmptyList.count());
        assertEquals(1, notEmptyList.head.value);
        assertEquals(10, notEmptyList.head.next.value);
        assertEquals(1, notEmptyList.head.next.next.value);
        assertEquals(1, notEmptyList.head.next.prev.value);
        assertEquals(10, notEmptyList.head.next.next.prev.value);

        notEmptyList.insertAfter(node2, new Node(10));
        assertEquals(10, notEmptyList.count());
        assertEquals(10, notEmptyList.tail.value);
        assertEquals(null, notEmptyList.tail.next);
        assertEquals(7, notEmptyList.tail.prev.value);
        assertEquals(10, notEmptyList.tail.prev.next.value);

        notEmptyList.insertAfter(null, new Node(10));
        assertEquals(11, notEmptyList.count());
        assertEquals(10, notEmptyList.head.value);
        assertEquals(1, notEmptyList.head.next.value);
        assertEquals(10, notEmptyList.head.next.prev.value);

    }

}