# Medium
# Given a binary Tree and the two keys, 
# determine whether the two nodes are cousins of each other or not. 
# Two nodes are cousins of each other if they are at the same level and have different parents.

# Assumptions:
# It is not guranteed the two keys are all in the binary tree.
# There are no duplicate keys in the binary tree.
  
# Examples:
#      6
#    /   \
#   3     5
#  / \   / \

# 7   8 1   13
# 7 and 1, result is true.
# 3 and 5, result is false.
# 7 and 5, result is false.

# Solution
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution(object):
  def isCousin(self, root, a, b):
    """
    input: TreeNode root, int a, int b
    return: boolean
    """
    if root == None:
      return False
    if root.val == a or root.val == b:
      return False
    
    rec_a = [root, 0, False]
    rec_b = [root, 0, False]
    self.dfs(root, rec_a, a)
    self.dfs(root, rec_b, b)

    if not rec_a[2] or not rec_b[2]:
      return False
    else:
      if rec_a[1] == rec_b[1] and rec_a[0] is not rec_b[0]:
        return True

    return False 
  
  def dfs(self, node, rec, t):
    if node == None:
      return
    if node.val == t:
      rec[2] = True
      return
    
    h = rec[1] + 1
    rec[0] = node
    rec[1] = h
    self.dfs(node.left, rec, t)
    if not rec[2]:
      rec[0] = node
      rec[1] = h 
      self.dfs(node.right, rec, t)
# TC: O(n); SC: O(height)
    
