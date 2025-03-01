# Medium
# Given a linked list, 
# remove the nth node from the end of list and return its head.

# Assumptions
# If n is not valid, 
# you do not need to do anything to the original list.
# Try to do this in one pass.

# Examples
# Given linked list: 
# 1->2->3->4->5, 
# and n = 2.
# After removing the second node from the end, 
# the linked list becomes 1->2->3->5.

# Solution
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
  def removeNthFromEnd(self, head, n):
    """
    input: ListNode head, int n
    return: ListNode
    """
    dummy = ListNode(0)
    dummy.next = head
    fast = dummy
    slow = dummy

    i = 0
    while fast is not None and i < n:
      fast = fast.next
      i += 1
    
    if fast is None:
      return head
        
    while fast.next is not None:
      fast = fast.next
      slow = slow.next

    slow.next = slow.next.next

    return dummy.next
# TC: O(n); SC: O(1)    
    

    
