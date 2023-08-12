import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    private static final int minCapacity = 16;
    private DynArray<Integer> emptyArray = new DynArray<Integer>(Integer.class);

    @Test
    public void insertInEmptyArray() {

        emptyArray.insert(1, 0);

        assertEquals(minCapacity, emptyArray.capacity);
        assertEquals(1, emptyArray.count);
    }

    @Test
    public void insertElemWhenCountLessThenCapacity() {

        emptyArray.append(1);
        emptyArray.insert(2, 0);

        assertEquals(minCapacity, emptyArray.capacity);
        assertEquals(2, emptyArray.count);
        assertEquals(1, emptyArray.getItem(1));
        assertEquals(2, emptyArray.getItem(0));
    }

    @Test
    public void insertElemWhenCountEqualCapacity() {

        for (int i = 0; i < minCapacity; i ++) {
            emptyArray.append(i);
        }

        emptyArray.insert(2, 5);

        assertEquals(minCapacity * 2, emptyArray.capacity);
        assertEquals(17, emptyArray.count);
        assertEquals(15, emptyArray.getItem(16));
    }

    @Test
    public void insertElemWithIncorrectIndex() {

        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> emptyArray.insert(2, -1));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> emptyArray.insert(2, 1));
    }

    @Test
    public void insertElemsWithIncreaseCapacityTwice() {

        for (int i = 0; i < 35; i++) {
            emptyArray.insert(i, i);
        }

        assertEquals(minCapacity * 2 * 2, emptyArray.capacity);
    }

    @Test
    public void removeWhenCapacityIsSame() {

        emptyArray.makeArray(40);

        for (int i = 0; i < 21; i ++) {
            emptyArray.append(i);
        }

        emptyArray.remove(10);

        assertEquals(40, emptyArray.capacity);
        assertEquals(20, emptyArray.count);
        assertEquals(11, emptyArray.getItem(10));
    }

    @Test
    public void removeWhenCapacityShouldReduce() {

        emptyArray.makeArray(40);

        for (int i = 0; i < 20; i ++) {
            emptyArray.append(i);
        }

        emptyArray.remove(0);

        assertEquals(26, emptyArray.capacity);
        assertEquals(19, emptyArray.count);
        assertEquals(1, emptyArray.getItem(0));
    }

    @Test
    public void removeElemWithIncorrectIndex() {

        for (int i = 0; i < 20; i ++) {
            emptyArray.append(i);
        }

        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> emptyArray.remove(-1));
        assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> emptyArray.remove(21));

        emptyArray.remove(3);
        assertEquals(4, emptyArray.getItem(3));
    }
}