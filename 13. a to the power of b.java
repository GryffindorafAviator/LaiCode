// Medium
// Evaluate a to the power of b, assuming both a and b are integers and b is non-negative.

// Examples
// power(2, 0) = 1
// power(2, 3) = 8
// power(0, 10) = 0
// power(-2, 5) = -32
// Corner Cases

// In this question, we assume 0^0 = 1.
// What if the result is overflowed? 
// We can assume the result will not be overflowed when we solve this problem on this online judge.

// Solution 1
public class Solution {
  public long power(int a, int b) {
    if ((a == 0 && b == 0) || (a == 1)) {
      return 1;
    }

    int ans = 1;

    for (int i = 1; i <= b; ++i) {
      ans *= a;
    }

    return ans;
  }
}

// Solution 2
public class Solution {
  public long power(int a, int b) {
    if (a == 1 || b == 0) {
      return 1;
    }

    return a * power(a, b - 1);
  }
}

// Solution
public class Solution {
  public long power(int a, int b) {
    if(a == 1 || b == 0) {
      return 1;
    }

    long half = power(a, b / 2);

    return b % 2 == 0 ? half * half : half * half * a;
  }
}
