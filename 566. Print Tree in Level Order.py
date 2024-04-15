# Easy
# Print all node values in a tree in level order.
# Assumption: The tree is not null or empty.

# Example:
#         7

#           /   \

#         5     4

#       /   \

#     3     6

#           /

#         1

# Answer:
# [7,5,4,3,6,1]

# Solution
from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
  def bfs(self, root):
    """
    input: TreeNode root
    return: Integer[]
    """
    result = []
    if root is None:
      return result
    
    q = deque()
    q.append(root)
    while len(q) > 0:
      cur = q.popleft()
      result.append(cur.val)
      if cur.left is not None:
        q.append(cur.left)
      if cur.right is not None:
        q.append(cur.right)
    
    return result
# TC: O(n); SC: O(n)
