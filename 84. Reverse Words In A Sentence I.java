// Medium
// Reverse the words in a sentence.

// Assumptions

// Words are separated by single space

// There are no heading or tailing white spaces

// Examples

// “I love Google” → “Google love I”

// Corner Cases

// If the given string is null, we do not need to do anything.
  
public class Solution {
  public String reverseWords(String input) {
    if (input == null || input.length() < 2) {
      return input;
    }

    char[] str = input.toCharArray();

    reverse(str, 0, str.length - 1);

    for (int fast = 0, slow = 0; fast < str.length; ++fast) {
      if (str[fast] == ' ') {
        reverse(str, slow, fast - 1);
        slow = fast + 1;
      }
      else if (fast == str.length - 1) {
        reverse(str, slow, fast);
      }
    }

    return new String(str);
  }

  private void reverse(char[] str, int start, int end) {
    if (str == null || str.length < 2) {
      return;
    }

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
