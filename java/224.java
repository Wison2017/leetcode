import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<Integer> num_stack = new Stack<>();
        Stack<Character> ops_stack = new Stack<>();
        int length = s.length();
        int i = 0;
        while (i < length) {
            if (s.charAt(i) == '(') {
                ops_stack.push('(');
            } else if (s.charAt(i) == ')') {
                char op;
                while ((op = ops_stack.pop()) != '(') {
                    if (op == '+') {
                        int result = num_stack.pop() + num_stack.pop();
                        num_stack.push(result);
                    } else {
                        int top1 = num_stack.pop();
                        int top2 = num_stack.pop();
                        int result = top2 - top1;
                        num_stack.push(result);
                    }
                }
            } else if (s.charAt(i) == '+') {
                if (!ops_stack.isEmpty()) {
                    char op = ops_stack.peek();
                    if (op == '+') {
                        int result = num_stack.pop() + num_stack.pop();
                        num_stack.push(result);
                    } else if (op == '-') {
                        int top1 = num_stack.pop();
                        int top2 = num_stack.pop();
                        int result = top2 - top1;
                        num_stack.push(result);
                        ops_stack.pop();
                        ops_stack.push('+');
                    } else {
                        ops_stack.push('+');
                    }
                } else {
                    ops_stack.push('+');
                }
            } else if (s.charAt(i) == '-') {
                if (!ops_stack.isEmpty()) {
                    char op = ops_stack.peek();
                    if (op == '+') {
                        int result = num_stack.pop() + num_stack.pop();
                        ops_stack.pop();
                        num_stack.push(result);
                        ops_stack.push('-');
                    } else if (op == '-') {
                        int top1 = num_stack.pop();
                        int top2 = num_stack.pop();
                        int result = top2 - top1;
                        num_stack.push(result);
                    } else {
                        ops_stack.push('-');
                    }
                } else {
                    ops_stack.push('-');
                }
            } else if (s.charAt(i) == ' ') {
                i++;
                continue;
            } else {
                int num = s.charAt(i) - '0';
                i += 1;
                while (i < length) {
                    if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        int n = s.charAt(i) - '0';
                        num = num * 10 + n;
                        i++;
                    } else {
                        break;
                    }
                }
                num_stack.push(num);
                i--;
            }
            i++;
        }
        while (!ops_stack.isEmpty()) {
            char c = ops_stack.pop();
            int num1 = num_stack.pop();
            int num2 = num_stack.pop();
            if (c == '+') {
                int result = num1 + num2;
                num_stack.push(result);
            } else {
                int result = num2 - num1;
                num_stack.push(result);
            }
        }
        return num_stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "(1-(3-4))";
        int result = s.calculate(str);
        System.out.println(result);
    }
}
