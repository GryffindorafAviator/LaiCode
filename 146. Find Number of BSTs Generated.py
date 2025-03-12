# Medium
# Find the number of different Binary Search Trees generated from 1-n.

# Example:
# Input: 3
# Return: 5

# Solution
class Solution(object):
  def numOfTrees(self, n):
    """
    input: int n
    return: int
    """
    if n == 0:
      return 1

    c = [0] * (n + 1)
    c[0] = 1
    c[1] = 1

    for i in range(2, n + 1):
      for j in range(i):
        c[i] += c[j] * c[i - j - 1]
    
    return c[n]
# TC: O(n^2); SC: O(n)
