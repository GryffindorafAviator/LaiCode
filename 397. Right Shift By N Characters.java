// Easy
// Right shift a given string by n characters.

// Assumptions

// The given string is not null.
// n >= 0.
// Examples

// "abc", 4 -> "cab"
  
public class Solution {
  public String rightShift(String input, int n) {
    if (input == null || input.length() < 2 || n == 0) {
      return input;
    }

    char[] str = input.toCharArray();
    int len = str.length - 1;
    int m = n % (len + 1);

    reverse(str, 0, len);
    reverse(str, 0, m - 1);
    reverse(str, m, len);
   
    return new String(str);
  }

  private void reverse(char[] str, int start, int end) {
    while (start < end) {
      swap(str, start, end);
      ++start;
      --end;
    }
  }

  private void swap(char[] str, int i, int j) {
    char temp = str[i];
    str[i] = str[j];
    str[j] = temp;
  }
}
