// Medium
// Get all valid permutations of l pairs of (), 
// m pairs of <> and n pairs of {}, 
// subject to the priority restriction: {} higher than <> higher than ().

// Assumptions
// l, m, n >= 0
// l + m + n >= 0

// Examples
// l = 1, m = 1, n = 0, 
// all the valid permutations are ["()<>", "<()>", "<>()"].
// l = 2, m = 0, n = 1, 
// all the valid permutations are [“()(){}”, “(){()}”, “(){}()”, “{()()}”, “{()}()”, “{}()()”].
  
// Solution
public class Solution {
  public List<String> validParenthesesIII(int l, int m, int n) {
    List<String> ans = new ArrayList<>();
    char[] parens = new char[] {'(', ')', '<', '>', '{', '}'};
    int[] remain = new int[] {l, l, m, m, n, n};
    int len = (l + m + n) * 2;
    StringBuilder sb = new StringBuilder();
    Deque<Integer> stack = new ArrayDeque<>();

    helper(parens, remain, len, stack, sb, ans);

    return ans;
  }

  private void helper(char[] parens, int[] remain, int len, Deque<Integer> stack, StringBuilder sb, List<String> ans) {
    if (sb.length() == len) {
      ans.add(sb.toString());

      return;
    }

    for (int i = 0; i < parens.length; i++) {
      if (i % 2 == 0) {
        if (remain[i] > 0 && (stack.isEmpty() || stack.peekFirst() > i)) {
          sb.append(parens[i]);
          remain[i]--;
          stack.offerFirst(i);
          helper(parens, remain, len, stack, sb, ans);
          sb.deleteCharAt(sb.length() - 1);
          remain[i]++;
          stack.pollFirst();
        }
      }
      else {
        if (!stack.isEmpty() && stack.peekFirst() == (i - 1)) {
          sb.append(parens[i]);
          remain[i]--;
          stack.pollFirst();
          helper(parens, remain, len, stack, sb, ans);
          sb.deleteCharAt(sb.length() - 1);
          remain[i]++;
          stack.offerFirst(i - 1);
        }
      }
    }
  }
}
// TC: O(6^len); SC: O(len)
