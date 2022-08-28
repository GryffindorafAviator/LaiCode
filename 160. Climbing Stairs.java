// Easy
// There are in total n steps to climb until you can reach the top. 
// You can climb 1 or 2 steps a time. 
// Determine the number of ways you can do that.

// Example:
// Input: n = 4, Return 5.
  
// Solution
public class Solution {
  public int stairs(int n) {
    int[] ans = new int[] {0};

    dfs(n, ans);

    return ans[0];
  }

  private void dfs(int n, int[] ans) {
    if (n == 0) {
      ans[0]++;
    }

    if (n < 0) {
      return;
    }

    dfs(n - 2, ans);
    dfs(n - 1, ans);
  }
}
// TC: O(2^n); SC: O(n)
