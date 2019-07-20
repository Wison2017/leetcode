/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 迭代
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode flag = new ListNode(-1);
    //     ListNode pre = flag;
    //     while (l1 != null && l2 != null) {
    //         if (l1.val <= l2.val) {
    //             pre.next = l1;
    //             pre = l1;
    //             l1 = l1.next;
    //         } else {
    //             pre.next = l2;
    //             pre = l2;
    //             l2 = l2.next;
    //         }
    //     }
    //     if (l1 == null) {
    //         pre.next = l2;
    //     } else {
    //         pre.next = l1;
    //     }
    //     return flag.next;
    // }
    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}