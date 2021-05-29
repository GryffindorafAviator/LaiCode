// Medium
// Given N pairs of parentheses “()”, return a list with all the valid permutations.

// Assumptions

// N > 0
// Examples

// N = 1, all valid permutations are ["()"]
// N = 3, all valid permutations are ["((()))", "(()())", "(())()", "()(())", "()()()"]

public class Solution {
  public List<String> validParentheses(int n) {
    List<String> result = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    helper(n, 0, 0, sb, result);
    return result;
  }

  private void helper(int n, int l, int r, StringBuilder sb, List<String> result) {
    if (l == n && r == n) {
      result.add(sb.toString());
      return;
    }

    if (l < n) {
      helper(n, l + 1, r, sb.append('('), result);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (r < l) {
      helper(n, l, r + 1, sb.append(')'), result);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
