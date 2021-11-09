// Medium
// Given an original string input, 
// and two strings S and T, 
// from left to right replace all occurrences of S in input with T.

// Assumptions
// input, S and T are not null, S is not empty string

// Examples
// input = "appledogapple", 
// S = "apple", 
// T = "cat", 
// input becomes "catdogcat"
  
// input = "laicode", 
// S = "code", 
// T = "offer", 
// input becomes "laioffer"
  
// Solution 
public class Solution {
  public String replace(String input, String source, String target) {
    if (input.length() == 0 || input.length() < source.length()) {
      return input;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      if (i <= (input.length() - source.length()) && equals(input, source, i)) {
        for (int j = 0; j < target.length(); j++) {
          sb.append(target.charAt(j));
        }

        i += (source.length() - 1);
      }
      else {
        sb.append(input.charAt(i));
      }
    }

    return sb.toString();
  }

  private boolean equals(String input, String source, int idx) {
    for (int i = 0; i < source.length(); i++) {
      if (source.charAt(i) != input.charAt(idx + i)) {
        return false;
      }
    }

    return true;
  }
}

// TC: O(n^3); SC: O(n)
