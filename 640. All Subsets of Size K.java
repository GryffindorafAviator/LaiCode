// Medium
// Given a set of characters represented by a String, 
// return a list containing all subsets of the characters whose size is K.

// Assumptions

// There are no duplicate characters in the original set.

// Examples

// Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

// Set = "", K = 0, all the subsets are [""].

// Set = "", K = 1, all the subsets are [].

public class Solution {
  public List<String> subSetsOfSizeK(String set, int k) {
    List<String> ans = new ArrayList<>();

    if (set == null || k > set.length()) {
      return ans;
    }

    char[] charSet = set.toCharArray();
    StringBuilder sb = new StringBuilder();

    helper(ans, charSet, sb, k, 0, 0);

    return ans;    
  }

  private void helper(List<String> ans, char[] charSet, StringBuilder sb, int k, int index, int cnt) {
    if (cnt == k) {
      ans.add(sb.toString());
      
      return;
    }

    if (index == charSet.length) {
      return;
    }

    helper(ans, charSet, sb.append(charSet[index]), k, index + 1, cnt + 1);
    sb.deleteCharAt(sb.length() - 1);
    helper(ans, charSet, sb, k, index + 1, cnt);
  }
}

// TC: O(2^k), SC: O(height)
