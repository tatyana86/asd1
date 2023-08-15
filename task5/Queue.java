import java.util.*;

public class Queue<T>
{
    ArrayList<T> array;

    public Queue()
    {
        this.array = new ArrayList<>();
    }

    public void enqueue(T item)
    {
        this.array.add(item);
    }

    public T dequeue()
    {
        if(size() == 0) {
            return null;
        }

        return this.array.remove(0);
    }

    public int size()
    {
        return this.array.size();
    }

}