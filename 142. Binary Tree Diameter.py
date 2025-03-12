# Medium
# Given a binary tree in which each node contains an integer number. 
# The diameter is defined as the longest distance from one leaf node to another leaf node. 
# The distance is the number of nodes on the path.
# If there does not exist any such paths, 
# return 0.

# Examples
#     5

#   /    \

# 2      11

#      /    \

#     6     14

# The diameter of this tree is 4 (2 → 5 → 11 → 14)

# How is the binary tree represented?
# We use the level order traversal sequence with a special symbol "#" denoting the null node.
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
  def diameter(self, root):
    """
    input: TreeNode root
    return: int
    """
    ans = [0]

    def dfs(node):
      if node.left is None and node.right is None:
        return 1
      left_height = 0
      right_height = 0
      if node.left is not None:
        left_height = dfs(node.left)
      if node.right is not None:
        right_height = dfs(node.right)
      if left_height > 0 and right_height > 0:
        ans[0] = max(left_height + right_height + 1, ans[0])
      return max(left_height, right_height) + 1
    
    if root is not None:
      dfs(root)
    return ans[0]
# TC: O(n); SC: O(height)
    
