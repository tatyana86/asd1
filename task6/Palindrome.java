public class Palindrome {

    public static boolean isPalindrome(String word) {
        if(word.length() == 0) {
            return false;
        }

        Deque<Character> dequeofChar = new Deque<>();
        for(int i = 0; i < word.length(); i ++) {
            dequeofChar.addTail(word.charAt(i));
        }
        for(int i = 0; i < word.length() / 2; i ++) {
            if(dequeofChar.removeTail() != dequeofChar.removeFront()) {
                return false;
            }
        }

        return true;
    }
}
