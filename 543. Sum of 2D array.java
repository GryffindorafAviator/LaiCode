// Easy
// Given a two-dimensional array, calculate the sum of all its elements

// Example:
// array = {{ 2, 3}, {4, 5}, {1, 0}}
// Return 15

// Assumption: The 2D array is not null or empty. The 2D array is rectangular shape.

public class Solution {
  public int sum(int[][] array) {
    int lenRow = array.length;
    int lenCol = array[0].length;
    int ans = 0;

    for (int i = 0; i < lenRow; ++i) {
      for (int j = 0; j <lenCol; ++j) {
        ans += array[i][j];
      }
    }

    return ans;
  }
}
