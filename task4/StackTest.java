import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> emptyStack = new Stack<>();

    @Test
    public void pushOneElem() {
        emptyStack.push(5);
        assertEquals(1, emptyStack.size());
        assertEquals(5, emptyStack.peek());
    }

    @Test
    public void peekLastElem() {
        emptyStack.push(5);
        emptyStack.push(6);
        emptyStack.push(7);
        emptyStack.push(8);
        assertEquals(4, emptyStack.size());
        assertEquals(8, emptyStack.peek());
    }

    @Test
    public void popAllElem() {
        emptyStack.push(5);
        emptyStack.push(6);
        emptyStack.push(7);
        emptyStack.push(8);
        assertEquals(8, emptyStack.pop());
        assertEquals(7, emptyStack.pop());
        assertEquals(6, emptyStack.pop());
        assertEquals(5, emptyStack.pop());
        assertEquals(null, emptyStack.pop());
    }

    @Test
    public void sizeArray() {
        assertEquals(0, emptyStack.size());
        emptyStack.push(5);
        emptyStack.push(6);
        assertEquals(2, emptyStack.size());
    }
	
}