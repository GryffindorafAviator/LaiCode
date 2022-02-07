// Hard
// Given a matrix that contains only 1s and 0s, 
// find the largest X shape which contains only 1s, 
// with the same arm lengths and the four arms joining at the central point.

// Return the arm length of the largest X shape.

// Assumptions
// The given matrix is not null, 
// has size of N * M, N >= 0 and M >= 0.
  
// Examples
// { {0, 0, 0, 0},

//   {1, 1, 1, 1},

//   {0, 1, 1, 1},

//   {1, 0, 1, 1} }

// the largest X of 1s has arm length 2.

// Solution
public class Solution {
  public int largest(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int[][] up = up(matrix, rows, cols);
    int[][] dw = down(matrix, rows, cols);

    return merge(up, dw, rows, cols);
  }

  private int merge(int[][] m1, int[][] m2, int rows, int cols) {
    int glbMax = 0;

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        m1[i][j] = Math.min(m1[i][j], m2[i][j]);

        glbMax = Math.max(glbMax, m1[i][j]);
      }
    }

    return glbMax;
  }

  private int[][] up(int[][] m, int rows, int cols) {
    int[][] ltUp = new int[rows][cols];
    int[][] rtUp = new int[rows][cols];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (m[i][j] == 1) {
          ltUp[i][j] = getNumber(ltUp, i - 1, j - 1, rows, cols) + 1;
          rtUp[i][j] = getNumber(rtUp, i - 1, j + 1, rows, cols) + 1;
        }
      }
    }

    merge(ltUp, rtUp, rows, cols);

    return ltUp;
  }

  private int[][] down(int[][] m, int rows, int cols) {
    int[][] ltDw = new int[rows][cols];
    int[][] rtDw = new int[rows][cols];

    for (int i = rows - 1; i >= 0; i--) {
      for (int j = cols - 1; j >= 0; j--) {
        if (m[i][j] == 1) {
          ltDw[i][j] = getNumber(ltDw, i + 1, j - 1, rows, cols) + 1;
          rtDw[i][j] = getNumber(rtDw, i + 1, j + 1, rows, cols) + 1;
        }
      }
    }

    merge(ltDw, rtDw, rows, cols);

    return ltDw;
  }

  private int getNumber(int[][] m, int row, int col, int rows, int cols) {
    if (row < 0 || row > rows - 1 || col < 0 || col > cols - 1) {
      return 0;
    }

    return m[row][col];
  }
}
// TC: O(n * m); SC: O(n * m)
