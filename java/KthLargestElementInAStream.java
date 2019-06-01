import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (Integer i : nums){
            queue.add(i);
            if (queue.size() > k)
                queue.poll();
        }
    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k)
            queue.poll();
        return queue.peek();
    }
}
