import java.util.*;

public class StackReverce<T> {

    ArrayList<T> array;

    public StackReverce()
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

        return this.array.remove(0);
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

        return this.array.get(0);
    }

}
