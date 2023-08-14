public class PostfixExpressions {

    public static void calculate(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        String [] characters = s.split(" ");

        for(int i = characters.length - 1; i > -1; i --) {
            stack1.push(characters[i].charAt(0));
        }

        while(stack1.size() > 0) {
            Character push = stack1.pop();

            if(Character.isDigit(push)) {
                stack2.push(Character.getNumericValue(push));
                continue;
            }

            int res = stack2.pop();

            if(push == '+') {
                res += stack2.pop();
            }

            if(push == '-') {
                res = stack2.pop() - res;
            }

            if(push == '*') {
                res *= stack2.pop();
            }

            if(push == '/') {
                if(res == 0) {
                    throw new ArithmeticException("You can't divide by zero.");
                }
                res = stack2.pop() / res;
            }

            stack2.push(res);

            if(push == '=') {
                System.out.println(stack2.pop());
            }
        }
    }

}
