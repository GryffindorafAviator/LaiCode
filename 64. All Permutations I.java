// Medium
// Given a string with no duplicate characters, return a list with all permutations of the characters.

// Assume that input string is not null.

// Examples

// Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]

// Set = "", all permutations are [""]

public class Solution {
  public List<String> permutations(String input) {
    char[] inStr = input.toCharArray();
    List<String> rslt = new ArrayList<>();

    helper(inStr, 0, rslt);

    return rslt;
  }

  private void helper(char[] inStr, int index, List<String> rslt) {
    if (index == inStr.length) {
      rslt.add(String.valueOf(inStr));
      return;
    }

    for (int i = 0; i < inStr.length - index; ++i) {
      swap(inStr, index, index + i);
      helper(inStr, index + 1, rslt);
      swap(inStr, index, index + i);
    }
  }

  private void swap(char[] inStr, int i, int j) {
    char temp = inStr[i];
    inStr[i] = inStr[j];
    inStr[j] = temp;
  }
}
