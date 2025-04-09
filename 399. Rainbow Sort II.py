# Medium
# Given an array of balls, 
# where the color of the balls can only be Red, 
# Green, 
# Blue or Black, 
# sort the balls such that all balls with same color are grouped together and from left to right the order is Red->Green->Blue->Black. 
# (Red is denoted by 0, 
# Green is denoted by 1,  
# Blue is denoted by 2 and Black is denoted by 3).

# Examples
# {0} is sorted to {0}
# {1, 0} is sorted to {0, 1}
# {1, 3, 1, 2, 0} is sorted to {0, 1, 1, 2, 3}

# Assumptions
# The input array is not null.

# Solution
class Solution(object):
  def rainbowSortII(self, array):
    """
    input: int[] array
    return: int[]
    """
    n = len(array)
    if n < 2:
      return array
    
    def swap(i, j):
      temp = array[i]
      array[i] = array[j]
      array[j] = temp
    
    p0 = 0
    p1 = 0
    p2 = 0
    p3 = n - 1
    while p2 <= p3:
      if array[p2] == 0:
        swap(p1, p2)
        swap(p0, p1)
        p0 += 1
        p1 += 1
        p2 += 1
      elif array[p2] == 1:
        swap(p1, p2)
        p1 += 1
        p2 += 1
      elif array[p2] == 2:
        p2 += 1
      else:
        swap(p2, p3)
        p3 -= 1
    
    return array
# TC: O(n); SC: O(1)    
