# Medium
# Given an array of balls with k different colors denoted by numbers 1- k, 
# sort the balls.

# Examples
# k=1, {1} is sorted to {1}
# k=3, {1, 3, 2, 1, 2} is sorted to {1, 1, 2, 2, 3}
# k=5, {3, 1, 5, 5, 1, 4, 2} is sorted to {1, 1, 2, 3, 4, 5, 5}

# Assumptions
# The input array is not null.
# k is guaranteed to be >= 1.
# k << logn.

# Solution  
from collections import Counter

class Solution(object):
  def rainbowSortIII(self, array, k):
    """
    input: int[] array, int k
    return: int[]
    """
    cnt_arr = Counter(array)
    ans = []

    for i in range(k):
      for j in range(cnt_arr[i + 1]):
        ans.append(i + 1)
    
    return ans
# TC: O(n); SC: O(k)    
