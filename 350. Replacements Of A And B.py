# Medium
# Given a string with only character 'a' and 'b', 
# replace some of the characters such that the string becomes in the forms of all the 'b's are on the right side of all the 'a's.
# Determine what is the minimum number of replacements needed.

# Assumptions:
# The given string is not null.

# Examples:
# "abaab", 
# the minimum number of replacements needed is 1 (replace the first 'b' with 'a' so that the string becomes "aaaab").

# Solution
class Solution(object):
  def minReplacements(self, input):
    """
    input: string input
    return: int
    """
    n = len(input)
    if n < 2:
      return 0
      
    changes_a = [0] * n
    changes_b = [0] * n

    for i in range(n):
      if i == 0:
        if input[0] == 'b':
          changes_a[0] = 1
        if input[n - 1] == 'a':
          changes_b[n - 1] = 1
      else:
        if input[i] == 'b':
          changes_a[i] = changes_a[i - 1] + 1
        else:
          changes_a[i] = changes_a[i - 1]
        if input[n - 1 - i] == 'a':
          changes_b[n - 1 - i] = changes_b[n - i] + 1
        else:
          changes_b[n - 1 - i] = changes_b[n - i]
    
    ans = min(changes_b[0], changes_a[n - 1])

    for i in range(n - 1):
      ans = min(ans, changes_a[i] + changes_b[i + 1])
    
    return ans
# TC: O(n); SC: O(n)
