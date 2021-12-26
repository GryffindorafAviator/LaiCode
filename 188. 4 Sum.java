// Medium
// Determine if there exists a set of four elements in a given array that sum to the given target number.

// Assumptions
// The given array is not null and has length of at least 4
  
// Examples
// A = {1, 2, 2, 3, 4}, target = 9, return true(1 + 2 + 2 + 4 = 9)
// A = {1, 2, 2, 3, 4}, target = 12, return false
  
// Solution 1
public class Solution {
  public boolean exist(int[] array, int target) {
    if (array == null || array.length < 4) {
      return false;
    }

    int len = array.length;

    Arrays.sort(array);

    for (int i = 0; i < len - 3; i++) {
      for (int j = i + 1; j < len - 2; j++) {
        int left = j + 1;
        int right = len - 1;

        while (left < right) {
          int temp = array[i] + array[j] + array[left] + array[right];

          if (temp == target) {
            return true;
          }
          else if (temp < target) {
            left++;
          }
          else {
            right--;
          }
        }
      }
    }

    return false;
  }
}
// TC: O(n^3); SC: O(1)
