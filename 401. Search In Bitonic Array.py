# Medium
# Search for a target number in a bitonic array, 
# return the index of the target number if found in the array, 
# or return -1.

# A bitonic array is a combination of two sequence: 
# the first sequence is a monotonically increasing one and the second sequence is a monotonically decreasing one.

# Assumptions:
# The array is not null.
  
# Examples:
# array = {1, 4, 7, 11, 6, 2, -3, -8}, 
# target = 2, 
# return 5.

# Solution
class Solution(object):
  def search(self, array, target):
    """
    input: int[] array, int target
    return: int
    """
    n = len(array)
    if n == 0:
      return -1
    if n == 1:
      if array[0] == target:
        return 0
      else:
        return -1
    
    fir_str = 0
    fir_end = 0
    sec_str = 0
    sec_end = n - 1

    whole_dec = False

    fir_ans = -1
    sec_ans = -1

    for i in range(n - 1):
      if array[i] > array[i + 1]:
        if i == 0:
          whole_dec = True
          break
        else:
          fir_end = i
          sec_str = i + 1
          break

    if fir_end == sec_str:
      if whole_dec:
        fir_ans = self.dec_binary_search(0, n - 1, array, target)
      else:
        sec_ans = self.inc_binary_search(0, n - 1, array, target)
    else:
      if array[fir_str] <= target and target <= array[fir_end]:
        fir_ans = self.inc_binary_search(fir_str, fir_end, array, target)

      if array[sec_str] >= target and target >= array[sec_end]:
        sec_ans = self.dec_binary_search(sec_str, sec_end, array, target)

    return fir_ans if fir_ans != -1 else sec_ans
  
  def inc_binary_search(self, left, right, array, target):
    while left <= right:
      mid = left + (right - left) // 2
      if array[mid] == target:
        return mid
      elif array[mid] < target:
        left = mid + 1
      else:
        right = mid - 1
    return -1
  
  def dec_binary_search(self, left, right, array, target):
    while left <= right:
      mid = left + (right - left) // 2
      if array[mid] == target:
        return mid
      elif array[mid] > target:
        left = mid + 1
      else:
        right = mid - 1
    return -1

