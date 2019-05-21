public class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x
    }
}

class Solution{
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
}
