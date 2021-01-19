// Easy
// Given a matrix, find the Kth index element.

// Example: 

// matrix:
// 1 3 4
// 5 6 7
// 8 9 10

// k = 4 → return: 6

public class Solution {
  public int findElement(int[][] matrix, int k) {
    if (matrix == null) {
      return -1;
    }

    int row_n = matrix.length;
    int col_n = matrix[0].length;

    if (k > row_n * col_n) {
      return -1;
    }

    return matrix[(k) / col_n][(k) % col_n];
  }
}
