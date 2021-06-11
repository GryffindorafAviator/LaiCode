// Easy
// Determine if a given integer is power of 2.

// Examples

// 16 is power of 2 (2 ^ 4)
// 3 is not
// 0 is not
// -1 is not

public class Solution {
  public boolean isPowerOfTwo(int number) {
    if (number < 0) {
      return false;
    }

    int cnt = 0;

    while (number > 0) {
      cnt += (number & 1);
      number >>= 1;
    }

    return cnt == 1;
  }
}
