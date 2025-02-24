# Medium
# Given a set of n integers, 
# divide the set in two subsets of n/2 sizes each such that the difference of the sum of two subsets is as minimum as possible.
# Return the minimum difference(absolute value).

# Assumptions:
# The given integer array is not null and it has length of >= 2.

# Examples:
# {1, 3, 2} can be divided into {1, 2} and {3}, 
# the minimum difference is 0

# Solution
class Solution(object):
  def minDifference(self, array):
    """
    input: int[] array
    return: int
    """
    totalSum = sum(array)
    n = len(array)

    def dfs(idx, accmSum, cnt):
      if cnt == n // 2:
        minSum[0] = min(minSum[0], abs(accmSum - (totalSum - accmSum)))
        return

      if idx >= n:
        return
      
      dfs(idx + 1, accmSum + array[idx], cnt + 1)
      dfs(idx + 1, accmSum, cnt)
    
    minSum = [float('inf')]
    dfs(0, 0, 0)

    return minSum[0]
# TC: O(2^n); SC: O(n)      
    

    
    
