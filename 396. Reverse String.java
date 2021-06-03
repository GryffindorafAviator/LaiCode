// Easy
// Reverse a given string.

// Assumptions

// The given string is not null.
  
public class Solution {
  public String reverse(String input) {
    if (input.length() == 0) {
      return input;
    }

    char[] str = input.toCharArray();
    int i = 0;
    int j = str.length - 1;

    while (i < j) {
      swap(str, i, j);
      ++i;
      --j;
    }

    return new String(str);
  }

  private void swap(char[] str, int i, int j) {
    char temp = str[i];
    str[i] = str[j];
    str[j] = temp;
  }
}
