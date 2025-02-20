# Medium
# Given a binary min heap in array format. 
# Update the element at a specified index.

# Assumptions:
# The given array is not null or empty.
# The specified index is guaranteed to be within the range.

# Examples:
# array = {1, 2, 3, 4}, 
# update the element at index 1 to 5, 
# the array becomes {1, 4, 3, 5}

# Solution
class Solution(object):
  def updateHeap(self, array, index, ele):
    """
    input: int[] array, int index, int ele
    return: int[]
    """
    array[index] = ele
    n = len(array)
 
    parent = (index - 1) // 2
    if parent >= 0 and ele < array[parent]:
      child = index
      while parent >= 0:
        if array[child] < array[parent]:
          array[child], array[parent] = array[parent], array[child]
          child = parent
          parent = (child - 1) // 2
        else:
          break
    else:
      parent = index
      leftChild = (index * 2) + 1
      rightChild = (index * 2) + 2
      while leftChild < n:
        if rightChild < n and array[leftChild] > array[rightChild]:
          smallest = rightChild
        else:
          smallest = leftChild
        if array[parent] > array[smallest]:
          array[parent], array[smallest] = array[smallest], array[parent]
          parent = smallest
          leftChild = (parent * 2) + 1
          rightChild = (parent * 2) + 2
        else:
          break
    
    return array
# TC: O(lgn); SC: O(1)


