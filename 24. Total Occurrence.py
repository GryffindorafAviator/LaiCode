# Medium
# Given a target integer T and an integer array A sorted in ascending order, 
# Find the total number of occurrences of T in A.

# Examples
# A = {1, 2, 3, 4, 5}, T = 3, return 1
# A = {1, 2, 2, 2, 3}, T = 2, return 3
# A = {1, 2, 2, 2, 3}, T = 4, return 0

# Corner Cases
# What if A is null?
# We should return 0 in this case.

# Solution 1
from collections import Counter

class Solution(object):
  def totalOccurrence(self, array, target):
    """
    input: int[] array, int target
    return: int
    """
    if array is None:
      return 0
    
    cnt = Counter(array)
    return cnt[target]
# TC: O(n); SC: O(n)

# Solution 2
class Solution(object):
  def totalOccurrence(self, array, target):
    """
    input: int[] array, int target
    return: int
    """
    if array is None:
      return 0
    
    n = len(array)
    if n == 0:
      return 0
    if n == 1:
      return 1 if target == array[0] else 0
    
    left_t = 0
    right_t = 0

    left = 0
    right = n - 1
    while left < right - 1:
      mid = left + (right - left) // 2
      if array[mid] < target:
        left = mid
      else:
        right = mid - 1
    
    if array[right] < target:
      if right + 1 >= n or array[right + 1] > target:
        return 0
      else:
        left_t = right
    elif array[right] == target:
      if array[left] < target:
        left_t = left
      else:
        left_t = -1
    else:
      if array[left] == target:
        return 1
      else:
        return 0
    
    left = 0
    right = n - 1
    while left < right - 1:
      mid = left + (right - left) // 2
      if array[mid] > target:
        right = mid
      else:
        left = mid + 1
    
    if array[left] > target:
      if left - 1 < 0 or array[left - 1] < target:
        return 0
      else:
        right_t = left
    elif array[left] == target:
      if array[right] > target:
        right_t = right
      else:
        right_t = n
    else:
      if array[right] == target:
        return 1
      else:
        return 0
    
    return right_t - left_t - 1
 # TC: O(lgn); SC: O(1)       

