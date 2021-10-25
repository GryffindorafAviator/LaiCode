// Medium
// Given an array A[0]...A[n-1] of integers, 
// find out the length of the longest ascending subsequence.

// Assumptions
// A is not null
  
// Examples
// Input: A = {5, 2, 6, 3, 4, 7, 5}
// Output: 4
// Because [2, 3, 4, 5] is the longest ascending subsequence.
  
// Solution 1
public class Solution {
  public int longest(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int len = array.length;
    int ans = 1;
    int[] longLen = new int[len];

    for (int i = 0; i < len; ++i) {
      longLen[i] = 1;

      for (int j = 0; j < i; ++j) {
        if (array[j] < array[i]) {
          longLen[i] = Math.max(longLen[i], longLen[j] + 1);
        }
      }

      ans = Math.max(ans, longLen[i]);
    }

    return ans; 
  }
}

// TC: O(n^2); SC: O(n)
