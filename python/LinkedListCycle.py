class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    #solution 1   O(n)
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        nodes_set = set()
        cur = head
        while cur:
            if cur in nodes_set:
                return True
            nodes_set.add(cur)
            cur = cur.next
        return False
    
    #solution2   O(n)
    def hasCycle(self, head):
        """
        :type head: ListNode
        :rtype: bool
        """
        slow = fast = head
        while slow and fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False
