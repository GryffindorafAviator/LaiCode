// Medium
// Given a target integer T, 
// a non-negative integer K and an integer array A sorted in ascending order, 
// find the K closest numbers to T in A. 
// If there is a tie, 
// the smaller elements are always preferred.

// Assumptions
// A is not null
// K is guranteed to be >= 0 and K is guranteed to be <= A.length

// Return
// A size K integer array containing the K closest numbers(not indices) in A, 
// sorted in ascending order by the difference between the number and T. 
  
// Examples
// A = {1, 2, 3}, T = 2, K = 3, return {2, 1, 3} or {2, 3, 1}
// A = {1, 4, 6, 8}, T = 3, K = 3, return {4, 1, 6}

// Solution

public class Solution {
  public int[] kClosest(int[] array, int target, int k) {
    if (array == null || array.length == 0 || k == 0) {
      return new int[0];
    }

    int left = 0;
    int right = array.length - 1;
    int[] ans = new int[k];
    boolean noExactValue = true;

    while (left < right - 1) {
      int mid = left + (right - left) / 2;

      if (array[mid] == target) {
        noExactValue = false;
        put(array, ans, mid, target, k);

        break;
      }
      else if (array[mid] < target) {
        left = mid;
      }
      else {
        right = mid;
      }
    }

    if (noExactValue) {
      if (array[right] - target <= target - array[left]) {
        put(array, ans, right, target, k);
     }
      else {
        put(array, ans, left, target, k);
      }
    }

    return ans;
  }

  private void put(int[] array, int[] ans, int idx, int target, int k) {
    int i = 0;
    int left = idx - 1;
    int right = idx + 1;

    ans[i] = array[idx];
    i++;

    while (i < k && left >= 0 && right < array.length) {
      if (target - array[left] <= array[right] - target) {
        ans[i] = array[left];
        left--;
      }
      else {
        ans[i] = array[right];
        right++;
      }

      i++;
    }

    while (left < 0 && i < k) {
      ans[i] = array[right];

      right++;
      i++;
    }

    while (right >= array.length && i < k) {
      ans[i] = array[left];

      left--;
      i++;
    }
  }
}

// TC: O(logn + k), average case; O(n), worst case
// SC: O(1)
