import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;

    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    public int hashFun(String key)
    {
        if(key == null) {
            return -1;
        }

        int slot = 0;
        char[] array = key.toCharArray();
        for(int i = 0; i < array.length; i ++) {
            slot += array[i];
        }
        return slot % this.size;
    }

    public boolean isKey(String key)
    {
        if(key == null) {
            return false;
        }
        int slot = hashFun(key);
        return slots[slot] != null && values[slot] != null;
    }

    public void put(String key, T value)
    {
        if(key == null) {
            return;
        }
        int slot = hashFun(key);
        slots[slot] = key;
        values[slot] = value;
    }

    public T get(String key)
    {
        if(key == null) {
            return null;
        }
        int slot = hashFun(key);
        return values[slot];
    }
}