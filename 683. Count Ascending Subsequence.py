# Medium
# Given an array A[0]...A[n-1] of integers, 
# count the number of ascending subsequences.

# In case that the result is larger than 32-bit integer, 
# return the result in 10^9+7 modulo.

# Assumptions
# A is not null
  
# Examples
# Input: A = {1,2,3}
# Output: 7
  
# Explanation: 
# [1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]

# Solution
class Solution(object):
  def numIncreasingSubsequences(self, a):
    """
    input: int[] a
    return: int
    """
    n = len(a)
    dp = [1] * n
    MOD = 1e9 + 7

    for i in range(1, n):
      for j in range(i):
        if a[i] > a[j]:
          dp[i] = (dp[i] + dp[j]) % MOD
    
    return int(sum(dp) % MOD)
# TC: O(n^2); SC: O(n)
