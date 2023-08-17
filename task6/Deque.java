import java.util.*;

public class Deque<T>
{
    ArrayList<T> array;

    public Deque()
    {
        this.array = new ArrayList<>();
    }

    public void addFront(T item)
    {
        this.array.add(0, item);
    }

    public void addTail(T item)
    {
        this.array.add(item);
    }

    public T removeFront()
    {
        if(size() == 0) {
            return null;
        }

        return this.array.remove(0);
    }

    public T removeTail()
    {
        if(size() == 0) {
            return null;
        }

        return this.array.remove(this.array.size() - 1);
    }

    public int size()
    {
        return this.array.size();
    }
}