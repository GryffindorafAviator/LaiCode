// Medium
// Given a set of characters represented by a String, 
// return a list containing all subsets of the characters whose size is K. 
// Notice that each subset returned will be sorted for deduplication.

// Assumptions
// There could be duplicate characters in the original set.

// Examples
// Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].
// Set = "abb", K = 2, all the subsets are [“ab”, “bb”].
// Set = "abab", K = 2, all the subsets are [“aa”, “ab”, “bb”].
// Set = "", K = 0, all the subsets are [""].
// Set = "", K = 1, all the subsets are [].
// Set = null, K = 0, all the subsets are [].
  
// Solution
public class Solution {
  public List<String> subSetsIIOfSizeK(String set, int k) {
    List<String> ans = new ArrayList<>();

    if (set == null) {
      return ans;
    }

    char[] charArr = set.toCharArray();
    Arrays.sort(charArr);

    StringBuilder sb = new StringBuilder();

    helper(charArr, sb, k, 0, ans);

    return ans;
  }

  private void helper(char[] charArr, StringBuilder sb, int k, int idx, List<String> ans) {
    if (sb.length() == k) {
      ans.add(sb.toString());

      return;
    }

    if (idx == charArr.length) {
      return;
    }

    helper(charArr, sb.append(charArr[idx]), k, idx + 1, ans);
    sb.deleteCharAt(sb.length() - 1);

    while (idx < charArr.length - 1 && charArr[idx] == charArr[idx + 1]) {
      idx++;
    }

    helper(charArr, sb, k, idx + 1, ans);
  }
}
// TC: O(2^n); SC: O(n)
