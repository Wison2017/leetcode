# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def reverseKGroup(self, head, k):
        """
        :type head: ListNode
        :type k: int
        :rtype: ListNode
        """
        # test the rest of the linked list has k node to reverse
        test_node = head
        for i in range(k):
            if test_node == None:
                return head
            test_node = test_node.next
        
        # reverse k nodes from head
        pre = None
        tail = cur = head
        for i in range(k):
            cur.next, pre, cur = pre, cur, cur.next
        tail.next = self.reverseKGroup(cur, k)
        return pre

