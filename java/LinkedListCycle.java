class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
	next = null;
    }
}

public class Solution{
    //solution1
    public boolean hasCycle(ListNode head) {
        HashSet record_nodes = new HashSet();
        ListNode cur = head;
        while (cur != null){
            if(record_nodes.contains(cur))
                return true;
            record_nodes.add(cur);
            cur = cur.next;
        }
        return false;
    }
    //solution2
    public boolean hasCycle(ListNode head){
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && slow != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
