// Easy
// Check if the given number x and y are roughly equal, the allowed error is lower than 0.0001.

public class Solution {
  public boolean areEqual(double x, double y) {
    boolean b = Math.abs(x - y) < 0.0001 ? true : false;
    return b;
  }
}

// Solution
public class Solution {
  public boolean areEqual(double x, double y) {
    boolean b = (x - y < 0.0001) && (y - x < 0.0001);
    return b;
  }
}
