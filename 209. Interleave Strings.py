# Medium
# Given three strings A, 
# B and C. 
# Determine if C can be created by merging A and B in a way that maintains the relative order of the characters in A and B.

# Assumptions
# none of A, 
# B, 
# C is null

# Examples
# C = "abcde", 
# A = "acd", 
# B = "be", 
# return true

# C = "abcde", 
# A = "adc", 
# B = "be", 
# return false

# Solution
class Solution(object):
  def canMerge(self, a, b, c):
    """
    input: string a, string b, string c
    return: boolean
    """
    na = len(a)
    nb = len(b)

    if na + nb != len(c):
      return False

    dp = [[False] * (nb + 1) for _ in range(na + 1)]

    for i in range(na + 1):
      for j in range(nb + 1):
        if i == 0 and j == 0:
          dp[i][j] = True
        elif i == 0:
          dp[i][j] = dp[i][j - 1] and b[j - 1] == c[j - 1]
        elif j == 0:
          dp[i][j] = dp[i - 1][j] and a[i - 1] == c[i - 1]
        else:
          dp[i][j] = (dp[i - 1][j] and a[i - 1] == c[i + j - 1]) or (dp[i][j - 1] and b[j - 1] == c[i + j - 1])
    
    return dp[na][nb]
# TC: O(m * n); SC: O(m * n)
