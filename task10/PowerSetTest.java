import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    PowerSet testPowerSet = new PowerSet();
    long start;
    long end;

    @BeforeEach
    void start() {
        start = System.currentTimeMillis();
    }

    @AfterEach
    void finish() {
        end = System.currentTimeMillis();
        long workTime = end - start;
        assertTrue(workTime <= 2000);
    }

    @Test
    void checkPut() {
        assertEquals(0, testPowerSet.size());
        testPowerSet.put("one");
        assertEquals(1, testPowerSet.size());
        assertTrue(testPowerSet.get("one"));

        testPowerSet.put("two");
        assertEquals(2, testPowerSet.size());

        testPowerSet.put("one");
        assertEquals(2, testPowerSet.size());
    }

    @Test
    void checkRemove() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");
        assertEquals(3, testPowerSet.size());

        testPowerSet.remove("one");
        assertEquals(2, testPowerSet.size());
        assertFalse(testPowerSet.get("one"));

        testPowerSet.remove("two");
        testPowerSet.remove("three");
        assertEquals(0, testPowerSet.size());
    }

    @Test
    void checkIntersectionNonEmpty() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("four");
        secondSet.put("one");
        secondSet.put("five");

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.intersection(secondSet);
        assertEquals(1, controlSet.size());
        assertTrue(testPowerSet.get("one"));
    }

    @Test
    void checkIntersectionEmpty() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("dog");
        secondSet.put("cat");
        secondSet.put("tree");

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.intersection(secondSet);
        assertEquals(0, controlSet.size());
    }

    @Test
    void checkUnionNotEmpty() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("four");
        secondSet.put("one");
        secondSet.put("five");

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.union(secondSet);
        assertEquals(5, controlSet.size());
    }

    @Test
    void checkUnionEmpty() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.union(secondSet);
        assertEquals(3, controlSet.size());
    }

    @Test
    void checkDifferenceEmpty() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("two");
        secondSet.put("one");
        secondSet.put("three");

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.difference(secondSet);
        assertEquals(0, controlSet.size());
    }

    @Test
    void checkDifferenceEmpty2() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("two");
        secondSet.put("one");
        secondSet.put("three");
        secondSet.put("four");

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.difference(secondSet);
        assertEquals(0, controlSet.size());
    }

    @Test
    void checkDifferenceNonEmpty() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");
        testPowerSet.put("five");

        PowerSet secondSet = new PowerSet();
        secondSet.put("two");
        secondSet.put("one");
        secondSet.put("three");
        secondSet.put("four");

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.difference(secondSet);
        assertEquals(1, controlSet.size());
        assertTrue(controlSet.get("five"));
    }

    @Test
    void checkIsSubsetTest1() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");
        testPowerSet.put("four");

        PowerSet secondSet = new PowerSet();
        secondSet.put("two");
        secondSet.put("one");
        secondSet.put("three");

        assertTrue(testPowerSet.isSubset(secondSet));
    }

    @Test
    void checkIsSubsetTest2() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("two");
        secondSet.put("one");
        secondSet.put("three");
        secondSet.put("four");

        assertFalse(testPowerSet.isSubset(secondSet));
    }

    @Test
    void checkIsSubsetTest3() {
        testPowerSet.put("one");
        testPowerSet.put("two");
        testPowerSet.put("three");

        PowerSet secondSet = new PowerSet();
        secondSet.put("two");
        secondSet.put("one");
        secondSet.put("four");

        assertFalse(testPowerSet.isSubset(secondSet));
    }

    @Test
    void checkTime() {
        for(int i = 0; i < 10000; i ++) {
            testPowerSet.put(String.valueOf(i));
        }

        PowerSet secondSet = new PowerSet();
        for(int i = 5000; i < 10000; i ++) {
            secondSet.put(String.valueOf(i));
        }

        PowerSet controlSet = new PowerSet();
        controlSet = testPowerSet.difference(secondSet);
        assertEquals(5000, controlSet.size());
    }

}