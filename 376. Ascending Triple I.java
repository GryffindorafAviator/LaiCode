// Easy
// Determine if the given integer array has three indices such that i < j < k and a[i] < a[j] < a[k].

// Assumptions:
// The given array is not null.
  
// Examples:
// {1, 5, 2, 4}, return true since i = 0, j = 2, k = 3
// {4, 3, 2, 1}, return false
  
// Solution
public class Solution {
  public boolean existIJK(int[] array) {
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;

    for (int i = 0; i < array.length; i++) {
      if (array[i] <= min1) {
        min1 = array[i];
      }
      else if (array[i] <= min2) {
        min2 = array[i];
      }
      else {
        return true;
      }
    }

    return false;
  }
}
// TC: O(n); SC: O(1)
