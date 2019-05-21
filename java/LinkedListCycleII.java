/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> record_nodes = new HashSet();
        ListNode cur = head;
        while(cur != null){
            if(record_nodes.contains(cur))
                return cur;
            record_nodes.add(cur);
            cur = cur.next;
        }
        return null;
    }
}
