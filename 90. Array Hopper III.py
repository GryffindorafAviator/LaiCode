# Medium
# Given an array of non-negative integers, 
# you are initially positioned at index 0 of the array. 
# A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). 
# Determine the minimum number of jumps you need to jump out of the array.
# By jump out, 
# it means you can not stay at the end of the array. 
# Return -1 if you can not do so.

# Assumptions
# The given array is not null and has length of at least 1.

# Examples
# {1, 3, 2, 0, 2}, 
# the minimum number of jumps needed is 3 (jump to index 1 then to the end of array, then jump out)
# {3, 2, 1, 1, 0}, 
# you are not able to jump out of array, 
# return -1 in this case.

# Solution 1
class Solution(object):
  def minJump(self, array):
    """
    input: int[] array
    return: int
    """
    n = len(array)
    dp = [-1] * n

    for i in range(n - 1, -1, -1):
      steps = array[i]
      temp = float('inf')
      for j in range(steps):
        if i + 1 + j < n:
          if dp[i + 1 + j] != -1:
            temp = min(temp, dp[i + 1 + j])
        else:
          dp[i] = 1
          break
      if temp != float('inf') and dp[i] != 1:
        dp[i] = temp + 1    
    return dp[0]
# TC: O(n^2) SC: O(n)

# Solution 2
from collections import deque

class Solution(object):
  def minJump(self, array):
    """
    input: int[] array
    return: int
    """
    n = len(array)
    q = deque()
    q.append((0, 0))
    visited = [False] * n
    visited[0] = True

    while len(q) > 0:
      cur = q.popleft()
      pos = cur[0]
      steps = cur[1]
      for i in range(array[pos]):
        nxt = pos + 1 + i
        if nxt >= n:
          return steps + 1
        if not visited[nxt]:
          q.append((nxt, steps + 1))
          visited[nxt] = True
    
    return -1
#TC: O(n); SC: O(n) 

