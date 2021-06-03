// Easy
// Remove adjacent, repeated characters in a given string, leaving only one character for each group of such characters.

// Assumptions

// Try to do it in place.
// Examples

// “aaaabbbc” is transferred to “abc”
// Corner Cases

// If the given string is null, returning null or an empty string are both valid.
  
public class Solution {
  public String deDup(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }

    char[] str = input.toCharArray();
    int i = 1;

    for (char ch : str) {
      if (ch != str[i - 1]) {
        str[i] = ch;
        ++i;
      }
    }

    return new String(str, 0, i);
  }
}
