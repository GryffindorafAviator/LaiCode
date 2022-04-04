// Medium
// Given a matrix of size N x M. 
// For each row the elements are sorted in ascending order, 
// and for each column the elements are also sorted in ascending order. 
// Find the Kth smallest number in it.

// Assumptions
// the matrix is not null, 
// N > 0 and M > 0
// K > 0 and K <= N * M

// Examples
// { {1,  3,   5,  7},

//   {2,  4,   8,   9},

//   {3,  5, 11, 15},

//   {6,  8, 13, 18} }

// the 5th smallest number is 4
// the 8th smallest number is 6
  
// Solution
public class Solution {
  static class Cell {
    int row;
    int col;
    int val;

    Cell(int row, int col, int val) {
      this.row = row;
      this.col = col;
      this.val = val;
    }
  }

  public int kthSmallest(int[][] matrix, int k) {
    int ROWS = matrix.length;
    int COLS = matrix[0].length;

    PriorityQueue<Cell> pq = new PriorityQueue<>(k, new Comparator<Cell>() {
      @Override
      public int compare(Cell c1, Cell c2) {
        if (c1.val == c2.val) {
          return 0;
        }

        return c1.val < c2.val ? -1 : 1;
      }
    });

    boolean[][] visited = new boolean[ROWS][COLS]; 

    Cell c0 = new Cell(0, 0, matrix[0][0]);
    pq.offer(c0);
    visited[0][0] = true;

    int cnt = k - 1;

    while (cnt > 0) {
      Cell cur = pq.poll();
      cnt--;

      int row = cur.row;
      int col = cur.col;
      int nextRow = row + 1;
      int nextCol = col + 1;

      if (nextRow < ROWS && !visited[nextRow][col]) {
        Cell down = new Cell(nextRow, col, matrix[nextRow][col]);
        pq.offer(down);
        visited[nextRow][col] = true;
      }

      if (nextCol < COLS && !visited[row][nextCol]) {
        Cell right = new Cell(row, nextCol, matrix[row][nextCol]);
        pq.offer(right);
        visited[row][nextCol] = true;
      }
    }

    return pq.poll().val;
  }
}
// TC: O(klogk); SC: O(k + m * n)
