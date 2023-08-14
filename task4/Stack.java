import java.util.*;

public class Stack<T>
{
    ArrayList<T> array;

    public Stack()
    {
        this.array = new ArrayList<>();
    }

    public int size()
    {
        return this.array.size();
    }

    public T pop()
    {
        if(this.array.size() == 0) {
            return null;
        }

        return this.array.remove(this.array.size() - 1);
    }

    public void push(T val)
    {
        this.array.add(val);
    }

    public T peek()
    {
        if(this.array.size() == 0) {
            return null;
        }

        return this.array.get(this.array.size() - 1);
    }
}
