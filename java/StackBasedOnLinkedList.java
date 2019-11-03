public class StackBasedOnLinkedList {
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int peek() {
        if (top != null) {
            return top.getData();
        }
        return -1;
    }

    public int pop() {
        if (top != null) {
            int value = top.getData();
            top = top.next;
            return value;
        }
        return -1;
    }

    public void printAll() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

