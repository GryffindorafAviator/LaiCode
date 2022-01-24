// Hard
// Given a string with possible duplicate characters, 
// return a list with all permutations of the characters.

// Examples
// Set = “abc”, 
// all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

// Set = "aba", 
// all permutations are ["aab", "aba", "baa"]

// Set = "", 
// all permutations are [""]

// Set = null, 
// all permutations are []

// Solution
public class Solution {
  public List<String> permutations(String input) {
    if (input == null) {
      return null;
    }

    char[] chArr = input.toCharArray();
    Arrays.sort(chArr);
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    helper(chArr, 0, sb, ans);

    return ans;
  }

  private void helper(char[] chArr, int idx, StringBuilder sb, List<String> ans) {
    if (idx == chArr.length) {
      ans.add(sb.toString());

      return;
    }

    Set<Character> used = new HashSet<>();

    for (int i = 0; i < chArr.length - idx; i++) {
      if (used.contains(chArr[idx + i])) {
        continue;
      }

      used.add(chArr[idx + i]);

      swap(chArr, idx, idx + i);
      sb.append(chArr[idx]);
      helper(chArr, idx + 1, sb, ans);
      sb.deleteCharAt(sb.length() - 1);
      swap(chArr, idx, idx + i);
    }
  }

  private void swap(char[] chArr, int i, int j) {
    char temp = chArr[i];
    chArr[i] = chArr[j];
    chArr[j] = temp;
  }
}
// TC: O(n!); SC: O(n^2)
