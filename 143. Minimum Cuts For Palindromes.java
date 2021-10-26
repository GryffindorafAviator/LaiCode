// Medium
// Given a string, 
// a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome. 
// Determine the fewest cuts needed for a palindrome partitioning of a given string.

// Assumptions
// The given string is not null
  
// Examples
// “a | babbbab | bab | aba” is a palindrome partitioning of “ababbbabbababa”.
// The minimum number of cuts needed is 3.
  
// Solution 1
public class Solution {
  public int minCuts(String input) {
    if (input == null || input.length() < 2) {
      return 0;
    }

    int len = input.length();
    int[] cutCnt = new int[input.length() + 1];

    cutCnt[0] = 0;
    cutCnt[1] = 0;

    for (int i = 2; i <= len; ++i) {
      int minCut = Integer.MAX_VALUE;

      for (int j = 0; j < i; ++j) {
        if (isPalindrome(input, j, i - 1)) {
          minCut = j == 0 ? 0 : Math.min(minCut, cutCnt[j] + 1);
        }
      }

      cutCnt[i] = minCut;
    }

    return cutCnt[len];
  }

  private boolean isPalindrome(String input, int i, int j) {
    while (i < j) {
      if (input.charAt(i) != input.charAt(j)) {
        return false;
      }

      ++i;
      --j;
    }

    return true;
  }
}

// TC: O(n^3); SC: O(n)

// Solution2
public class Solution {
  public int minCuts(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }

    int len = input.length();
    int[] minCut = new int[len];
    boolean[][] isPalin = new boolean[len][len];

    for (int i = 0; i < len; ++i) {
      minCut[i] = i;

      for (int j = 0; j <= i; ++j) {
        if (input.charAt(i) == input.charAt(j) && (i - j < 3 || isPalin[i - 1][j + 1])) {
          isPalin[i][j] = true;

          minCut[i] = j == 0 ? 0 : Math.min(minCut[i], minCut[j - 1] + 1);
        } 
      }
    }

    return minCut[len - 1]; 
  }
}

// TC: O(n^2); SC: O(n^2)

// Solution 3
public class Solution {
  public int minCuts(String input) {
    if (input == null || input.length() == 0) {
      return 0;
    }

    int len = input.length();
    int[] cutCnt = new int[len + 1];

    for (int i = 0; i <= len; ++i) {
      cutCnt[i] = i - 1;
    }

    for (int i = 0; i < len; ++i) {
      for (int j = 0; i - j >= 0 && i + j < len && input.charAt(i - j) == input.charAt(i + j); ++j) {
        cutCnt[i + j + 1] = Math.min(cutCnt[i + j + 1], cutCnt[i - j] + 1);
      }

      for (int j = 0; i - j - 1 >= 0 && i + j < len && input.charAt(i - j - 1) == input.charAt(i + j); ++j) {
        cutCnt[i + j + 1] = Math.min(cutCnt[i + j + 1], cutCnt[i - j - 1] + 1);
      }
    }

    return cutCnt[len];
  }
}
// TC: O(n^2); SC: O(n) 
