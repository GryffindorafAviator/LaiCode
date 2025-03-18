# Medium
# Given a gym with k pieces of equipment without any obstacles.  
# Let’s say we bought a chair and wanted to put this chair into the gym such that the sum of the shortest path cost from the chair to the k pieces of equipment is minimal. 
# The gym is represented by a char matrix, 
# ‘E’ denotes a cell with equipment, 
# ' ' denotes a cell without equipment. 
# The cost of moving from one cell to its neighbor(left, right, up, down) is 1. 
# You can put chair on any cell in the gym.

# Assumptions
# There is at least one equipment in the gym
# The given gym is represented by a char matrix of size M * N, 
# where M >= 1 and N >= 1, 
# it is guaranteed to be not null

# ​Examples
# { { 'E', ' ', ' ' },

#   {  ' ', 'E',  ' ' },

#   {  ' ',  ' ', 'E' } }
# we should put the chair at (1, 1), 
# so that the sum of cost from the chair to the two equipments is 2 + 0 + 2 = 4, 
# which is minimal.

# Solution
class Solution(object):
  def putChair(self, gym):
    """
    input: char[][] gym
    return: Integer[]
    """
    ROWS = len(gym)
    COLS = len(gym[0])

    row_idx_cnt = [0] * ROWS
    col_idx_cnt = [0] * COLS
    cnt = 0

    for i in range(ROWS):
      for j in range(COLS):
        if gym[i][j] == 'E':
          cnt += 1
          row_idx_cnt[i] += 1
          col_idx_cnt[j] += 1
    
    median = cnt // 2 + 1

    ans = [0, 0]
    temp = 0
    for i in range(ROWS):
      temp += row_idx_cnt[i]
      if temp >= median:
        ans[0] = i
        break
    temp = 0
    for i in range(COLS):
      temp += col_idx_cnt[i]
      if temp >= median:
        ans[1] = i
        break
    
    return ans
# TC: O(n * m); SC: O(n * m)


