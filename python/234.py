# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        if head is None or head.next is None:
            return True
        step_1 = head
        step_2 = head.next
        pre = None
        pre_pre = None
        while step_2 is not None and step_2.next is not None:
            pre = step_1
            step_1 = step_1.next
            step_2 = step_2.next.next
            
            pre.next = pre_pre
            pre_pre = pre
        right = step_1.next
        if step_2 is None:
            left = pre
        else:
            step_1.next = pre
            left = step_1
        while right is not None:
            if left.val != right.val:
                return False
            left = left.next
            right = right.next
        return True
            
