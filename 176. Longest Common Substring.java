// Medium
// Find the longest common substring of two given strings.

// Assumptions
// The two given strings are not null
  
// Examples
// S = “abcde”, 
// T = “cdf”, 
// the longest common substring of S and T is “cd”

// Solution
public class Solution {
  public String longestCommon(String source, String target) {
    if (source == null || target == null) {
      return null;
    }

    char[] sArr = source.toCharArray();
    char[] tArr = target.toCharArray();

    int start = 0;
    int longest = 0;
    int[][] same = new int[sArr.length][tArr.length];

    for (int i = 0; i < sArr.length; i++) {
      for (int j = 0; j < tArr.length; j++) {
        if (sArr[i] == tArr[j]) {
          if (i == 0 || j == 0) {
            same[i][j] = 1;
          }
          else {
            same[i][j] = same[i - 1][j - 1] + 1;
          }

          if (same[i][j] > longest) {
            longest = same[i][j];
            start = i - longest + 1;
          }
        }
      }
    }

    return source.substring(start, start + longest);
  }
}
// TC: O(n^2); SC: O(n^2)

// Solution 2
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

    int[][] same = new int[sLen + 1][tLen + 1];

    for (int i = 1; i <= sLen; i++) {
      for (int j = 1; j <= tLen; j++) {
        if (source.charAt(i - 1) == target.charAt(j - 1)) {
          same[i][j] = same[i - 1][j - 1] + 1;
        }
        else {
          same[i][j] = Math.max(same[i - 1][j], same[i][j - 1]);
        }
      }
    }

    return same[sLen][tLen];
  }
}
// TC: O(n^2); SC: O(n^2)
