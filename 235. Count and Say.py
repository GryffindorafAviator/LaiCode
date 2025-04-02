# Easy
# Given a sequence of number: 
# 1, 11, 21, 1211, 111221, …

# The rule of generating the number in the sequence is as follow:
# 1 is "one 1" so 11.
# 11 is "two 1s" so 21.
# 21 is "one 2 followed by one 1" so 1211.
# Find the nth number in this sequence.

# Assumptions:
# n starts from 1, the first number is "1", 
# the second number is "11"
# n is smaller than 30

# Solution
class Solution(object):
  def countAndSay(self, n):
    """
    input: int n
    return: string
    """
    if n == 1:
      return '1'

    num = '1'
    
    for i in range(n - 1):
      temp = []
      cur = 0
      cnt = 0
      for j in range(len(num)):
        if j == 0:
          cur = int(num[j])
          cnt = 1
        elif int(num[j]) != cur:
          temp.append(str(cnt))
          temp.append(str(cur))
          cur = int(num[j])
          cnt = 1
        else:
          cnt += 1
      temp.append(str(cnt))
      temp.append(str(cur))
      num = ''.join(temp)
    
    return num
# TC: O(k * n); SC: O(k)

    
    

