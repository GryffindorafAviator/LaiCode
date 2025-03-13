# Medium
# Given a string in compressed form, 
# decompress it to the original string. 
# The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences. 
# If the character does not have any adjacent repeated occurrences, 
# it is not compressed.

# Assumptions
# The string is not null
# The characters used in the original string are guaranteed to be ‘a’ - ‘z’
# There are no adjacent repeated characters with length > 9

# Examples
# “acb2c4” → “acbbcccc”

# Solution
class Solution(object):
  def decompress(self, input):
    """
    input: string input
    return: string
    """
    ans = []
    n = len(input)
    if n < 2:
      return input
    
    i = 0
    while i < n:
      if i < n - 1:
        if input[i + 1].isdigit():
          m = int(input[i + 1])
          for j in range(m):
            ans.append(input[i])
          i += 1
        else:
          ans.append(input[i])
      else:
        ans.append(input[i])
      i += 1

    return ''.join(ans)
# TC: O(n); SC: O(1)
