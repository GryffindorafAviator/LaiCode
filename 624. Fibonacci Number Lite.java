// Easy
// Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, 
// the 0th Fibonacci number is 0 and the 1st Fibonacci number is 1).

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

// Solution
public class Solution {
  public int fibonacci(int K) { 
    int[] fib = new int[K + 1];

    if (K <= 0) {
      return 0;
    }

    fib[1] = 1;

    return asstFib(K, fib);
  }

  private int asstFib(int K, int[] fib) {
    if (K == 0) {
      return fib[0];
    }
    else if (K == 1) {
      return fib[1];
    }
    else if (fib[K] > 0) {
      return fib[K];
    }
    else {
      fib[K] = asstFib(K - 1, fib) + asstFib(K - 2, fib);
      return fib[K];
    }   
  }
}
