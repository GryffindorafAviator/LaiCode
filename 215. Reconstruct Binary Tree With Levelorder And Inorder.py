# Hard
# Given the levelorder and inorder traversal sequence of a binary tree, 
# reconstruct the original tree.

# Assumptions
# The given sequences are not null and they have the same length
# There are no duplicate keys in the binary tree

# Examples
# levelorder traversal = {5, 3, 8, 1, 4, 11}
# inorder traversal = {1, 3, 4, 5, 8, 11}
# the corresponding binary tree is

#         5

#       /    \

#     3        8

#   /   \        \

# 1      4        11

# How is the binary tree represented?
# We use level order traversal sequence with a special symbol "#" denoting the null node.

# For Example:
# The sequence [1, 2, 3, #, #, 4] represents the following binary tree:

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
  def reconstruct(self, inOrder, levelOrder):
    """
    input: int[] inOrder, int[] levelOrder
    return: TreeNode
    """
    if inOrder is None or levelOrder is None:
      return None

    n = len(inOrder)
    if n == 0:
      return None
    
    lvl_map = {}
    for i in range(n):
      lvl_map[levelOrder[i]] = i

    def helper(l, r):
      if l > r:
        return None
      if l == r:
        return TreeNode(inOrder[l])
      
      min_idx = l
      for i in range(l + 1, r + 1):
        if lvl_map[inOrder[i]] < lvl_map[inOrder[min_idx]]:
          min_idx = i

      cur_node = TreeNode(inOrder[min_idx])
      cur_node.left = helper(l, min_idx - 1)
      cur_node.right = helper(min_idx + 1, r)

      return cur_node
    
    return helper(0, n - 1)
# TC: O(n^2); SC: O(n)
