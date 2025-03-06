# Medium
# Remove adjacent, 
# repeated characters in a given string, 
# leaving only two characters for each group of such characters. 
# The characters in the string are sorted in ascending order.

# Assumptions
# Try to do it in place.

# Examples
# “aaaabbbc” is transferred to “aabbc”

# Corner Cases
# If the given string is null, 
# we do not need to do anything.

# Solution
class Solution(object):
  def deDup(self, input):
    """
    input: string input
    return: string
    """
    if input is None:
      return ""
    
    n = len(input)
    if n < 3:
      return input
    
    chars = list(input)
    cur = 1
    probe = 1
    ch = chars[0]
    cnt = 1

    while probe < n:
      if chars[probe] == ch:
        if cnt < 2:
          chars[cur] = ch
          cnt += 1
          cur += 1
        else:
          cnt += 1
      else:
        ch = chars[probe]
        chars[cur] = ch
        cnt = 1
        cur += 1
      probe += 1
    
    return ''.join(chars[: cur])
# TC: O(n); SC: O(1)        
      

