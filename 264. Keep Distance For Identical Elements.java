// Medium
// Given an integer k, 
// arrange the sequence of integers [1, 1, 2, 2, 3, 3, ...., k - 1, k - 1, k, k], 
// such that the output integer array satisfy this condition:

// Between each two i's, they are exactly i integers 
// (for example: between the two 1s, there is one number, 
// between the two 2's there are two numbers).

// If there does not exist such sequence, return null.

// Assumptions:
// k is guaranteed to be > 0
 
// Examples:
// k = 3, 
// The output = { 2, 3, 1, 2, 1, 3 }.
 
// Solution
public class Solution {
  public int[] keepDistance(int k) {
    int[] ans = new int[2 * k];

    return helper(ans, k) ? ans : null;
  }

  private boolean helper(int[] ans, int dist) {
    if (dist == 0) {
      return true;
    }

    for (int i = 0; i < ans.length - dist - 1; i++) {
      if (ans[i] == 0 && ans[i + dist + 1] == 0) {
        ans[i] = dist;
        ans[i + dist + 1] = dist;

        if (helper(ans, dist - 1)) {
          return true;
        }

        ans[i] = 0;
        ans[i + dist + 1] = 0;
      } 
    }

    return false;
  }
}
// TC: O(k!); SC: O(k)
