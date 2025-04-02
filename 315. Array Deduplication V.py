# Medium
# Given an integer array(not guaranteed to be sorted), 
# remove adjacent repeated elements. 
# For each group of elements with the same value keep at most two of them. Do this in-place, 
# using the left side of the original array and maintain the relative order of the elements of the array. 
# Return the final array.

# Assumptions
# The given array is not null

# Example
# {1, 2, 2, 3, 3, 3} --> {1, 2, 2, 3, 3}

# {2, 1, 2, 2, 2, 3} --> {2, 1, 2, 2, 3}  

# Solution
class Solution(object):
  def dedup(self, array):
    """
    input: int[] array
    return: int[]
    """
    n = len(array)
    if n < 2:
      return array
    
    cur = 0
    cnt = 1

    for i in range(1, n):
      if array[i] != array[cur]:
        cur += 1
        array[cur] = array[i]
        cnt = 1
      else:
        if cnt < 2:
          cur += 1
          array[cur] = array[i]
        cnt += 1
      
    return array[:cur + 1]
# TC: O(n); SC: O(1)  

          



    
