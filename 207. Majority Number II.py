# Medium
# Given an integer array of length L, 
# find all numbers that occur more than 1/3 * L times if any exist.

# Assumptions
# The given array is not null

# Examples
# A = {1, 2, 1, 2, 1}, return [1, 2]
# A = {1, 2, 1, 2, 3, 3, 1}, return [1]
# A = {1, 2, 2, 3, 1, 3}, return []

# Solution
from collections import Counter

class Solution(object):
  def majority(self, array):
    """
    input: int[] array
    return: Integer[]
    """
    cnt = Counter(array)
    n = len(array)
    ans = []

    for c, cn in cnt.items():
      if cn > n // 3:
        ans.append(c)
    
    return ans
# TC: O(n); SC: O(n)
