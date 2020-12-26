// Easy
// 求n的阶乘. Assumption, n > 1.

// Example:
// 1, n = 3, return 6
// 2, n = 4, return 24
// 3, n = 5, return 120

public class Solution {
  public int factorial(int n) {
    int ans = 1;
    for (int i = 1; i <= n; ++i) {
      ans *= i;
    }
    return ans;
  }
}


