// Hard
// Repeatedly remove all adjacent, 
// repeated characters in a given string from left to right.

// No adjacent characters should be identified in the final string.

// Examples

// "abbbaaccz" → "aaaccz" → "ccz" → "z"
// "aabccdc" → "bccdc" → "bdc"

public class Solution {
  public String deDup(String input) {
    if (input == null || (input.length() < 2))  {
      return input;
    }

    char[] inArr = input.toCharArray();

    return helper(inArr);
  }

  private String helper(char[] inArr) {
    int end = 0;

    for (int i = 1; i < inArr.length; ++i) {
      if (end == -1 || inArr[i] != inArr[end]) {
        inArr[++end] = inArr[i];
      }
      else {
        --end;
        while (i < inArr.length - 1 && inArr[i] == inArr[i + 1]) {
          ++i;
        }
      } 
    }

    return new String(inArr, 0, end + 1);
  }
}

// TC: O(n), SC: O(1)
