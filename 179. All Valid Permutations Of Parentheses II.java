// Hard
// Get all valid permutations of l pairs of (), 
// m pairs of <> and n pairs of {}.

// Assumptions

// l, m, n >= 0
// l + m + n > 0
// Examples

// l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]

public class Solution {
  private static final char[] brackets = new char[]{'(', ')', '<', '>', '{', '}'};

  public List<String> validParentheses(int l, int m, int n) {
    
    int[] remain = new int[]{l, l, m, m, n, n};
    Deque<Character> stack = new LinkedList<>();
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    int totalLength = l * 2 + m * 2 + n * 2;

    helper(brackets, remain, stack, ans, sb, totalLength);

    return ans;
  }

  private void helper(char[] brackets, int[] remain, Deque<Character> stack, List<String> ans, StringBuilder sb, int totalLength) {
    if (sb.length() == totalLength) {
      ans.add(sb.toString());

      return;
    }

    for (int i = 0; i < remain.length; ++i) {
      if (i % 2 == 0) {
        if (remain[i] > 0) {
          sb.append(brackets[i]);
          stack.offerFirst(brackets[i]);
          --remain[i];
          helper(brackets, remain, stack, ans, sb, totalLength);
          sb.deleteCharAt(sb.length() - 1);
          stack.pollFirst();
          ++remain[i];
        }
      }
      else {
        if (!stack.isEmpty() && (stack.peekFirst() == brackets[i - 1])) {
          sb.append(brackets[i]);
          stack.pollFirst();
          --remain[i];
          helper(brackets, remain, stack, ans, sb, totalLength);
          sb.deleteCharAt(sb.length() - 1);
          stack.offerFirst(brackets[i - 1]);
          ++remain[i];
        }
      }
    }

    
  }
}
