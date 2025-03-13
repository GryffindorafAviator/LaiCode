# Medium
# Given an integer number n, 
# find its integer square root.

# Assumption:
# n is guaranteed to be >= 0.

# Example:
# Input: 18
# Return: 4

# Input: 4
# Return: 2

# Solution
class Solution(object):
  def sqrt(self, x):
    """
    input: int x
    return: int
    """
    half = x // 2
    ans = 1
    for i in range(half + 2):
      if i * i == x:
        ans = i
        break
      if i * i > x:
        ans = i - 1
        break
    return ans
#TC: O(n); SC: O(1) 

