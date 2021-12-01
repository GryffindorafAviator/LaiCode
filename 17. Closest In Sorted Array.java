// Medium
// Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

// Assumptions
// There can be duplicate elements in the array, and we can return any of the indices with same value.

// Examples
// A = {1, 2, 3}, T = 2, return 1
// A = {1, 4, 6}, T = 3, return 1
// A = {1, 4, 6}, T = 5, return 1 or 2
// A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2

// Corner Cases
// What if A is null or A is of zero length? We should return -1 in this case.

// Solution 1
public class Solution {
  public int closest(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }

    int l = 0;
    int r = array.length - 1;
    int dis = 100000;
    int ans = 0;
    
    while (l <= r) {
      int mid = l + (r - l) / 2;
      
      if (array[mid] == target) {
        return mid;
      }
      else if (array[mid] > target) {
        if ((array[mid] - target) < dis) {
          dis = array[mid] - target; 
          ans = mid;
          r = mid - 1;
        }
        else {
          r = mid - 1;
        }
      }
      else {
        if (target - array[mid] < dis) {
          dis = target - array[mid];
          ans = mid;
          l = mid + 1;
        }
        else {
          l = mid + 1;
        }
      }
    }
    return ans;
  }
}

// Solution 2
public class Solution {
  public int closest(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }

    int lt = 0;
    int rt = array.length - 1;

    while (lt < rt - 1) {
      int mid = lt + (rt - lt) / 2;

      if (array[mid] == target) {
        return mid;
      }
      else if (array[mid] > target) {
        rt = mid;
      }
      else {
        lt = mid;
      }
    }

    if (target < array[lt]) {
      return lt;
    }
    else if (array[rt] < target) {
      return rt;
    }
    else {
      if ((target - array[lt]) < (array[rt] - target)) {
        return lt;
      }
      else {
        return rt;
      }
    }
  }
}
