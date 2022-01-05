// Medium
// Given a telephone keypad, and an int number, 
// print all words which are possible by pressing these numbers, 
// the output strings should be sorted.
// {0 : "", 1 : "", 2 : "abc", 3 : "def", 4 : "ghi", 5 : "jkl", 6 : "mno", 7 : "pqrs", 8 : "tuv", 9 : "wxyz"} 

// Assumptions:
// The given number >= 0
  
// Examples:
// if input number is 231, possible words which can be formed are:
// [ad, ae, af, bd, be, bf, cd, ce, cf]

// Solution
public class Solution {
  public String[] combinations(int number) {
    List<String> ans = new ArrayList<>();
    String[] pad = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();
    char[] num = Integer.toString(number).toCharArray();

    helper(pad, num, sb, 0, ans);

    return ans.toArray(new String[0]);
  }

  private void helper(String[] pad, char[] num, StringBuilder sb, int level, List<String> ans) {
    if (level == num.length) {
      ans.add(sb.toString());

      return;
    }

    char[] key = pad[num[level] - '0'].toCharArray();

    if (key.length == 0) {
      helper(pad, num, sb, level + 1, ans);
    }
    else {
      for (int i = 0; i < key.length; i++) {
        helper(pad, num, sb.append(key[i]), level + 1, ans);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
// TC: O(digits of number); SC: stack O(digits of number), heap O(
