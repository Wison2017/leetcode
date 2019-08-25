/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return solve(lists, 0, lists.length - 1);
    }
    public ListNode solve(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode node1 = solve(lists, left, mid);
        ListNode node2 = solve(lists, mid + 1, right);

        return merge(node1, node2);
    }
    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;
        if (node1.val < node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        }
        else {
            node2.next = merge(node1, node2.next);
            return node2;
        }
    }
}