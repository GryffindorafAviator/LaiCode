# Medium
# Heapify an unsorted array to min heap.

# Solution
class Solution(object):
  def heapify(self, array):
    """
    input: int[] array
    return: int[]
    """
    n = len(array)

    def percolateDown(arr, i):
      left = i * 2 + 1
      right = i * 2 + 2
      smallest = i

      if left < n and arr[left] < arr[smallest]:
        smallest = left
      if right < n and arr[right] < arr[smallest]:
        smallest = right
      if smallest != i:
        arr[i], arr[smallest] = arr[smallest], arr[i]
        percolateDown(arr, smallest)
    
    for i in range(n // 2 - 1, -1, -1):
      percolateDown(array, i)
    
    return array
# TC: O(n); SC: O(1)
