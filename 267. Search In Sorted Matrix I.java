// Medium
// Given a 2D matrix that contains integers only, which each row is sorted in an ascending order. 
// The first element of next row is larger than (or equal to) the last element of previous row.

// Given a target number, returning the position that the target locates within the matrix. 
// If the target number does not exist in the matrix, return {-1, -1}.

// Assumptions:
// The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

// Examples:
// matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
// target = 7, return {1, 2}
// target = 6, return {-1, -1} to represent the target number does not exist in the matrix.

public class Solution {
  public int[] search(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    if (n == 1 && m == 0) {
      return new int[] {-1, -1};
    }

    int u = 0;
    int d = n - 1;

    while (u < d - 1) {
      int mid = u + (d - u) / 2;

      if (matrix[mid][0] == target) {
        return new int[]{mid, 0};
      }
      else if (matrix[mid][0] < target) {
        u = mid;
      }
      else {
        d = mid;
      }
    }

    if (matrix[u][0] == target) {
      return new int[]{u, 0};
    }
    else if (matrix[d][0] == target) {
      return new int[]{d, 0};
    }
    else if (matrix[u][0] > target) {
      if (u == 0) {
        return new int[]{-1, -1};
      }

      int l = 0;
      int r = m - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (matrix[u - 1][mid] == target) {
          return new int[]{u - 1, mid};
        }
        else if (matrix[u - 1][mid] > target) {
          r = mid - 1;
        }
        else {
          l = mid + 1;
        }
      }

      return new int[]{-1, -1};
    }
    else if (matrix[d][0] < target) {
      int l = 0;
      int r = m - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (matrix[d][mid] == target) {
          return new int[]{d, mid};
        }
        else if (matrix[d][mid] > target) {
          r = mid - 1;
        }
        else {
          l = mid + 1;
        }
      }

      return new int[]{-1, -1};
    }
    else {
      int l = 0;
      int r = m - 1;

      while (l <= r) {
        int mid = l + (r - l) / 2;

        if (matrix[u][mid] == target) {
          return new int[]{u, mid};
        }
        else if (matrix[u][mid] > target) {
          r = mid - 1;
        }
        else {
          l = mid + 1;
        }
      }

      return new int[]{-1, -1};
    }
  }
}
