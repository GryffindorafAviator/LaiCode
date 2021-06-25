// Medium
// Given a rope with positive integer-length n, 
// how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], 
// in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? 
// m is determined by you and must be greater than 0 (at least one cut must be made). 
// Return the max product you can have.

// Assumptions

// n >= 2
// Examples

// n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).

public class Solution {
  public int maxProduct(int length) {
    if (length == 2) {
      return 1;
    }

    if (length == 3) {
      return 2;
    }

    // int numParts = length / 2;

    int[] dp = new int[length];
    dp[0] = 1;
    dp[1] = 2;
    dp[2] = 3;

    for (int i = 3; i < length; ++i) {
      int globalMax = 0;

      for (int j = 0; j < (i + 1) / 2; ++j) {
        int temp = dp[j] * dp[i - 1 - j];

        if (temp > globalMax) {
          globalMax = temp;
        }
      }

      dp[i] = globalMax;
    }

    return dp[length - 1];
  }
}

// TC: O(n^2), SC: O(n)
