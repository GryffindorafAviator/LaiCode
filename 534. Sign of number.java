// Easy
// Return 1 if the input integer is positive, -1 if the input integer is negative, 0 if the input integer is zero.

public class Solution {
  public int sign(int x) {
    return x == 0 ? 0 : (x > 0 ? 1 : -1);
  }
}

// Solution
public class Solution {
  public int sign(int x) {
    if (x > 0) {
      return 1;
    }
    else if (x < 0) {
      return -1;
    }
    else {
      return 0;
    }
  }
}
