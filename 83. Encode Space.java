// Easy
// In URL encoding, whenever we see an space " ", 
// we need to replace it with "20%". 
// Provide a method that performs this encoding for a given string.

// Examples
// "google/q?flo wer market" → "google/q?flo20%wer20%market"
  
// Corner Cases
// If the given string is null, 
// we do not need to do anything.
  
// Solution
public class Solution {
  public String encode(String input) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);

      if (ch == ' ') {
        sb.append("20%");
      }
      else {
        sb.append(ch);
      }
    }

    return sb.toString();
  }
}
// TC: O(n); SC: O(n)
