import java.util.HashMap;

class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }
    private HashMap<Integer, Node> cache = new HashMap<>();
    private int size;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    private void addNode(Node node) {
        node.pre = head;
        node.next = head.next;

        head.next = node;
        node.next.pre = node;
    }
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private Node popTail() {
        Node node = tail.pre;
        removeNode(node);
        return node;
    }
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null)
            return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            Node new_node = new Node();
            new_node.key = key;
            new_node.value = value;
            if (size < capacity) {
                cache.put(key, new_node);
                addNode(new_node);
                size++;
            } else {
                Node remove_node = popTail();
                cache.remove(remove_node.key);
                addNode(new_node);
                cache.put(key, new_node);
                size++;
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */