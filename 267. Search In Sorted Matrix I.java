// Medium
// Given a 2D matrix that contains integers only, in which each row is sorted in an ascending order. 
// The first element of the next row is larger than (or equal to) the last element of the previous row.

// Given a target number, returning the position that the target is located within the matrix. 
// If the target number does not exist in the matrix, return {-1, -1}.

// Assumptions:
// The given matrix is not null, and has size of N * M, where N >= 0 and M >= 0.

// Examples:
// matrix = { {1, 2, 3}, {4, 5, 7}, {8, 9, 10} }
// target = 7, return {1, 2}
// target = 6, return {-1, -1} to represent the target number does not exist in the matrix.

// Solution 1
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

// Solution 2
public class Solution {
  public int[] search(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return new int[] {-1, -1};
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int lt = 0;
    int rt = m * n - 1;

    while (lt <= rt) {
      int midIndex = lt + (rt - lt) / 2;
      int mid = matrix[midIndex / n][midIndex % n];

      if (mid == target) {
        return new int[]{midIndex / n, midIndex % n};
      }
      else if (target < mid) {
        rt = midIndex - 1;
      } 
      else {
        lt = midIndex + 1;
      }
    }

    return new int[] {-1, -1}; 
  }
}

// Solution 3
public class Solution {
  public int[] search(int[][] matrix, int target) {
    int[] res = new int[]{-1, -1};

    if (matrix.length == 0 || matrix[0].length == 0) {
      return res;
    }

    int row = findRow(matrix, 0, matrix.length - 1, target);
    
    if (row == -1) {
      return res;
    }
    
    int col = findCol(matrix[row], 0, matrix[row].length - 1, target);

    if (col == -1) {
      return res;
    }

    res[0] = row;
    res[1] = col;

    return res;
  }

  private int findRow(int[][] matrix, int up, int down, int target) {
    while (up <= down) {
      int mid = up + (down - up) / 2;
      if (matrix[mid][0] > target) {
        down = mid - 1;
      }
      else {
        up = mid + 1;
      }
    }

    return down;
  }

  private int findCol(int[]array, int left, int right, int target) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }
      else if (target < array[mid]) {
        right = mid - 1;
      }
      else {
        left = mid + 1;
      }
    }

    return -1;
  }  
}
