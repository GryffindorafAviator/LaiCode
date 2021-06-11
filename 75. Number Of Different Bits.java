// Medium
// Determine the number of bits that are different for two given integers.

// Examples

// 5(“0101”) and 8(“1000”) has 3 different bits

// Solution 1
public class Solution {
  public int diffBits(int a, int b) {
    int cnt = 0;
    int c = a ^ b;

    for (int i = 0; i < 32; ++i) {
      cnt += (c & 1);
      c >>= 1;
    }

    return cnt;
  }
}

// Solution 2
public class Solution {
  public int diffBits(int a, int b) {
    int cnt = 0;

    for (a ^= b; a != 0; a >>>= 1) {
      cnt += (a & 1);
    }

    return cnt;
  }
}
