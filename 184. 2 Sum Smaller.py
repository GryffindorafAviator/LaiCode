# Medium
# Determine the number of pairs of elements in a given array that sum to a value smaller than the given target number.

# Assumptions
# The given array is not null and has length of at least 2

# Examples
# A = {1, 2, 2, 4, 7}
# target = 7
# number of pairs is 6({1,2}, {1, 2}, {1, 4}, {2, 2}, {2, 4}, {2, 4})

# Solution
class Solution(object):
  def smallerPairs(self, array, target):
    """
    input: int[] array, int target
    return: int
    """
    n = len(array)
    array.sort()
    cnt = 0

    for i in range(n - 1, 0, -1):
      left = 0
      right = i - 1
      while left < right - 1:
        mid = left + (right - left) // 2
        if array[mid] + array[i] < target:
          left = mid
        else:
          right = mid - 1
      if array[right] + array[i] < target:
        cnt += right + 1
      elif array[left] + array[i] < target:
        cnt += left + 1
  
    return cnt
# TC: O(nlgn); SC: O(1)        

