# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """
        # 两次遍历，第一次遍历找到链表的长度，算出要被删除的结点的前一个结点的位置，然后再遍历一遍，找到它，然后：node.next = node.next.next
        # length = 0
        # helper = ListNode(-1)
        # helper.next = head
        # while head is not None:
        #     head = head.next
        #     length += 1
        # index = length - n
        # head = helper
        # i = 0
        # while i < index:
        #     head = head.next
        #     i += 1
        # head.next = head.next.next
        # return helper.next

        helper = ListNode(-1)
        helper.next = head
        left = helper
        right = helper
        for i in range(n):
            right = right.next
        while right.next is not None:
            left = left.next
            right = right.next
        left.next = left.next.next
        return helper.next