import java.lang.reflect.Array;

class NativeCache<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;
    public int step;

    public NativeCache(int sz, Class clazz) {
        this.size = sz;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.hits = new int[size];
        this.step = 3;
    }

    public int hashFun(String key)
    {
        if(key == null) {
            return -1;
        }

        int slot = Math.abs(key.hashCode());
        return slot % this.size;
    }

    public int seekSlot(String value)
    {
        int curSlot = hashFun(value);
        int varStep = this.step;

        for(int i = curSlot; varStep > 0; i += varStep) {
            if(i >= this.size) {
                varStep --;
                i = 0;
            }
            if(slots[i] == null) {
                return i;
            }
        }

        return -1;
    }

    public void put(String key, T value)
    {
        if(key == null) {
            return;
        }

        if(isKey(key)) {
            int slot = hashFun(key);
            slots[slot] = key;
            values[slot] = value;
            return;
        }

        int finalSlot = seekSlot(key);

        if(finalSlot == -1) {
            finalSlot = deleteLeastPopularItem();
        }

        slots[finalSlot] = key;
        values[finalSlot] = value;
    }

    private int deleteLeastPopularItem() {
        int minHit = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 1; i < hits.length; i ++) {
            if(hits[i] < minHit) {
                minHit = hits[i];
                index = i;
            }
        }
        hits[index] = 0;
        slots[index] = null;
        values[index] = null;

        return index;
    }

    public T get(String key)
    {
        if(key == null) {
            return null;
        }
        int slot = hashFun(key);
        hits[slot] += 1;
        return values[slot];
    }

    public boolean isKey(String key)
    {
        if(key == null) {
            return false;
        }
        for(int i = 0; i < slots.length; i ++) {
            if(slots[i] != null && slots[i].equals(key)) {
                hits[i] += 1;
                return true;
            }
        }
        return false;
    }
}