# class ListNode:
#     __init__(self, x):
#         self.val = x
#         self.next = None
#

class Solution:

    # 迭代
    # def reverseList(self, head: ListNode) -> ListNode:
    #     pre, cur = None, head
    #     while(cur):
    #         cur.next, pre, cur = pre, cur, cur.next
    #     return pre
    # 递归
    def reverseList(self, head: ListNode) -> ListNode:
        if head is None or head.next is None:
            return head
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_head
