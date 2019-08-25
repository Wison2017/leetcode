class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < tokens.length; i++) {
            int result = 0;
            switch (tokens[i]) {
                case "+" :
                    result = stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "-" :
                    result = -stack.pop() + stack.pop();
                    stack.push(result);
                    break;
                case "*":
                    result = stack.pop() * stack.pop();
                    stack.push(result);
                    break;
                case "/":
                    int a = stack.pop();
                    result = stack.pop() / a;
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));

            }
        }
        return stack.pop();
    }
}