import java.util.ArrayList;

public class LinkedListWithDummyNode
{
    private final DummyNode dummyHead;
    private final DummyNode dummyTail;
    int size;

    public LinkedListWithDummyNode()
    {
        dummyHead = new DummyNode();
        dummyTail = new DummyNode();
        dummyTail.prev = dummyHead;
        size = 0;
    }

    public void addInTail(Node _item)
    {
        dummyTail.prev.next = _item;
        _item.prev = this.dummyTail.prev;
        _item.next = this.dummyTail;
        this.dummyTail.prev = _item;
        this.size ++;
    }

    public Node find(int _value)
    {
        Node node = this.dummyHead.next;
        while (node != null && node != this.dummyTail) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.dummyHead.next;
        while(node != null && node != this.dummyTail) {
            if(node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.dummyHead.next;
        while(node != null && node != this.dummyTail) {
            if(node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                this.size --;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.dummyHead.next;
        while(node != null && node != this.dummyTail) {
            if(node.value == _value) {
                node.next.prev = node.prev;
                node.prev.next = node.next;
                this.size --;
            }
            node = node.next;
        }
    }

    public void clear()
    {
        this.dummyHead.next = null;
        this.dummyTail.prev = null;
        this.size = 0;
    }

    public int count()
    {
        return this.size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if(_nodeAfter == null && size == 0) {
            addInTail(_nodeToInsert);
            return;
        }
        if(_nodeAfter == null) {
            this.dummyHead.next.prev = _nodeToInsert;
            _nodeToInsert.next = this.dummyHead.next;
            this.dummyHead.next = _nodeToInsert;
            _nodeToInsert.prev = this.dummyHead;
            this.size ++;
            return;
        }

        _nodeAfter.next.prev = _nodeToInsert;
        _nodeToInsert.next = _nodeAfter.next;
        _nodeToInsert.prev = _nodeAfter;
        _nodeAfter.next = _nodeToInsert;
        this.size ++;
    }

}

class DummyNode extends Node
{
    private static final int _valueDummyNode = 0;

    public DummyNode() {
        super(_valueDummyNode);
    }
}