# Medium
# Given three arrays, 
# determine if a set can be made by picking one element from each array that sums to the given target number.

# Assumptions
# The three given arrays are not null and have length of at least 1

# Examples
# A = {1, 3, 5}
# B = {8, 2}
# C = {3}
# target = 14
# return true(pick 3 from A, pick 8 from B and pick 3 from C)

# Solution
class Solution(object):
  def exist(self, a, b, c, target):
    """
    input: int[] a, int[] b, int[] c, int target
    return: boolean
    """
    a.sort()
    b.sort()
    c.sort()
    na = len(a)
    nb = len(b)
    nc = len(c)

    def helper(a1, a2, a3, n1, n2, n3):
      for i in range(n1):
        for j in range(n2):
          s = a1[i] + a2[j]
          left = 0
          right = n3 - 1
          while left <= right:
            mid = left + (right - left) // 2
            if s + a3[mid] == target:
              return True
            elif s + a3[mid] < target:
              left = mid + 1
            else:
              right = mid - 1
      return False
    
    n = max(na, nb, nc)
    if na == n:
      return helper(b, c, a, nb, nc, na)
    elif nb == n:
      return helper(a, c, b, na, nc, nb)
    else:
      return helper(a, b, c, na, nb, nc)
# TC: O(nmlgk); SC: O(1)
