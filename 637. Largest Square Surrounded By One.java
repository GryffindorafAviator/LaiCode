// Medium
// Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), 
// return the length of the largest square.

// Assumptions

// The given matrix is guaranteed to be of size M * N, where M, N >= 0

// Examples

// {{1, 0, 1, 1, 1},
//  {1, 1, 1, 1, 1},
//  {1, 1, 0, 1, 0},
//  {1, 1, 1, 1, 1},
//  {1, 1, 1, 0, 0}}

// The largest square surrounded by 1s has length of 3.
  
public class Solution {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int result = 0;
    int verLen = matrix.length;
    int horLen = matrix[0].length;
    int[][] ver = new int[verLen + 1][horLen + 1];
    int[][] hor = new int[verLen + 1][horLen + 1];

    for (int i = 0; i < verLen; ++i) {
      for (int j = 0; j < horLen; ++j) {
        if (matrix[i][j] == 1) {
          ver[i + 1][j + 1] = ver[i][j + 1] + 1;
          hor[i + 1][j + 1] = hor[i + 1][j] + 1;

          for (int len = Math.min(ver[i + 1][j + 1], hor[i + 1][j + 1]); len > 0; --len) {
            if (ver[i + 1][j + 2 - len] >= len && hor[i + 2 - len][j + 1] >= len) {
              result = Math.max(result, len);
            }
          }
        }
      }
    }

    return result;
  }
}

// TC: O(n^3), SC: O(n).
