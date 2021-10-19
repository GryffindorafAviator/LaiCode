// Easy
// Given an integer array of length L, 
// find the number that occurs more than 0.5 * L times.

// Assumptions
// The given array is not null or empty
// It is guaranteed there exists such a majority number

// Examples
// A = {1, 2, 1, 2, 1}, return 1
  
// Solution
public class Solution {
  public int majority(int[] array) {
    int ans = array[0];
    int cnt = 1;

    for (int i = 1; i < array.length; ++i) {
      if (cnt == 0) {
        ans = array[i];
        ++cnt;
      }
      else if (ans == array[i]) {
        ++cnt;
      }
      else {
        --cnt;
      }
    }

    return ans;
  }
}

// TC: O(n); SC: O(1)
