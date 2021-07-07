// Medium
// Rotate an N * N matrix clockwise 90 degrees.

// Assumptions

// The matrix is not null and N >= 0
// Examples

// { {1,  2,  3}

//   {8,  9,  4},

//   {7,  6,  5} }

// after rotation is

// { {7,  8,  1}

//   {6,  9,  2},

//   {5,  4,  3} }

public class Solution {
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length < 2) {
      return;
    }

    int n = matrix.length;
    int round = n / 2;

    for (int i = 0; i < round; ++i) {
      for (int j = i; j < n - i - 1; ++j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[n - 1 - j][i];
        matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
        matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
        matrix[j][n - 1 - i] = temp;
      }
    }
  }
}

// TC: O(), SC: O(1).
