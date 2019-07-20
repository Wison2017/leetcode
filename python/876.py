# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def middleNode(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        if head is None or head.next is None:
            return head
        slow = head
        fast = head.next
        while (fast is not None and fast.next is not None):
            slow = slow.next
            fast = fast.next.next
        if fast is not None:
            slow = slow.next
        return slow