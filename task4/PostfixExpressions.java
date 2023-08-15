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

            if(push == '=') {
                System.out.println(stack2.pop());
                return;
            }

            int res = stack2.pop();
            int temp = stack2.pop();

            if(push == '+') {
                res += temp;
            }

            if(push == '-') {
                res = temp - res;
            }

            if(push == '*') {
                res *= temp;
            }

            if(push == '/') {
                if(res == 0) {
                    throw new ArithmeticException("You can't divide by zero.");
                }
                res = temp / res;
            }

            stack2.push(res);
        }
    }

}
