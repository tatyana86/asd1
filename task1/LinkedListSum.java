import java.util.ArrayList;

public class LinkedListSum {
    public static ArrayList<Integer> sumOfEqualLinkedList(LinkedList list1, LinkedList list2) {
        ArrayList<Integer> sumOfLL = new ArrayList<>();

        if(list1.count() != list2.count()) {
            return sumOfLL;
        }

        Node node1 = list1.head;
        Node node2 = list2.head;

        while(node1 != null) {
            sumOfLL.add(node1.value + node2.value);
            node1 = node1.next;
            node2 = node2.next;
        }

        return sumOfLL;
    }
}
