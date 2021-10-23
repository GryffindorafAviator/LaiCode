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
