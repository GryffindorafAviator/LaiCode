// Easy
// Calculate the sum of all square numbers between 1 and n (inclusive).

// Example:
// 1, n = 3. Return 1;
// 2, n = 10. Return 14 (1 + 4 + 9);

public class Solution {
  public int sumOfSquares(int n) {
    int i = 1;
    int ans = 0;

    while (i * i <= n) {
      ans += i * i;
      ++i;
    }
    return ans;
  }
}

// Solution
public class Solution {
  public int sumOfSquares(int n) {
    int sum = 0;
    for (int i = 1; i * i <= n; ++i) {
      sum += i * i;
    }
    return sum;
  }
}
