# Medium
# Given an unsorted integer array, 
# find the subarray that has the greatest sum. 
# Return the sum and the indices of the left and right boundaries of the subarray. 
# If there are multiple solutions, 
# return the leftmost subarray.

# Assumptions
# The given array is not null and has length of at least 1.

# Examples
# {2, -1, 4, -2, 1}, 
# the largest subarray sum is 2 + (-1) + 4 = 5. 
# The indices of the left and right boundaries are 0 and 2, 
# respectively.

# {-2, -1, -3}, 
# the largest subarray sum is -1. 
# The indices of the left and right boundaries are both 1

# Return the result in a array as [sum, left, right]

# Solution
class Solution(object):
  def largestSum(self, array):
    """
    input: int[] array
    return: int[]
    """
    n = len(array)
    left = 0
    right = 0
    temp = array[0]
    ans = [-2147483648, 0, 0]

    for i in range(1, n):
      if ans[0] < temp:
        ans[0] = temp
        ans[1] = left
        ans[2] = right
      if temp >= 0:
        temp += array[i]
        right = i
      else:
        left = i
        right = i
        temp = array[i]
    
    if ans[0] < temp:
        ans[0] = temp
        ans[1] = left
        ans[2] = right
    
    return ans
# TC: O(n); SC: O(1)


