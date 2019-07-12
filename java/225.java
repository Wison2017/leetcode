class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while(q1.size() > 1){
            int a = q1.remove();
            q2.add(a);
        }
        int result = q1.remove();
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;
        return result;
    }

    /** Get the top element. */
    public int top() {
        int result = this.pop();
        this.q1.add(result);
        return result;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return this.q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

