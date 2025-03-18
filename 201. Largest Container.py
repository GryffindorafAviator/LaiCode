# Medium
# Given an array of non-negative integers, 
# each of them representing the height of a board perpendicular to the horizontal line, 
# the distance between any two adjacent boards is 1. 
# Consider selecting two boards such that together with the horizontal line they form a container. 
# Find the volume of the largest such container.

# Assumptions
# The given array is not null and has size of at least 2

# Examples
# { 2, 1, 3, 1, 2, 1 }, 
# the largest container is formed by the two boards of height 2, 
# the volume of the container is 2 * 4 = 8.

# Solution
class Solution(object):
  def largest(self, array):
    """
    input: int[] array
    return: int
    """
    n = len(array)
    ans = 0
    left = 0
    right = n - 1

    while left < right:
      height = min(array[left], array[right])
      ans = max(ans, height * (right - left))
      if array[left] > array[right]:
        right -= 1
      else:
        left += 1
    
    return ans
# TC: O(n); SC: O(1)
