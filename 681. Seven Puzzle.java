// Medium
// Given eight cards with number 0, 1, 2, ..7 on them, 
// the cards are placed in two rows with 4 cards in each row. 
// In each step only card 0 could swap with one of its adjacent(top, right, bottom, left) card. 
// Your goal is to make all cards placed in order like this:
// 0 1 2 3
// 4 5 6 7

// Find the minimum number of steps from the given state to the final state. 
// If there is no way to the final state, then return -1.

// The state of cards is represented by an array of integer, 
// for example 
// [0,1,2,3,4,5,6,7] 
// where the first four numbers are in the first row from left to right while the others are placed in the second row from left to right. 

// Example: 
// Input: [4,1,2,3,5,0,6,7]       
// Output: 2

// Explanation:
// Initial state is:
// 4 1 2 3
// 5 0 6 7

// First swap 0 with 5, then the state is:
// 4 1 2 3
// 0 5 6 7

// Then swap 0 with 4, then we get the final state:
// 0 1 2 3
// 4 5 6 7
  
// Solution
public class Solution {
  final static int[][] DIRS = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  static class Board {
    public final static int R = 2;
    public final static int C = 4;
    private int[][] board = new int[R][C];

    public Board() {
    }

    public Board(int[] values) {
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          board[i][j] = values[i * C + j];
        }
      }
    }

    public int[] findZero() {
      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (board[i][j] == 0) {
            return new int[] {i, j};
          }
        }
      }

      return null;
    }

    public void swap(int i1, int j1, int i2, int j2) {
      int temp = board[i1][j1];

      board[i1][j1] = board[i2][j2];
      board[i2][j2] = temp;
    }

    public boolean outOfBoard(int i, int j) {
      return i < 0 || i >= R || j < 0 || j >= C;
    }

    @Override
    public int hashCode() {
      int code = 0;

      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          code = 10 * code + board[i][j];
        }
      }

      return code;
    }

    @Override
    public Board clone() {
      Board c = new Board();

      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          c.board[i][j] = board[i][j];
        }
      }

      return c;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Board)) {
        return false;
      }

      Board b = (Board) o;

      for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
          if (board[i][j] != b.board[i][j]) {
            return false;
          }
        }
      }

      return true;
    }
  }

  public int numOfSteps(int[] values) {
    Queue<Board> queue = new ArrayDeque<>();
    Map<Board, Integer> hm = new HashMap<>();
    Board start = new Board(new int[] {0, 1, 2, 3, 4, 5, 6, 7});
    
    hm.put(start, 0);
    queue.offer(start);

    while (!queue.isEmpty()) {
      Board board = queue.poll();
      int step = hm.get(board);
      int[] zeroPos = board.findZero();
      int zeroI = zeroPos[0];
      int zeroJ = zeroPos[1];

      for (int[] dir : DIRS) {
        int i = zeroI + dir[0];
        int j = zeroJ + dir[1];

        if (!board.outOfBoard(i, j)) {
          board.swap(zeroI, zeroJ, i, j);

          if (!hm.containsKey(board)) {
            Board temp = board.clone();

            queue.offer(temp);
            hm.put(temp, step + 1);
          }

          board.swap(zeroI, zeroJ, i, j);
        }
      }
    }

    return hm.getOrDefault(new Board(values), -1);
  }
}
// TC: O(V + E); V = O(8!), E = O(4 * 8!)
// SC: O(8!)
