# Medium
# Given an array of positive integers representing a stock’s price on each day. 
# On each day you can only make one operation: 
# either buy or sell one unit of stock, 
# at any time you can only hold at most one unit of stock, 
# and you can make at most 2 transactions in total. 
# Determine the maximum profit you can make.

# Assumptions
# The give array is not null and is length of at least 2

# Examples
# {2, 3, 2, 1, 4, 5, 2, 11}, the maximum profit you can make is (5 - 1) + (11 - 2) = 13

# Solution
class Solution(object):
  def maxProfit(self, array):
    """
    input: int[] array
    return: int
    """
    n = len(array)
    left_profit = [0] * n
    right_profit = [0] * (n + 1)
    left_min = array[0]
    right_max = array[n - 1]

    for i in range(1, n):
      left_profit[i] = max(left_profit[i - 1], array[i] - left_min)
      left_min = min(left_min, array[i])
      j = n - 1 - i
      right_profit[j] = max(right_profit[j + 1], right_max - array[j])
      right_max = max(right_max, array[j])
    
    ans = 0
    for i in range(n):
      ans = max(ans, left_profit[i] + right_profit[i + 1])
    
    return ans
# TC: O(n); SC: O(n)
