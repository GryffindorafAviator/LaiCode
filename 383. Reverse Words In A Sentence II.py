# Medium
# Reverse the words in a sentence and truncate all heading/trailing/duplicate space characters.

# Examples
# “ I  love  Google  ” → “Google love I”

# Corner Cases
# If the given string is null, 
# we do not need to do anything.

# Solution
class Solution(object):
  def reverseWords(self, input):
    """
    input: string input
    return: string
    """
    if input is None:
      return input
    
    n = len(input)
    stack_sentence = []
    start = False
    for c in input:
      if not start and c == ' ':
        continue
      else:
        start = True
        if (c == ' ' and stack_sentence[-1] != ' ') or c != ' ':
          stack_sentence.append(c)
    
    if len(stack_sentence) > 0 and stack_sentence[-1] == ' ':
      stack_sentence.pop(-1)
    stack_word = []
    ans = []
    while len(stack_sentence) > 0:
      if stack_sentence[-1] != ' ':
        stack_word.append(stack_sentence.pop(-1))
      else:
        stack_sentence.pop(-1)
        word = []
        while len(stack_word) > 0:
          word.append(stack_word.pop(-1))
        ans.append(''.join(word))
    if len(stack_word) > 0:
      word = []
      while len(stack_word) > 0:
        word.append(stack_word.pop(-1))
      ans.append(''.join(word))
    
    return ' '.join(ans)
 # TC: O(n); SC: O(n)   

        

        

    
