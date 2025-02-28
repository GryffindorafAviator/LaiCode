# Easy
# Given two integer arrays all and partial without duplicate numbers, 
# array partial is subset of array all. 
# For each number in partial, 
# find the first number on its right in all that greater than it. 
# If no such number existed, 
# then assign the result to -1.

# Example 1: 
# Input: all = [3,4,1,2]    partial = [4,1,2]
# Output: [-1, 2, -1]

# Example 2:
# Input: all = [1, 2, 3, 4] partial = [4,1,2]
# Output: [-1, 2, 3] 

# Solution
class Solution(object):
  def nextGreaterElement(self, partial, all):
    """
    input: int[] partial, int[] all
    return: int[]
    """
    n = len(partial)
    par_dict = {}
    for i in range(n):
      par_dict[partial[i]] = i
    mono_stack = []
    ans = [-1] * n

    for num in all:
      while len(mono_stack) > 0 and num > partial[mono_stack[-1]]:
        ans[mono_stack[-1]] = num
        mono_stack.pop(-1)
      if num in par_dict:
        mono_stack.append(par_dict[num])
    
    return ans
# TC: O(n); SC: O(n)
    
