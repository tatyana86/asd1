public class CheckBalance {

    public static boolean isBalanced(String s) {
        if(s.length() == 0) {
            return false;
        }

        Stack<Character> characterStack = new Stack<>();

        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) == '(') {
                characterStack.push(s.charAt(i));
                continue;
            }
            if(s.charAt(i) == ')' && characterStack.size() == 0) {
                return false;
            }
            if(s.charAt(i) == ')' ) {
                characterStack.pop();
            }
        }

        return characterStack.size() == 0;
    }

}
