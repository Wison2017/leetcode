/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode step_1 = head;
        ListNode step_2 = head.next;
        ListNode pre = null;
        ListNode pre_2 = null;
        while (step_2 != null && step_2.next != null) {
            pre = step_1;
            step_1 = step_1.next;
            step_2 = step_2.next.next;
            
            pre.next = pre_2;
            pre_2 = pre;
        }
        ListNode right = step_1.next;
        ListNode left = null;
        if (step_2 == null)
            left = pre;
        else {
            step_1.next = pre;
            left = step_1;
        }
        while (left != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
