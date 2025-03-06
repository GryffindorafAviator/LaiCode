# Medium
# Check if a given linked list has a cycle. 
# Return the node where the cycle starts. 
# Return null if there is no cycle.

# Solution
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution(object):
  def findCycle(self, head):
    """
    input: ListNode head
    return: ListNode
    """
    if head is None or head.next is None:
      return None
    
    fast = head
    slow = head

    while fast is not None and fast.next is not None:
      fast = fast.next.next
      slow = slow.next
      if fast == slow:
        entry = head
        while entry is not slow:
          entry = entry.next
          slow = slow.next
        return entry
    
    return None
# TC: O(n); SC: O(1)
