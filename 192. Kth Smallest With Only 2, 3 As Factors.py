# Medium
# Find the Kth smallest number s such that s = 2 ^ x * 3 ^ y, 
# x >= 0 and y >= 0, 
# x and y are all integers.

# Assumptions
# K >= 1

# Examples
# the smallest is 1
# the 2nd smallest is 2
# the 3rd smallest is 3
# the 5th smallest is 2 * 3 = 6
# the 6th smallest is 2 ^ 3 * 3 ^ 0 = 8

# Solution
import heapq

class Solution(object):
  def kth(self, k):
    """
    input: int k
    return: int
    """
    min_heap = [1]
    visited = {1}
    ans = 0

    for i in range(k):
      ans = heapq.heappop(min_heap)
      for f in [2, 3]:
        nxt = f * ans
        if nxt not in visited:
          heapq.heappush(min_heap, nxt)
          visited.add(nxt)
    
    return ans
# TC: O(klgk); SC: O(k)    
    

