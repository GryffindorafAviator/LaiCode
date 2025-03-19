# Medium
# Given the levelorder traversal sequence of a binary search tree, 
# reconstruct the original tree.

# Assumptions
# The given sequence is not null
# There are no duplicate keys in the binary search tree

# Examples
# levelorder traversal = {5, 3, 8, 1, 4, 11}
# the corresponding binary search tree is
#         5

#       /    \

#     3        8

#   /   \        \

# 1      4        11

# How is the binary tree represented?
# We use the pre order traversal sequence with a special symbol "#" denoting the null node.

# For Example:
# The sequence [1, 2, #, 3, 4, #, #, #] represents the following binary tree:
#     1

#   /   \

#  2     3

#       /

#     4

# Solution
from collections import deque

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
  def reconstruct(self, level):
    """
    input: int[] level
    return: TreeNode
    """
    n = len(level)
    if n == 0:
      return None
    
    root = TreeNode(level[0])
    q = deque()
    q.append((root, float('-inf'), float('inf')))

    i = 1
    while i < n:
      node, left, right = q.popleft()
      if left < level[i] < node.val:
        node.left = TreeNode(level[i])
        q.append((node.left, left, node.val))
        i += 1
      if i < n and node.val < level[i] < right:
        node.right = TreeNode(level[i])
        q.append((node.right, node.val, right))
        i += 1
    
    return root
# TC: O(n); SC: O(n)


