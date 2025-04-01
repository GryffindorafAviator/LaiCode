# Medium
# In a 2D black image there are some disjoint white objects with arbitrary shapes, 
# find the number of disjoint white objects in an efficient way.
# By disjoint, 
# it means there is no white pixels that can connect the two objects, 
# there are four directions to move to a neighbor pixel (left, right, up, down).

# Black is represented by 1’s and white is represented by 0’s.

# Assumptions
# The given image is represented by a integer matrix and all the values in the matrix are 0 or 1
# The given matrix is not null

# Examples
# the given image is
#     0  0  0  1

#     1  0  1  1

#     1  1  0  0

#     0  1  0  0

# there are 3 disjoint white objects.

# Solution
from collections import deque

class UnionFind(object):
  def __init__(self, n):
    self.ne = n
    self.parent = [i for i in range(n)]
    self.size = [1] * n
  
  def find(self, x):
    if x != self.parent[x]:
      self.parent[x] = self.find(self.parent[x])
    return self.parent[x]
  
  def union(self, x, y):
    root_x = self.find(x)
    root_y = self.find(y)
    if root_x == root_y:
      return False
    if self.size[root_x] < self.size[root_y]:
      self.parent[root_x] = root_y
      self.size[root_y] += self.size[root_x]
    else:
      self.parent[root_y] = root_x
      self.size[root_x] += self.size[root_y]
    return True

  def connected(self, x, y):
    return self.find(x) == self.find(y)
  
  # def ufSize(self):
  #   roots = set()
  #   for i in range(self.ne):
  #     roots.add(self.find(i))
  #   return len(roots)

class Solution(object):
  def whiteObjects(self, matrix):
    """
    input: int[][] matrix
    return: int
    """
    ROWS = len(matrix)
    if ROWS == 0:
      return 0
    COLS = len(matrix[0])
    DIRS = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    visited = [[False] * COLS for _ in range(ROWS)]
    q = deque()
    uf = UnionFind(ROWS * COLS)

    for i in range(ROWS):
      for j in range(COLS):
        if matrix[i][j] == 1:
          visited[i][j] = True
        elif not visited[i][j]:
          visited[i][j] = True
          q.append([i, j])
          while len(q) > 0:
            cur = q.popleft()
            cur_idx = cur[0] * COLS + cur[1]
            for d in DIRS:
              nxt_r = cur[0] + d[0]
              nxt_c = cur[1] + d[1]
              if 0 <= nxt_r and nxt_r < ROWS and 0 <= nxt_c and nxt_c < COLS and not visited[nxt_r][nxt_c]:
                visited[nxt_r][nxt_c] = True
                if matrix[nxt_r][nxt_c] == 0:
                  nxt_idx = nxt_r * COLS + nxt_c
                  uf.union(cur_idx, nxt_idx)
                  q.append([nxt_r, nxt_c])
    
    white_roots = set()
    for i in range(ROWS):
      for j in range(COLS):
        if matrix[i][j] == 0:
          root = uf.find(i * COLS + j)
          white_roots.add(root)
    
    return len(white_roots)
# TC: O(m * n); SC: O(m * n)

    
    
