public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class Solution{
    public ListNode swapPairs(ListNode head){
        ListNode record_head = new ListNode(0);
        ListNode pre = record_head;
	record_head.next = head;
	while(pre.next != null && pre.next.next != null){
	    ListNode a = pre.next;
	    ListNode b = pre.next.next;
	    ListNode temp = b.next;
	    b.next = a;
	    a.next = temp;
	    pre.next = b;
	    pre = a;
	}
	return record_head;
    }
}
