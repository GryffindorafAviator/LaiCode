# Medium
# Given two arrays A and B, 
# determine whether or not there exists a pair of elements, 
# one drawn from each array, 
# that sums to the given target number.

# Assumptions
# The two given arrays are not null and have length of at least 1

# Examples
# A = {3, 1, 5}
# B = {2, 8}
# target = 7
# return true(pick 5 from A and pick 2 from B)

# A = {1, 3, 5}
# B = {2, 8}
# target = 6
# return false

# Solution
class Solution(object):
  def existSum(self, a, b, target):
    """
    input: int[] a, int[] b, int target
    return: boolean
    """
    a.sort()
    b.sort()
    na = len(a)
    nb = len(b)

    def helper(arr1, arr2, n1, n2):
      for i in range(n1):
        left = 0
        right = n2 - 1
        while left <= right:
          mid = left + (right - left) // 2
          if arr1[i] + arr2[mid] == target:
            return True
          elif arr1[i] + arr2[mid] < target:
            left = mid + 1
          else:
            right = mid - 1
      return False

    if na < nb:
      return helper(a, b, na, nb)
    else:
      return helper(b, a, nb, na)
# TC: O(nlgn); SC: O(1)
