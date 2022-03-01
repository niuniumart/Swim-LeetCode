# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        head = ListNode()
        crt = head
        inherit = 0
        while (True):
            if (l1 == None and l2 == None and inherit == 0):
                break
            tmpVal = inherit
            if l1 != None:
                tmpVal = tmpVal + l1.val
                l1 = l1.next
            if l2 != None:
                tmpVal = tmpVal + l2.val
                l2 = l2.next
            inherit = tmpVal // 10
            node = ListNode()
            node.val = tmpVal % 10
            crt.next = node
            crt = node
        return head.next
            
        
