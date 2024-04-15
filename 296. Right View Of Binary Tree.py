# Medium
# Given a Binary Tree, return the right view of it. Right view of a Binary Tree is list of nodes visible when tree is visited from Right side, the order of the nodes in the list should be from top to bottom level of the original tree.

# Examples:
#            1
#         /    \
#        2      3
#       / \    /  \
#      4   5   6  7
#     /            \
#     9             8
#   /  \
#  10  11
# the right view =  [1, 3, 7, 8, 11]

# Solution
from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
  def rightView(self, root):
    """
    input: TreeNode root
    return: Integer[]
    """
    result = []
    if root is None:
      return result
      
    q = deque()
    q.append(root)
    
    while q:
      n = len(q)
      for i in range(n):
        cur = q.popleft()
        if i == n - 1:
          result.append(cur.val)
        if cur.left is not None:
          q.append(cur.left)
        if cur.right is not None:
          q.append(cur.right)
      
    return result
# TC: O(n); SC: O(n)
