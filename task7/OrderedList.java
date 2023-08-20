import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;
    private int size;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
        size = 0;
    }

    public int compare(T v1, T v2)
    {
        if(v1 instanceof  String) {
            String trim1 =  ((String) v1).trim();
            String trim2 =  ((String) v2).trim();

            int resOfCompare = trim1.compareTo(trim2);
            return Integer.compare(resOfCompare, 0);
        }

        int n1 = (int) v1;
        int n2 = (int) v2;
        if(n1 < n2) {
            return -1;
        }
        if(n1 > n2) {
            return 1;
        }

        return 0;
    }

    public void add(T value)
    {
        Node<T> nodeToAdd = new Node<>(value);
        if(this.head == null) {
            addInTail(nodeToAdd);
            return;
        }

        int compareWithHead = compare(value, this.head.value);

        if(_ascending && (compareWithHead == 0 || compareWithHead == -1)) {
            addInHead(nodeToAdd);
            return;
        }

        if(!_ascending && (compareWithHead == 0 || compareWithHead == 1)) {
            addInHead(nodeToAdd);
            return;
        }

        int compareWithTail = compare(value, this.tail.value);

        if(_ascending && (compareWithTail == 0 || compareWithTail == 1)) {
            addInTail(nodeToAdd);
            return;
        }

        if(!_ascending && (compareWithTail == 0 || compareWithTail == -1)) {
            addInTail(nodeToAdd);
            return;
        }

        if(_ascending) {
            addAscending(nodeToAdd);
            return;
        }

        addDescending(nodeToAdd);
    }

    public Node<T> find(T val)
    {
        if(this.size == 0) {
            return null;
        }

        int compareWithHead = compare(val, this.head.value);
        int compareWithTail = compare(val, this.tail.value);

        if(_ascending && (compareWithHead == -1 || compareWithTail == 1)) {
            return null;
        }

        if(!_ascending && (compareWithHead == 1 || compareWithTail == -1)) {
            return null;
        }

        Node node = this.head;

        while(node != null) {
            int compareWithCurNode = compare(val, (T) node.value);

            if(compareWithCurNode == 0) {
                return node;
            }

            if(_ascending && compareWithCurNode == -1) {
                return null;
            }

            if(!_ascending && compareWithCurNode == 1) {
                return null;
            }

            node = node.next;
        }
        return  null;
    }

    public void delete(T val)
    {
        Node node = this.head;
        while(node != null) {
            if(node.value == val && this.count() == 1) {
                clear(this._ascending);
                return;
            }

            if(node.value == val && node.prev == null) {
                this.head = node.next;
                this.head.prev = null;
                node.next = null;
                this.size --;
                return;
            }

            if(node.value == val && node.next == null) {
                this.tail = node.prev;
                node.prev.next = node.next;
                node.prev = null;
                this.size --;
                return;
            }

            if(node.value == val) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                node.next = null;
                node.prev = null;
                this.size --;
                return;
            }

            node = node.next;
        }
    }

    public void clear(boolean asc)
    {
        this._ascending = asc;
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int count()
    {
        return this.size;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    private void addInHead(Node<T> _item)
    {
        if (head == null) {
            addInTail(_item);
        } else {
            _item.next = this.head;
            this.head.prev = _item;
            this.head = _item;
            this.head.prev = null;
            this.size ++;
        }
    }

    private void addInTail(Node<T> _item)
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

    private void addAscending(Node<T> nodeToAdd) {
        Node node = this.head.next;
        while (node != null) {
            int compareWithCurNode = compare(nodeToAdd.value, (T) node.value);
            if(compareWithCurNode == -1) {
                nodeToAdd.next = node;
                nodeToAdd.prev = node.prev;
                node.prev.next = nodeToAdd;
                node.prev = nodeToAdd;
                this.size ++;
                return;
            }
            node = node.next;
        }
    }

    private void addDescending(Node<T> nodeToAdd) {
        Node node = this.head.next;
        while (node != null) {
            int compareWithCurNode = compare(nodeToAdd.value, (T) node.value);
            if(compareWithCurNode == 1) {
                nodeToAdd.next = node;
                nodeToAdd.prev = node.prev;
                node.prev.next = nodeToAdd;
                node.prev = nodeToAdd;
                this.size ++;
                return;
            }
            node = node.next;
        }
    }
}