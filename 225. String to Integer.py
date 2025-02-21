# Easy
# Implement atoi to convert a string to an integer. 
# Hint: 
# Carefully consider all possible input cases. 
# If you want a challenge, 
# please do not see below and ask yourself what are the possible input cases. 
# Notes: 
# It is intended for this problem to be specified vaguely (ie, no given input specs). 
# You are responsible to gather all the input requirements up front.

# The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
# Then, 
# starting from this character, 
# takes an optional initial plus or minus sign followed by as many numerical digits as possible, 
# and interprets them as a numerical value.

# The string can contain additional characters after those that form the integral number, 
# which are ignored and have no effect on the behavior of this function.

# If the first sequence of non-whitespace characters in str is not a valid integral number, 
# or if no such sequence exists because either str is empty or it contains only whitespace characters, 
# no conversion is performed.

# If no valid conversion could be performed, 
# a zero value is returned. 
# If the correct value is out of the range of representable values, 
# return INT_MAX (2147483647) if it is positive, or INT_MIN (-2147483648) if it is negative.

# Solution
class Solution(object):
  def atoi(self, str):
    """
    input: string str
    return: int
    """
    start = False
    negative = False
    n = len(str)
    result = 0

    for i in range(n):
      if not start:
        if str[i].isnumeric():
          d = int(str[i])
          if d != 0:
            result += d
            start = True
            if i > 0 and str[i - 1] == '-':
              negative = True
      else:
        if str[i].isnumeric():
          d = int(str[i])
          result = result * 10 + d
        else:
          break
    
    result = result if not negative else -result
    if result < -2147483648:
      return -2147483648
    elif 2147483647 < result:
      return 2147483647
    else:
      return result
# TC: O(n); SC: O(1)
          
          
