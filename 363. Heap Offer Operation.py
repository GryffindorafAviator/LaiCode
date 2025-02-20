# Easy
# Given a binary min heap in array format. 
# The last cell of the array is not used.
# Now offer a new element into the heap.

# Assumptions:
# The given array is not null and has length >= 1

# Examples:
# array = {2, 3, 4, 0}, offer(1) --> {1, 2, 4, 3}

# Solution
class Solution(object):
  def offerHeap(self, array, ele):
    """
    input: int[] array, int ele
    return: int[]
    """
    n = len(array)
    array[n - 1] = ele
    child = n - 1
    parent = (child - 1) // 2

    while parent >= 0:
      if array[child] < array[parent]:
        array[child], array[parent] = array[parent], array[child]
        child = parent
        parent = (child - 1) // 2
      else:
        break
    
    return array
# TC: O(lgn); SC: O(1)
