import java.util.Stack;

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if ("D".equals(ops[i])) {
                int last_point = stack.peek();
                int cur_point = 2 * last_point;
                stack.push(cur_point);
            } else if ("+".equals(ops[i])) {
                int last_point = stack.pop();
                int last_2_point = stack.pop();
                int cur_point = last_point + last_2_point;
                stack.push(last_2_point);
                stack.push(last_point);
                stack.push(cur_point);
            } else if ("C".equals(ops[i])) {
                stack.pop();
            } else {
                int num = Integer.valueOf(ops[i]);
                stack.push(num);
            }
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}
