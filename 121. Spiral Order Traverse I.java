// Medium
// Traverse an N * N 2D array in spiral order clock-wise starting from the top left corner. Return the list of traversal sequence.

// Assumptions

// The 2D array is not null and has size of N * N where N >= 0
// Examples

// { {1,  2,  3},

//   {4,  5,  6},

//   {7,  8,  9} }

// the traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]

// Solution
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();

    if (matrix == null || matrix[0].length == 0) {
      return ans;
    }

    int size = matrix[0].length;

    helper(matrix, size, 0, ans);

    return ans;
  }

  private void helper(int[][] matrix, int size, int offset, List<Integer> ans) {
    if (size / 2 == offset) {
      if (size % 2 == 1) {
        ans.add(matrix[offset][offset]);
      }

      return;
    }

    for (int i = 0; i < size - offset * 2 - 1; ++i) {
      ans.add(matrix[offset][offset + i]);
    }

    for (int j = 0; j < size - offset * 2 - 1; ++j){
      ans.add(matrix[offset + j][size - offset - 1]);
    }

    for (int k = 0; k < size - offset * 2 - 1; ++k) {
      ans.add(matrix[size - offset - 1][size - offset - k - 1]);
    }

    for (int l = 0; l < size - offset * 2 - 1; ++l) {
      ans.add(matrix[size - offset - l - 1][offset]);
    }

    helper(matrix, size, ++offset, ans);
  }
}
