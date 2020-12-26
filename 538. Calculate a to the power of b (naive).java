Easy

Example: 
1, a = 3, b = 4  Return 81
2, a = 4, b = 2  Return 16

Assumption: a > 0, b > 0

Note: don’t worry about time complexity for now.

public class Solution {
  public int power(int a, int b) {
    int ans = 1;

    for (int i = 1; i <= b; ++i) {
      ans *= a;
    }
    return ans;
  }
}
