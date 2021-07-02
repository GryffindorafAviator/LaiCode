// Hard
// Given a matrix that contains only 1s and 0s, 
// find the largest cross which contains only 1s, 
// with the same arm lengths and the four arms joining at the central point.

// Return the arm length of the largest cross.

// Assumptions

// The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
// Examples

// { {0, 0, 0, 0},

//   {1, 1, 1, 1},

//   {0, 1, 1, 1},

//   {1, 0, 1, 1} }

// the largest cross of 1s has arm length 2.
  
public class Solution {
  public int largest(int[][] matrix) {
    int numRow = matrix.length;

    if (numRow < 3) {
      return 0;
    }

    int numCol = matrix[0].length;
     
    if (numCol < 3) {
      return 0;
    }

    int[][] upLeft = upLeft(matrix, numRow, numCol);
    int[][] downRight = downRight(matrix, numRow, numCol);

    return merge(upLeft, downRight, numRow, numCol);
  }

  private int merge(int[][] mat1, int[][] mat2, int numRow, int numCol) {
    int result = 0;

    for (int i = 0; i < numRow; ++i) {
      for (int j = 0; j < numCol; ++j) {
        mat1[i][j] = Math.min(mat1[i][j], mat2[i][j]);
        result = Math.max(result, mat1[i][j]);
      }
    }

    return result;
  }

  private int[][] upLeft(int[][] matrix, int numRow, int numCol) {
    int[][] up = new int[numRow][numCol];
    int[][] left = new int[numRow][numCol];

    for (int i = 0; i < numRow; ++i) {
      for (int j = 0; j < numCol; ++j) {
        if (matrix[i][j] == 1) {
          if (i == 0 && j == 0) {
            up[i][j] = 1;
            left[i][j] = 1;
          }
          else if (i == 0) {
            up[i][j] = 1;
            left[i][j] = left[i][j - 1] + 1;
          }
          else if (j == 0) {
            up[i][j] = up[i - 1][j] + 1;
            left[i][j] = 1;
          }
          else {
            up[i][j] = up[i - 1][j] + 1;
            left[i][j] = left[i][j - 1] + 1;
          }
        }
      }
    }

    merge(up, left, numRow, numCol);

    return up;
  }

  private int[][] downRight(int[][] matrix, int numRow, int numCol) {
    int[][] down = new int[numRow][numCol];
    int[][] right = new int[numRow][numCol];

    for (int i = numRow - 1; i >= 0; --i) {
      for (int j = numCol - 1; j >= 0; --j) {
        if (matrix[i][j] == 1) {
          if (i == numRow - 1 && j == numCol - 1) {
            down[i][j] = 1;
            right[i][j] = 1;
          }
          else if (i == numRow - 1) {
            down[i][j] = 1;
            right[i][j] = right[i][j + 1] + 1; 
          }
          else if (j == numCol - 1) {
            down[i][j] = down[i + 1][j] + 1;
            right[i][j] = 1;
          }
          else {
            down[i][j] = down[i + 1][j] + 1;
            right[i][j] = right[i][j + 1] + 1;
          }
        } 
      }
    }

    merge(down, right, numRow, numCol);

    return down;
  }
}
 
// TC: O(n*m), SC: O(n*m)
