import java.util.ArrayList;

public class LinkedListWithDummyNode
{
    private final DummyNode dummy;
    int size;

    public LinkedListWithDummyNode()
    {
        this.dummy = new DummyNode();
        this.dummy.prev = this.dummy;
        this.dummy.next = this.dummy;
        size = 0;
    }

    public void addInTail(Node _item)
    {
        dummy.prev.next = _item;
        _item.prev = this.dummy.prev;
        _item.next = this.dummy;
        this.dummy.prev = _item;
        this.size ++;
    }

    public Node find(int _value)
    {
        Node node = this.dummy.next;
        while(!(node instanceof DummyNode)) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.dummy.next;
        while(!(node instanceof DummyNode)) {
            if(node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.dummy.next;
        while(!(node instanceof DummyNode)) {
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
        Node node = this.dummy.next;
        while(!(node instanceof DummyNode)) {
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
        this.dummy.prev = this.dummy;
        this.dummy.next = this.dummy;
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
            this.dummy.next.prev = _nodeToInsert;
            _nodeToInsert.next = this.dummy.next;
            this.dummy.next = _nodeToInsert;
            _nodeToInsert.prev = this.dummy;
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