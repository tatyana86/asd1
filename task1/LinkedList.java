import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    int size;

    public LinkedList()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        size ++;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while(node != null) {
            if(node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }

        return nodes;
    }

    public boolean remove(int _value)
    {
        Node node = this.head;
        Node lastNode = null;
        while(node != null) {
            if(node.value == _value && lastNode == null) {
                this.head = node.next;
                node.next = null;
                size --;
                return true;
            }

            if(node.value == _value && node.next == null) {
                tail = lastNode;
            }

            if(node.value == _value) {
                lastNode.next = node.next;
                node.next = null;
                size --;
                return true;
            }

            lastNode = node;
            node = node.next;
        }

        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        Node lastNode = null;
        while(node != null) {
            if(node.value == _value && lastNode == null) {
                this.head = node.next;
                node.next = null;
                node = this.head;
                size --;
                continue;
            }

            if(node.value == _value && node.next == null) {
                this.tail = lastNode;
            }

            if(node.value == _value) {
                lastNode.next = node.next;
                node.next = null;
                size --;
            }

            if(node.value != _value) {
                lastNode = node;
            }

            node = lastNode.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
    }

    public int count()
    {
        return this.size;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if(_nodeAfter == null && size == 0) {
            this.tail = _nodeToInsert;
        }
        if(_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
            size ++;
            return;
        }

        if(size == 0) {
            return;
        }

        Node node = this.head;
        while(node != null) {
            if(node == _nodeAfter && node == tail) {
                this.tail = _nodeToInsert;
            }

            if(node == _nodeAfter) {
                _nodeToInsert.next = _nodeAfter.next;
                node.next = _nodeToInsert;
                size ++;
                return;
            }
            node = node.next;
        }
    }
}

class Node
{
    public int value;
    public Node next;
    public Node(int _value)
    {
        value = _value;
        next = null;
    }
}
