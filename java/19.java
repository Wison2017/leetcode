/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     ListNode helper = new ListNode(-1);
    //     helper.next = head;
    //     int length = 0;
    //     while (head != null) {
    //         length++;
    //         head = head.next;
    //     }
    //     int index = length - n;
    //     head = helper;
    //     int i = 0;
    //     while (i < index) {
    //         head = head.next;
    //         i += 1;
    //     }
    //     head.next = head.next.next;
    //     return helper.next;
    // }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode helper = new ListNode(-1);
        helper.next = head;
        ListNode left = helper;
        ListNode right = helper;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return helper.next;
    }
}