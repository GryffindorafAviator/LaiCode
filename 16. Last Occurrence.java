// Medium
// Given a target integer T and an integer array A sorted in ascending order, 
// find the index of the last occurrence of T in A or return -1 if there is no such index.

// Assumptions
// There can be duplicate elements in the array.

// Examples
// A = {1, 2, 3}, T = 2, return 1
// A = {1, 2, 3}, T = 4, return -1
// A = {1, 2, 2, 2, 3}, T = 2, return 3

// Corner Cases
// What if A is null or A is array of zero length? We should return -1 in this case.

// Solution
public class Solution {
  public int lastOccur(int[] array, int target) {
    if (array == null || array.length == 0) {
      return -1;
    }

    int l = 0;
    int r = array.length - 1;

    while (l < r - 1) {
      int mid = l + (r - l) / 2;

      if (array[mid] <= target) {
        l = mid;
      }
      else {
        r = mid;
      }
    }

    if (array[r] == target) {
      return r;
    }

    if (array[l] == target) {
      return l;
    }

    return -1;
  }
}
