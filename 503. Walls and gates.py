# Medium
# You are given a m x n 2D grid initialized with these three possible values.
# -1 - A wall or an obstacle.
# 0 - A gate.
# INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
# Fill each empty room with the distance to its nearest gate. 
# If it is impossible to reach a gate, 
# it should be filled with INF.

# For example, given the 2D grid:
# INF  -1  0  INF
# INF INF INF  -1
# INF  -1 INF  -1
#   0  -1 INF INF

# After running your function, the 2D grid should be:
#   3  -1   0   1
#   2   2   1  -1
#   1  -1   2  -1
#   0  -1   3   4

# Solution
from collections import deque

class Solution(object):
  def wallsAndGates(self, rooms):
    """
    input: int[][] rooms
    return: int[][]
    """
    ROWS = len(rooms)
    if ROWS == 0:
      return rooms
      
    COLS = len(rooms[0])
    DIRS = [[0, 1], [0, -1], [1, 0], [-1, 0]]

    q = deque()

    for i in range(ROWS):
      for j in range(COLS):
        if rooms[i][j] == 0:
          q.append((i, j, 0))
    
    while len(q) > 0:
      l = len(q)
      for i in range(l):
        cur = q.popleft()
        dist = cur[2] + 1
        for d in DIRS:
          nxtr = cur[0] + d[0]
          nxtc = cur[1] + d[1]
          if (0 <= nxtr and nxtr < ROWS) and (0 <= nxtc and nxtc < COLS):
            if rooms[nxtr][nxtc] == 2147483647:
              rooms[nxtr][nxtc] = dist
              q.append((nxtr, nxtc, dist)) 
    
    return rooms
# TC: O(mn); SC: O(mn)
