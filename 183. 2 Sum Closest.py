# Medium
# Find the pair of elements in a given array that sum to a value that is closest to the given target number. 
# Return the values of the two numbers.

# Assumptions
# The given array is not null and has length of at least 2

# Examples
# A = {1, 4, 7, 13}, 
# target = 7, 
# closest pair is 1 + 7 = 8, 
# return [1, 7].

# Solution
class Solution(object):
  def closest(self, array, target):
    """
    input: int[] array, int target
    return: Integer[]
    """
    if array is None:
      return []

    n = len(array)
    if n < 2:
      return []
    
    array.sort()
    min_diff = float('inf')
    ans = []
    
    left = 0
    right = n - 1
    while left < right:
      diff = target - array[left] - array[right]
      abs_diff = abs(diff)
      if abs_diff < min_diff:
        ans = [array[left], array[right]]
        min_diff = abs_diff
      if diff == 0:
        return ans
      elif diff > 0:
        left += 1
      else:
        right -= 1
    
    return ans
# TC: O(nlgn); SC: O(1)
     



