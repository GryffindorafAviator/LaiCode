# Hard
# Given a non-negative integer 2D array representing the heights of bars in a matrix. 
# Suppose each bar has length and width of 1. 
# Find the largest amount of water that can be trapped in the matrix. 
# The water can flow into a neighboring bar if the neighboring bar's height is smaller than the water's height. 
# Each bar has 4 neighboring bars to the left, 
# right, 
# up and down side.

# Assumptions
# The given matrix is not null and has size of M * N, 
# where M > 0 and N > 0, 
# all the values are non-negative integers in the matrix.

# Examples
# { { 2, 3, 4, 2 },

#   { 3, 1, 2, 3 },

#   { 4, 3, 5, 4 } }

# the amount of water can be trapped is 3, 
# at position (1, 1) there is 2 units of water trapped,
# at position (1, 2) there is 1 unit of water trapped.

# Solution
import heapq

class Solution(object):
  def maxTrapped(self, matrix):
    """
    input: int[][] matrix
    return: int
    """
    if matrix is None:
      return 0
    
    ROWS = len(matrix)
    if ROWS == 0:
      return 0
    
    COLS = len(matrix[0])
    if COLS == 0:
      return 0
    
    visited = [[False] * COLS for _ in range(ROWS)]
    min_heap = []
    for i in range(ROWS):
      heapq.heappush(min_heap, [matrix[i][0], [i, 0]])
      visited[i][0] = True
      heapq.heappush(min_heap, [matrix[i][COLS - 1], [i, COLS - 1]])
      visited[i][COLS - 1] = True
    for j in range(COLS):
      heapq.heappush(min_heap, [matrix[0][j], [0, j]])
      visited[0][j] = True
      heapq.heappush(min_heap, [matrix[ROWS - 1][j], [ROWS - 1, j]])
      visited[ROWS - 1][j] = True
    
    DIRS = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    ans = 0
    while len(min_heap) > 0:
      height, cur = heapq.heappop(min_heap)
      for di in DIRS:
        neighr = cur[0] + di[0]
        neighc = cur[1] + di[1]
        if 0 <= neighr < ROWS and 0 <= neighc < COLS and not visited[neighr][neighc]:
          if matrix[neighr][neighc] < height:
            ans += height - matrix[neighr][neighc]
          heapq.heappush(min_heap, [max(height, matrix[neighr][neighc]), [neighr, neighc]])
          visited[neighr][neighc] = True
    
    return ans
# TC: O(mn*lgmn); SC: O(mn)
