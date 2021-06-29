// Easy
// Given an array containing only 0s and 1s, 
// find the length of the longest subarray of consecutive 1s.

// Assumptions

// The given array is not null
// Examples

// {0, 1, 0, 1, 1, 1, 0}, 
// the longest consecutive 1s is 3.
  
public class Solution {
  public int longest(int[] array) {
    int glbMax = 0;
    int cnt = 0;

    for (int i = 0; i < array.length; ++i) {
      if (array[i] == 1) {
        ++cnt;

        if (cnt > glbMax) {
          glbMax = cnt;
        }
      }
      else {
        cnt = 0;
      }
    }

    return glbMax;
  }
}

// TC: O(n), SC: O(1)
