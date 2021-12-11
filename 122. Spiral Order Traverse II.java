// Medium
// Traverse an M * N 2D array in spiral order clock-wise starting from the top left corner. 
// Return the list of traversal sequence.

// Assumptions
// The 2D array is not null and has size of M * N where M, N >= 0
// Examples

// { {1,  2,  3,  4},

//   {5,  6,  7,  8},

//   {9, 10, 11, 12} }

// the traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

// Solution
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();

    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return ans;
    }

    int up = 0;
    int down = matrix.length - 1;
    int left = 0;
    int right = matrix[0].length - 1;

    while (up < down && left < right) {
      for (int i = left; i <= right; i++) {
        ans.add(matrix[up][i]);
      }

      for (int j = up + 1; j <= down - 1; j++) {
        ans.add(matrix[j][right]);
      }

      for (int i = right; i >= left; i--) {
        ans.add(matrix[down][i]);
      }

      for (int j = down - 1; j >= up + 1; j--) {
        ans.add(matrix[j][left]);
      }

      up++;
      down--;
      left++;
      right--;
  }

    if (up == down) {
      for (int i = left; i <= right; i++) {
        ans.add(matrix[up][i]);
      }
    }
    else if (left == right) {
      for (int j = up; j <= down; j++) {
        ans.add(matrix[j][left]);
      }
    }

    return ans;
  }  
}

// TC: O(M*N); SC: O(1)
