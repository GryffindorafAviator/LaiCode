# Medium
# Given a string S, 
# find the longest palindromic substring in S.

# Assumptions
# There exists one unique longest palindromic substring.    
# The input S is not null.

# Examples
# Input: "abbc"
# Output: "bb"

# Input: "abcbcbd"
# Output: "bcbcb"

# Solution
class Solution(object):
  def longestPalindrome(self, input):
    """
    input: string input
    return: string
    """
    n = len(input)
    if n < 2:
      return input

    ans = [0, 0]
    length = 1

    for i in range(n):
      r1 = min(i, n - 1 - i)
      for j in range(1, r1 + 1):
        if input[i - j] == input[i + j]:
          if 2 * j + 1 > length:
            ans = [i - j, i + j]
            length = 2 * j + 1
        else:
          break
      if i < n - 1 and input[i] == input[i + 1]:
        if length < 2:
          ans = [i, i + 1]
          length = 2
        r2 = min(i, n - i - 2)
        for j in range(1, r2 + 1):
          if input[i - j] == input[i + 1 + j]:
            if 2 * (j + 1) > length:
              ans = [i - j, i + 1 + j]
              length = 2 * (j + 1)
          else:
            break
      
    return input[ans[0] : ans[1] + 1]
# TC: O(n^2); SC: O(1)
      
