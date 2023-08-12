import java.lang.reflect.Array;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    private static final int minCapacity = 16;
    private static final double minFullness = 0.5;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; 

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        if(new_capacity < minCapacity) {
            this.capacity = minCapacity;
        }

        T [] tempArray = (T[]) Array.newInstance(this.clazz, new_capacity);

        if(this.count > 0) {
            System.arraycopy(array, 0, tempArray, 0, this.count);
        }

        this.array = tempArray;
        this.capacity = new_capacity;
    }

    public T getItem(int index)
    {
        isExistIndex(index);
        return array[index];
    }

    public void append(T itm)
    {
        if(this.count == this.capacity) {
            makeArray(2 * this.capacity);
        }
        array[this.count] = itm;
        this.count ++;
    }

    public void insert(T itm, int index)
    {
        isCorrectIndex(index);

        if(index == count) {
            append(itm);
			return;
        }

        if(this.count == this.capacity) {
            makeArray(2 * this.capacity);
        }

        System.arraycopy(this.array, index, this.array, index + 1, this.count - index);
        this.array[index] = itm;
        this.count ++;
    }

    public void remove(int index)
    {
        isExistIndex(index);
        System.arraycopy(this.array, index, this.array, index - 1, this.count - index);
        this.count --;

        if(this.count < (this.capacity * minFullness)) {
            makeArray((int) (this.capacity / 1.5));
        }
    }

    private void isExistIndex(int index) {
        if(index < 0 || index >= count) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index!");
        }
    }

    private void isCorrectIndex(int index) {
        if(index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException("Incorrect index!");
        }
    }

}