import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    int size;

    public LinkedList2()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        this.size ++;
    }

    public Node find(int _value)
    {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
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
       while(node != null) {
           if(node.value == _value && this.count() == 1) {
               clear();
               return true;
           }

           if(node.value == _value && node.prev == null) {
               this.head = node.next;
               this.head.prev = null;
               node.next = null;
               this.size --;
               return true;
           }

           if(node.value == _value && node.next == null) {
               this.tail = node.prev;
           }

           if(node.value == _value) {

               node.prev.next = node.next;
               node.next.prev = node.prev;
               node.next = null;
               node.prev = null;
               this.size --;
               return true;
           }

           node = node.next;
       }
        return false;
    }

    public void removeAll(int _value)
    {
        Node node = this.head;
        while(node != null) {
            if (node.value == _value && this.count() == 1) {
                clear();
                return;
            }

            if(node.value == _value && node.prev == null) {
                this.head = node.next;
                this.head.prev = null;
                node.next = null;
                node = this.head;
                this.size --;
                continue;
            }

            if(node.value == _value && node.next == null) {
                this.tail = node.prev;
                node.prev.next = node.next;
                node.prev = null;
                this.size --;
                return;
            }

            if(node.value == _value) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                this.size --;
            }

            node = node.next;
        }
    }

    public void clear()
    {
        this.head = null;
        this.tail = null;
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
            _nodeToInsert.next = this.head;
            _nodeToInsert.prev = null;
            this.head.prev = _nodeToInsert;
            this.head = _nodeToInsert;
            this.size ++;
            return;
        }

        /*if(this.size == 0) {
            return;
        }*/

        Node node = this.head;
        while(node != null) {
            if(node == _nodeAfter && node == tail) {
                this.tail = _nodeToInsert;
                _nodeToInsert.next = _nodeAfter.next;
                _nodeToInsert.prev = node;
                node.next = _nodeToInsert;
                this.size ++;
                return;
            }

            if(node == _nodeAfter) {
                _nodeToInsert.next = _nodeAfter.next;
                _nodeToInsert.prev = node;
                node.next.prev = _nodeToInsert;
                node.next = _nodeToInsert;
                this.size ++;
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
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}