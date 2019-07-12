# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        p=l1
        q=l2
        carry=0
        head=current=ListNode(0)
        while(p or q):
            num1 = p.val if p else 0
            num2 = q.val if q else 0
            sum = carry + num1 + num2
            carry = int(sum / 10)
            sum = sum % 10
            current.next = ListNode(sum)
            current = current.next
            p = p.next if p else None
            q = q.next if q else None
        if carry > 0:
            current.next = ListNode(carry)
        return head.next
            
