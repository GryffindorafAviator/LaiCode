// Easy
// Given an unsorted array, find the length of the longest subarray in which the numbers are in ascending order.

// Assumptions

// The given array is not null
// Examples

// {7, 2, 3, 1, 5, 8, 9, 6}, longest ascending subarray is {1, 5, 8, 9}, length is 4.

// {1, 2, 3, 3, 4, 4, 5}, longest ascending subarray is {1, 2, 3}, length is 3.
  
public class Solution {
  public int longest(int[] array) {
    if (array.length == 0) {
      return 0;
    }

    int[] dp = new int[array.length];
    dp[0] = 1;
    int i = 1;
    int globalMax = 1;

    while (i < array.length) {
      if (array[i] > array[i - 1]) {
        dp[i] = dp[i - 1] + 1;

        if (dp[i] > globalMax) {
          globalMax = dp[i];
        }
      }
      else {
        dp[i] = 1;
      }

      ++i;
    }

    return globalMax;
  }
}

// TC: O(n), SC: O(n)
