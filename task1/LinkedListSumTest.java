import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListSumTest {

    @Test
    public void findAllInOneSizeList() {

        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.addInTail(new Node(1));
        l1.addInTail(new Node(1));
        l1.addInTail(new Node(5));

        l2.addInTail(new Node(2));
        l2.addInTail(new Node(3));
        l2.addInTail(new Node(6));

        assertEquals(Arrays.asList(3, 4, 11), LinkedListSum.sumOfEqualLinkedList(l1, l2));

    }

    @Test
    public void findAllInDifSizeList() {

        LinkedList l1 = new LinkedList();
        LinkedList l2 = new LinkedList();

        l1.addInTail(new Node(1));
        l1.addInTail(new Node(1));
        l1.addInTail(new Node(5));

        l2.addInTail(new Node(2));
        l2.addInTail(new Node(3));
        l2.addInTail(new Node(6));
        l2.addInTail(new Node(6));

        assertEquals(Arrays.asList(), LinkedListSum.sumOfEqualLinkedList(l1, l2));

    }

}