public class HashTable
{
    public int size;
    public int step;
    public String [] slots;

    public HashTable(int sz, int stp)
    {
        size = sz;
        step = stp;
        slots = new String[size];
        for(int i=0; i<size; i++) slots[i] = null;
    }

    public int hashFun(String value)
    {
        if(value == null) {
            return -1;
        }

        int slot = 0;
        char[] array = value.toCharArray();
        for(int i = 0; i < array.length; i ++) {
            slot += array[i];
        }
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

    public int put(String value)
    {
        int finalSlot = seekSlot(value);

        if(finalSlot == -1) {
            return -1;
        }

        slots[finalSlot] = value;
        return finalSlot;
    }

    public int find(String value)
    {
        if(value == null) {
            return -1;
        }

        for(int i = 0; i < size; i++) {
            if(value.equals(slots[i])) {
                return i;
            }
        }

        return -1;
    }
}