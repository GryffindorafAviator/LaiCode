// Medium
// Given a non-negative integer array representing the heights of a list of adjacent bars. 
// Suppose each bar has a width of 1. 
// Find the largest amount of water that can be trapped in the histogram.

// Assumptions

// The given array is not null
// Examples

// { 2, 1, 3, 2, 4 }, 
// the amount of water can be trapped is 1 + 1 = 2 (at index 1, 1 unit of water can be trapped and index 3, 
// 1 unit of water can be trapped)

public class Solution {
  public int maxTrapped(int[] array) {
    if (array.length < 3) {
      return 0;
    }

    int left = 0;
    int right = array.length - 1;
    int leftMax = array[left];
    int rightMax = array[right];
    int water = 0;

    while (left < right) {
      if (leftMax <= rightMax) {
        if (array[left] < leftMax) {
          water += leftMax - array[left];
        }

        ++left;

        if (array[left] > leftMax) {
          leftMax = array[left];
        }
      }
      else {
        if (array[right] < rightMax) {
          water += rightMax - array[right];
        }

        --right;

        if (array[right] > rightMax) {
          rightMax = array[right];
        }
      }
    }

    return water;
  }
}

// TC: O(n), SC: O(1)
