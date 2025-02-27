# Medium
# Given an integer array of length L, 
# find all numbers that occur more than 1/3 * L times if any exist.

# Assumptions
# The given array is not null

# Examples
# A = {1, 2, 1, 2, 1}, return [1, 2]
# A = {1, 2, 1, 2, 3, 3, 1}, return [1]
# A = {1, 2, 2, 3, 1, 3}, return []

# Solution 1
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

# Solution 2
class Solution(object):
  def majority(self, array):
    """
    input: int[] array
    return: Integer[]
    """
    cnd1 = None
    cnt1 = 0
    cnd2 = None
    cnt2 = 0

    for d in array:
      if d == cnd1:
        cnt1 += 1
      elif d == cnd2:
        cnt2 += 1
      elif cnt1 == 0:
        cnd1 = d
        cnt1 += 1
      elif cnt2 == 0:
        cnd2 = d
        cnt2 += 1
      else:
        cnt1 -= 1
        cnt2 -= 1
    
    threshold = len(array) // 3
    ans = []
    for c in [cnd1, cnd2]:
      if array.count(c) > threshold:
        ans.append(c)
    
    return ans
# TC: O(n); SC: O(1)
