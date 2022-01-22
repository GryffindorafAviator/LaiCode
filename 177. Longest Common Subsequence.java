// Medium
// Find the length of longest common subsequence of two given strings.

// Assumptions
// The two given strings are not null
  
// Examples
// S = “abcde”, 
// T = “cbabdfe”, 
// the longest common subsequence of s and t is {‘a’, ‘b’, ‘d’, ‘e’}, 
// the length is 4.
  
// Solution 1
public class Solution {
  public int longest(String source, String target) {
    if (source == null || target == null) {
      return 0;
    }

    int sLen = source.length();
    int tLen = target.length();

    if (sLen == 0 || tLen == 0) {
      return 0;
    }

    int[][] same = new int[sLen][tLen];

    for (int i = 0; i < sLen; i++) {
      for (int j = 0; j < tLen; j++) {
        if (source.charAt(i) == target.charAt(j)) {
          if (i == 0 || j == 0) {
            same[i][j] = 1;
          }
          else {
            same[i][j] = same[i - 1][j - 1] + 1;
          }
        }
        else if (i == 0 && j == 0) {
          same[i][j] = 0;
        }
        else if (i == 0) {
          same[i][j] = same[i][j - 1];
        }
        else if (j == 0) {
          same[i][j] = same[i - 1][j];
        }
        else {
          same[i][j] = Math.max(same[i - 1][j], same[i][j - 1]);
        }
      }
    }

    return same[sLen - 1][tLen - 1];
  }
}
// TC: O(n^2); SC: O(n^2)
