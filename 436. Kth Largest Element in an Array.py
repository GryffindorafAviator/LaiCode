# Medium
# Find the kth largest element in an unsorted array. 
# Note that it is the kth largest element in the sorted order, 
# not the kth distinct element.

# For example,
# Given [3,2,1,5,6,4] and k = 2, 
# return 5.

# Note: 
# You may assume k is always valid, 
# 1 ≤ k ≤ array's length.

# Solution
import heapq

class Solution(object):
  def findKthLargest(self, nums, k):
    """
    input: int[] nums, int k
    return: int
    """
    pq = []
    n = len(nums)
    
    for i in range(k):
      heapq.heappush(pq, nums[i])
    
    for i in range(k, n):
      if nums[i] > pq[0]:
        heapq.heappop(pq)
        heapq.heappush(pq, nums[i])
    
    return pq[0]
# TC: O(k + (n - k)lgk); SC: O(k)   
