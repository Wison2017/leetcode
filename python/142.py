# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def detectCycle(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        record_nodes = set()
        cur = head
        while cur:
            if cur in record_nodes:
                return cur
            record_nodes.add(cur)
            cur = cur.next
        return None
