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

// Solution 2
public class Solution {
  public int longest(int[] array) {
    if (array == null || array.length == 0) {
      return 0;
    }

    int len = array.length;
    int result = 1;
    int[] smlRec = new int[len + 1];
    smlRec[1] = array[0];

    for (int i = 1; i < len; ++i) {
      int distance = find(smlRec, 1, result, array[i]);

      if (distance == result) {
        ++result;
      }

      smlRec[distance + 1] = array[i];
    }

    return result;
  }

  private int find(int[] smlRec, int sh, int lo, int target) {
    while (sh < lo - 1) {
      int mid = sh + (lo - sh) / 2;
        
      if (smlRec[mid] >= target) {
        lo = mid - 1;
      }
      else {
        sh = mid;
      }
    }

    for (int i = lo; i >= sh; --i) {
        if (smlRec[i] < target) {
          return i;
        }
      }

    return 0;
  }
}

// TC: O(nlogn); SC: O(n)
