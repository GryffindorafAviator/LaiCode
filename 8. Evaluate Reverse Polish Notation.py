# Medium
# Evaluate the value of an arithmetic expression in Reverse Polish Notation.

# Assumption
# Valid operators are +, -, *, /.
# Each operand may be an integer or another expression.
  
# Examples
# ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
# ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6

# Solution
class Solution(object):
  def evalRPN(self, tokens):
    """
    input: string[] tokens
    return: int
    """
    operator = ['+', '-', '*', '/']
    stack = []
    ans = 0

    for t in tokens:
      if t not in operator:
        stack.append(int(t))
      else:
        op2 = stack.pop(-1)
        op1 = stack.pop(-1)
        if t == '+':
          temp = op1 + op2
        elif t == '-':
          temp = op1 - op2
        elif t == '*':
          temp = op1 * op2
        else:
          temp = op1 // op2
        stack.append(temp)
    
    return stack[-1]
TC: O(n); SC: O(n)
