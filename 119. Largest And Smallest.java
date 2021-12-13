// Medium
// Use the least number of comparisons to get the largest and smallest number in the given integer array. 
// Return the largest number and the smallest number.

// Assumptions
// The given array is not null and has length of at least 1
  
// Examples
// {2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. 
// return [5, 1].
  
// Solution
public class Solution {
  public int[] largestAndSmallest(int[] array) {
    if (array == null) {
      return array;
    }

    int[] ans = new int[2];
    int n = array.length;

    for (int i = 0; i < n / 2; i++) {
      if (array[i] > array[n - 1]) {
        swap(array, i, n - 1);
      }
    }

    ans[0] = findLargest(array, n / 2, n - 1);
    ans[1] = findSmallest(array, 0, (n - 1) / 2);

    return ans;
  }

  private int findSmallest(int[] array, int left, int right) {
    int min = array[left];

    for (int i = left + 1; i <= right; i++) {
      min = Math.min(array[i], min);
    }

    return min;
  }

  private int findLargest(int[] array, int left, int right) {
    int max = array[left];

    for (int i = left + 1; i <= right; i++) {
      max = Math.max(array[i], max);
    }

    return max;
  }

  private void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }
}

// TC: O(1.5n); SC: O(1)
