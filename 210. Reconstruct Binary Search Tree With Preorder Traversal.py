# Medium
# Given the preorder traversal sequence of a binary search tree, 
# reconstruct the original tree.

# Assumptions
# The given sequence is not null
# There are no duplicate keys in the binary search tree

# Examples
# preorder traversal = {5, 3, 1, 4, 8, 11}
# The corresponding binary search tree is
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
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
  def reconstruct(self, pre):
    """
    input: int[] pre
    return: TreeNode
    """
    n = len(pre)
    inarr = sorted(pre)
    in_map = {}
    for i in range(n):
      in_map[inarr[i]] = i
    
    def helper(il, ir, pl, pr):
      if pr < pl:
        return None
      node = TreeNode(pre[pl])
      if pl < pr:
        idx = in_map[pre[pl]]
        node.left = helper(il, idx - 1, pl + 1, pl + idx - il)
        node.right = helper(idx + 1, ir, pl + idx - il + 1, pr)
      return node
    
    root = helper(0, n - 1, 0, n - 1)
    return root
# TC: O(nlgn); SC: O(n)
 
