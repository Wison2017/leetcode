/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        //test if the rest of the linked list has k nodes to reverse
        ListNode test_node = head;
        for(int i = 0; i < k; i++){
            if(test_node == null)
                return head;
            test_node = test_node.next;
        }
        
        //reverse k nodes
        ListNode pre = null;
        ListNode tail, cur;
        tail = cur = head;
        for(int i = 0; i < k; i++){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        tail.next = reverseKGroup(cur, k);
        return pre;
    }
}
