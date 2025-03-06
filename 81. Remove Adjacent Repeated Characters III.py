# Medium
# Remove adjacent, 
# repeated characters in a given string, 
# leaving no character for each group of such characters. 
# The characters in the string are sorted in ascending order.

# Assumptions
# Try to do it in place.

# Examples
# “aaaabbbc” is transferred to “c”

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
      return None
    
    n = len(input)
    if n < 2:
      return input
    
    chars = list(input)
    ch = chars[0]
    cur = 0
    probe = 1
    cnt = 1

    while probe < n:
      if chars[probe] == ch:
        cnt += 1
      else:
        if cnt == 1:
          chars[cur] = ch
          cur += 1
        ch = chars[probe]
        cnt = 1
      probe += 1
    
    if cnt == 1:
      chars[cur] = ch
      cur += 1
    
    return ''.join(chars[: cur])
# TC: O(n); SC: O(1)
