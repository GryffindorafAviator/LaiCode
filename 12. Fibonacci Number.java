// Easy
// Get the Kth number in the Fibonacci Sequence. 
// (K is 0-indexed, the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

// Examples

// 0th fibonacci number is 0
// 1st fibonacci number is 1
// 2nd fibonacci number is 1
// 3rd fibonacci number is 2
// 6th fibonacci number is 8
// Corner Cases

// What if K < 0? in this case, we should always return 0.
// Is it possible the result fibonacci number is overflowed? 
// We can assume it will not be overflowed when we solve this problem on this online judge, 
// but we should also know that it is possible to get an overflowed number, 
// and sometimes we will need to use something like BigInteger.

// Solution 1
public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0;
    }

    long[] fib = new long[K + 1];

    fib[0] = 0L;
    fib[1] = 1L;

    return helper(fib, K);
  }

  private long helper(long[] fib, int K) {
    if (K == 0) {
      return fib[0];
    }
    else if (K == 1) {
      return fib[1];
    }
    else if (fib[K] != 0) {
      return fib[K];
    }
    else {
      fib[K] = helper(fib, K - 1) + helper(fib, K - 2);
      return fib[K];
    }
  }
}
// TC: O(）

// Solution 2
public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0L;
    }

    if (K == 1) {
      return 1L;
    }

    long a = 0L;
    long b = 1L;

    while (K > 1) {
      long temp = a + b;
      a = b;
      b = temp;
      --K; 
    }

    return b;
  }
}
// TC: O(K), SC: O(1)

// Solution 3
public class Solution {
  public long fibonacci(int K) {
    if (K <= 0) {
      return 0L;
    }

    if (K == 1) {
      return 1L;
    }

    long[] fib = new long[K + 1];

    fib[0] = 0L;
    fib[1] = 1L;

    for (int i = 2; i <= K; ++i) {
      fib[i] = fib[i - 1] + fib[i - 2];
    }

    return fib[K];
  }
}
// TC: O(K), SC: O(K)
