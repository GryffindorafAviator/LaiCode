# Medium
# Given an m * n matrix of non-negative integers representing the height of each unit cell in a continent, 
# the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
# Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
# Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean. The order of returned grid coordinates does not matter.


# Example:
# Given the following 4 * 4 matrix:
# Pacific   ~   ~    ~   ~

#      ~      1    2    2   (3)   *

#      ~      3    2    3   (4)   *

#      ~      2    4   (5)   3   *

#      ~      (6)  (7)   1   4   *

#              *    *    *    *  Atlantic
# Output: [0,3],[1,3],[2,2],[3,0],[3,1]

# Solution
from collections import deque

class Solution(object):
  def pacificAtlantic(self, matrix):
    """
    input: int[][] matrix
    return: int[][]
    """
    ROWS = len(matrix)
    COLS = len(matrix[0])
    DIRS = [[1, 0], [-1, 0], [0, 1], [0, -1]]

    pacific_reachable = set()
    pacificq = deque()
    atlantic_reachable = set()
    atlanticq = deque()

    for i in range(ROWS):
      pacific_reachable.add((i, 0))
      pacificq.append((i, 0))
      atlantic_reachable.add((i, COLS - 1))
      atlanticq.append((i, COLS - 1))
    for i in range(COLS):
      pacific_reachable.add((0, i))
      pacificq.append((0, i))
      atlantic_reachable.add((ROWS - 1, i))
      atlanticq.append((ROWS - 1, i))

    def dfs(q, reachable):
      while len(q) > 0:
        cur = q.popleft()
        for d in DIRS:
          nxtr = cur[0] + d[0]
          nxtc = cur[1] + d[1]
          if 0 <= nxtr and nxtr < ROWS and 0 <= nxtc and nxtc < COLS and (nxtr, nxtc) not in reachable and matrix[nxtr][nxtc] >= matrix[cur[0]][cur[1]]:
            reachable.add((nxtr, nxtc))
            q.append((nxtr, nxtc))
    
    dfs(pacificq, pacific_reachable)
    dfs(atlanticq, atlantic_reachable)

    ans = list(pacific_reachable & atlantic_reachable)
    for i in range(len(ans)):
      ans[i] = list(ans[i])
      
    return ans
# TC: O(m * n); SC: O(m * n)    
