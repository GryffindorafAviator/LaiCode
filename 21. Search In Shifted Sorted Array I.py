# Medium
# Given a target integer T and an integer array A, 
# A is sorted in ascending order first, 
# then shifted by an arbitrary number of positions.

# For Example, 
# A = {3, 4, 5, 1, 2} (shifted left by 2 positions). 
# Find the index i such that A[i] == T or return -1 if there is no such index.

# Assumptions
# There are no duplicate elements in the array.
  
# Examples
# A = {3, 4, 5, 1, 2}, T = 4, return 1
# A = {1, 2, 3, 4, 5}, T = 4, return 3
# A = {3, 5, 6, 1, 2}, T = 4, return -1

# Corner Cases
# What if A is null or A is of zero length? 
# We should return -1 in this case.

# Solution
class Solution(object):
  def search(self, array, target):
    """
    input: int[] array, int target
    return: int
    """
    if array is None:
      return -1
          
    n = len(array)
    if n == 0:
      return -1
    if n == 1:
      if array[0] == target:
        return 0
      else:
        return -1
    
    left = 0
    right = n - 1
    while left < right - 1:
      mid = left + (right - left) // 2
      if array[mid] == target:
        return mid
      if array[mid] > array[-1]:
        left = mid + 1
      else:
        right = mid
    
    pivot = -1
    if array[left] < array[right]:
      pivot = left
    else:
      pivot = right
    
    def binarySearch(left, right):
      while left <= right:
        mid = left + (right - left) // 2
        if target == array[mid]:
          return mid
        elif target > array[mid]:
          left = mid + 1
        else:
          right = mid - 1
      return -1

    if target > array[-1]:
      return binarySearch(0, pivot - 1)
    else:
      return binarySearch(pivot, n - 1)
# TC: O(lgn); SC: O(1)

    
    
