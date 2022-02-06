// Hard
// Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), 
// return the length of the largest square.

// Assumptions
// The given matrix is not null and guaranteed to be of size N * N, N >= 0
  
// Example
// { {0, 0, 0, 0},

//   {1, 1, 1, 1},

//   {0, 1, 1, 1},

//   {1, 0, 1, 1}}

// the largest square of 1s has length of 2
 
// Solution
public class Solution {
  public int largest(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int globalMax = 0;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (i == 0 || j == 0) {
          globalMax = Math.max(globalMax, matrix[i][j]);

          continue;
        }
        else {
          if (matrix[i][j] == 1) {
            int temp = Math.min(matrix[i - 1][j], matrix[i][j - 1]);
            matrix[i][j] = Math.min(temp, matrix[i - 1][j - 1]) + 1;
            
            globalMax = Math.max(globalMax, matrix[i][j]);
          }
        }
      }
    }

    return globalMax;
  }
}
// TC: O(n^2); SC: O(1)
