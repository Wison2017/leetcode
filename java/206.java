public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x
    }
}

class Solution{
	// 迭代
    public ListNode reverseList(ListNode head){
        ListNode pre = null;
	ListNode cur = head;
	ListNode temp;
	while(cur != null){
	    temp = cur.next;
	    cur.next = pre;
	    pre = cur;
	    cur = temp;
	}
	return pre;
    }

    //迭代
//	public ListNode reverseList(ListNode head) {
//		if (head == null || head.next == null)
//			return head;
//		ListNode new_head = reverseList(head.next);
//		head.next.next = head;
//		head.next = null;
//		return new_head;
//	}
}
