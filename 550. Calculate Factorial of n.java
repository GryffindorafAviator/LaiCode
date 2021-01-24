// Easy
// Calculate the factorial of n using recursion.

// Assumption: n >= 1.

// Example:
// n = 1 ⇒ return 1

// n = 3 ⇒ return 6

// n = 5 ⇒ return 120

public class Solution {
  public long factorial(int n) {
    long ans = 1;

    if (n == 0 || n == 1) {
      return ans;
    }
    else {
      ans = (long)n * factorial(n - 1);
    }

    return ans;
  }
}

// Solution
public class Solution {
  public long factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    
    return n * factorial(n - 1);
  }
}
