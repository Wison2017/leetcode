# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    # def mergeTwoLists(self, l1, l2):
    #     """
    #     :type l1: ListNode
    #     :type l2: ListNode
    #     :rtype: ListNode
    #     """
    #     helper = ListNode(-1)
    #     pre = helper
    #     while l1 is not None and l2 is not None:
    #         if l1.val <= l2.val:
    #             pre.next = l1
    #             pre = l1
    #             l1 = l1.next
    #         else:
    #             pre.next = l2
    #             pre = l2
    #             l2 = l2.next
    #     if l1 is None:
    #         pre.next = l2
    #     else:
    #         pre.next = l1
    #     return helper.next
    def mergeTwoLists(self, l1, l2):
        if l1 is None:
            return l2
        if l2 is None:
            return l1
        if l1.val <= l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        else:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2


