// Medium
// Get all valid ways of putting N Queens on an N * N chessboard so that no two Queens threaten each other.

// Assumptions

// N > 0
// Return

// A list of ways of putting the N Queens
// Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
// Example

// N = 4, there are two ways of putting 4 queens:

// [1, 3, 0, 2] --> the Queen on the first row is at y index 1, the Queen on the second row is at y index 3, 
// the Queen on the third row is at y index 0 and the Queen on the fourth row is at y index 2.

// [2, 0, 3, 1] --> the Queen on the first row is at y index 2, the Queen on the second row is at y index 0, 
// the Queen on the third row is at y index 3 and the Queen on the fourth row is at y index 1.
  
// Solution 1
public class Solution {
  public List<List<Integer>> nqueens(int n) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    helper(result, cur, n);

    return result;
  }

  private void helper(List<List<Integer>> result, List<Integer> cur, int n) {
    if (cur.size() == n) {
      result.add(new ArrayList<Integer>(cur));

      return;
    }

    for (int i = 0; i < n; ++i) {
      if (validate(cur, i)) {
        cur.add(i);
        helper(result, cur, n);
        cur.remove(cur.size() - 1);
      }
    }
  }

  private boolean validate(List<Integer> cur, int i) {
    int row = cur.size();

    for (int j = 0; j < row; ++j) {
      int column = cur.get(j);
      
      if (i == column || Math.abs(column - i) == row - j) {
        return false;
      }
    }

    return true;
  }
}
// TC: O(n!); SC: O(n)
// The time complexity for validation is O(n).
