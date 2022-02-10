// Hard
// Given a matrix that contains integers, 
// find the submatrix with the largest sum.

// Return the sum of the submatrix.

// Assumptions
// The given matrix is not null and has size of M * N, 
// where M >= 1 and N >= 1
  
// Examples
// { {1, -2, -1, 4},

//   {1, -1,  1, 1},

//   {0, -1, -1, 1},

//   {0,  0,  1, 1} }

// the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
  
// Solution
public class Solution {
  public int largest(int[][] matrix) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;
    int ans = Integer.MIN_VALUE;

    for (int i = 0; i < rowLen; i++) {
      int[] tempSum = new int[colLen];

      for (int j = i; j < rowLen; j++) { 
        addCol(tempSum, matrix[j], colLen);
        
        int tempMax = max(tempSum, colLen);

        ans = Math.max(ans, tempMax);
      }
    }

    return ans;
  }

  private void addCol(int[] tempSum, int[] rowMat, int colLen) {
    for (int i = 0; i < colLen; i++) {
      tempSum[i] += rowMat[i];
    }
  }

  private int max(int[] tempSum, int colLen) { 
    int temp = tempSum[0];
    int tempMax = tempSum[0];

    for (int i = 1; i < colLen; i++) {
      temp = Math.max(tempSum[i], temp + tempSum[i]);
      tempMax = Math.max(tempMax, temp);
    }

    return tempMax;
  }
}
// TC: O(n^3); SC: O(n)
