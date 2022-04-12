// Medium
// Given an array A of non-negative integers, 
// you are initially positioned at index 0 of the array. 
// A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). 
// Determine if you are able to reach the last index.

// Assumptions
// The given array is not null and has length of at least 1.

// Examples
// {1, 3, 2, 0, 3}, 
// we are able to reach the end of array(jump to index 1 then reach the end of the array)

// {2, 1, 1, 0, 2}, 
// we are not able to reach the end of array

// Solution
public class Solution {
  public boolean canJump(int[] array) {
    if (array.length == 1) {
      return true;
    }
    // boolean[] dp = new boolean[array.length];
    boolean ans = true;

    int trueIndex = array.length - 1;

    for (int i = trueIndex - 1; i >= 0; i--) {
      if (array[i] >= trueIndex - i) {
        ans = true;

        if (i < trueIndex) {
          trueIndex = i;
        }
      }
      else {
        ans = false;
      }
    }

    return ans;
  }
}
// TC: O(n), SC: O(1)
