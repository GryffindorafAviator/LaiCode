# Medium
# There is an array of positive integers, 
# in which each integer represents a piece of Pizza’s size, 
# you and your friend take turns to pick pizza from either end of the array.  
# Your friend follows a simple strategy: 
# He will always pick the larger one he could get during his turn. 
# The winner is the one who gets the larger total sum of all pizza. 
# Return the max amount of pizza you can get.

# Assumption: 
# If during your friend's turn, 
# the leftmost pizza has the same size as the rightmost pizza, 
# he will pick the rightmost one.

# Example:
# Input: [2,1,100,3]
# Output: 102

# Explanation: 
# To win the game, 
# you pick 2 first, 
# then your friend will pick either 3, 
# after that you could pick 100. 
# In the end you could get 2 + 100 = 102, 
# while your friend could only get 1 + 3 = 4.

# Solution
class Solution(object):
  def canWin(self, nums):
    """
    input: int[] nums
    return: int
    """
    n = len(nums)
    dp = [[0] * n for _ in range(n)]
    
    for i in range(n):
      dp[i][i] = nums[i]
    
    for i in range(n - 1):
      dp[i][i + 1] = max(nums[i], nums[i + 1])
    
    for size in range(3, n + 1):
      for i in range(n - size + 1):
        j = i + size - 1
        take_left = nums[i] + (dp[i + 2][j] if nums[i + 1] > nums[j] else dp[i + 1][j - 1])
        take_right = nums[j] + (dp[i + 1][j - 1] if nums[i] > nums[j - 1] else dp[i][j - 2])
        dp[i][j] = max(take_left, take_right)
    
    return dp[0][n - 1]
# TC: O(n^2); SC: O(n^2)    
