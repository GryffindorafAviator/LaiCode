// Hard
// Given a 2D board and a list of words from the dictionary, 
// find all words in the board.

// Each word must be constructed from letters of sequentially adjacent cell, 
// where "adjacent" cells are those horizontally or vertically neighboring. 
// The same letter cell may not be used more than once in a word.

// For example,
// Given words = ["oath","pea","eat","rain"] and board =
// [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// Return ["eat","oath"].

// Note:
// You may assume that all inputs are consist of lowercase letters a-z.
  
// Solution 
public class Solution {
  static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord;
  }

  static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public List<String> findWords(char[][] board, String[] words) {
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0 || words == null || words.length == 0) {
      return new ArrayList<>();
    }

    final int rows = board.length;
    final int cols = board[0].length;
    boolean[][] visited = new boolean[rows][cols];
    Set<String> set = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    TrieNode root = buildDict(words);

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++){
        helper(board, root, sb, set, visited, i, j);
      }
    }

    return new ArrayList<>(set);
  }

  private TrieNode buildDict(String[] words) {
    TrieNode root = new TrieNode();

    for (String word : words) {
      TrieNode cur = root;

      for (int i = 0; i < word.length(); i++) {
        char ch = word.charAt(i);
        TrieNode next = cur.children[ch - 'a'];

        if (next == null) {
          next = new TrieNode();

          cur.children[ch - 'a'] = next;
        }

        cur = next;
      }

      cur.isWord = true;
    }

    return root;
  }

  private void helper(char[][] board, TrieNode root, StringBuilder sb, Set<String> set, boolean[][] visited, int row, int col) {
    if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
      return;
    }

    char ch = board[row][col];
    TrieNode cur = root.children[ch - 'a'];

    if (cur == null) {
      return;
    }

    sb.append(ch);
    visited[row][col] = true;

    if (cur.isWord) {
      set.add(sb.toString());
    }

    for (int[] dir : DIRS) {
      int nextRow = row + dir[0];
      int nextCol = col + dir[1];

      helper(board, cur, sb, set, visited, nextRow, nextCol);
    }

    sb.deleteCharAt(sb.length() - 1);
    visited[row][col] = false;
  }
}

// TC: O(words.length * word.length + 4 * word.length * words.length)
// SC: O(board.rows * board.cols + words.length * word.length + word.length)
