# Medium
# Given the postorder and inorder traversal sequence of a binary tree, 
# reconstruct the original tree.

# Assumptions
# The given sequences are not null and they have the same length
# There are no duplicate keys in the binary tree

# Examples
# postorder traversal = {1, 4, 3, 11, 8, 5}
# inorder traversal = {1, 3, 4, 5, 8, 11}

# the corresponding binary tree is
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
  def reconstruct(self, inOrder, postOrder):
    """
    input: int[] inOrder, int[] postOrder
    return: TreeNode
    """
    n = len(inOrder)
    if n <= 0:
      return None
      
    in_map = {}

    for i in range(n):
        in_map[inOrder[i]] = i

    def helper(inOrder, postOrder, inLeft, inRight, postLeft, postRight):
        idx = in_map[postOrder[postRight]]
        node = TreeNode(inOrder[idx])

        inRightL = idx - 1
        inLeftR = idx + 1
        postRightL = postLeft + (inRightL - inLeft)
        postLeftR = postRightL + 1
        postRight -= 1

        if inLeft <= inRightL:
            leftNode = helper(inOrder, postOrder, inLeft, inRightL, postLeft, postRightL)
        else:
            leftNode = None
        if inLeftR <= inRight:
            rightNode = helper(inOrder, postOrder, inLeftR, inRight, postLeftR, postRight)
        else:
            rightNode = None
        
        node.left = leftNode
        node.right = rightNode

        return node

    root = helper(inOrder, postOrder, 0, n - 1, 0, n - 1)

    return root
# TC: O(n); SC: O(n)
