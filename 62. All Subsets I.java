// Medium
// Given a set of characters represented by a String, return a list containing all subsets of the characters.

// Assumptions

// There are no duplicate characters in the original set.
// Examples

// Set = "abc", all the subsets are [“”, “a”, “ab”, “abc”, “ac”, “b”, “bc”, “c”]
// Set = "", all the subsets are [""]
// Set = null, all the subsets are []

// Solution 1
public class Solution {
  public List<String> subSets(String set) {
    List<String> ans = new ArrayList<>();

    if (set == null) {
      return ans;
    }

    char[] str = set.toCharArray();
    StringBuilder sb = new StringBuilder();
    helper(str, sb, 0, ans);
    return ans;
  }

  private void helper(char[] str, StringBuilder sb, int index, List<String> ans) {
    if (index == str.length) {
      ans.add(sb.toString());
      return;
    }

    helper(str, sb, index + 1, ans);
    helper(str, sb.append(str[index]), index + 1, ans);
    sb.deleteCharAt(sb.length() - 1);
  }
}
// TC: O(2^n); SC: O(n)

// Solution 2
public class Solution {
  public List<String> subSets(String set) {
    List<String> ans = new ArrayList<>();

    if (set == null) {
      return ans;
    }

    char[] charSet = set.toCharArray();
    
    StringBuilder sb = new StringBuilder();

    dfs(charSet, 0, sb, ans);

    return ans;
  }

  private void dfs(char[] charSet, int idx, StringBuilder sb, List<String> ans) {
    if (idx == charSet.length) {
      ans.add(sb.toString());

      return;
    }

    sb.append(charSet[idx]);
    dfs(charSet, idx + 1, sb, ans);
    sb.deleteCharAt(sb.length() - 1);
    dfs(charSet, idx + 1, sb, ans);
  }
}
// TC: O(2^n); SC: O(n)
