// Debug
// There are bugs in the given code, please fix them.

// Calculate the factorial of n (n > 1).

// Example:
// n = 3, return 6
// n = 4, return 24
// n = 5, return 120

public class Solution {
  public int factorial(int n) {
    int res = 1;
    for (int i = 1; i <= n; i++) {
      res *= i;
    }
    return res;
  }
}
