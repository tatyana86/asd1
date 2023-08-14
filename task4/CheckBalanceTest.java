import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CheckBalanceTest {

    @Test
    void test1() {
        String s = "())(";
        assertFalse(CheckBalance.isBalanced(s));
    }

    @Test
    void test2() {
        String s = "))((";
        assertFalse(CheckBalance.isBalanced(s));
    }

    @Test
    void test3() {
        String s = "((())";
        assertFalse(CheckBalance.isBalanced(s));
    }

    @Test
    void test4() {
        String s = "((()))";
        assertTrue(CheckBalance.isBalanced(s));
    }

    @Test
    void test5() {
        String s = "()()()";
        assertTrue(CheckBalance.isBalanced(s));
    }

    @Test
    void test6() {
        String s = "((()))()(())(()())";
        assertTrue(CheckBalance.isBalanced(s));
    }

    @Test
    void test7() {
        String s = "((()))()(())(()()))";
        assertFalse(CheckBalance.isBalanced(s));
    }

}