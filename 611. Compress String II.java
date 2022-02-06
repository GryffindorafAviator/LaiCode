// Hard
// Given a string, 
// replace adjacent, 
// repeated characters with the character followed by the number of repeated occurrences.

// Assumptions
// The string is not null
// The characters used in the original string are guaranteed to be ‘a’ - ‘z’

// Examples
// “abbcccdeee” → “a1b2c3d1e3”

// Solution
public class Solution {
  public String compress(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }

    char[] chArr = input.toCharArray();

    int fast = 0;
    int slow = 0;
    int newLen = 0;
    
    while (fast < chArr.length) {
      int begin = fast;

      while (fast < chArr.length && chArr[fast] == chArr[begin]) {
        fast++;
      }

      chArr[slow] = chArr[begin];
      slow++;

      if (fast - begin == 1) {
        newLen += 2;
      }
      else {
        int len = copyDigits(chArr, slow, fast - begin);

        slow += len;
        newLen += len + 1;
      }
    }

    char[] ans = new char[newLen];

    fast = slow - 1;
    slow = newLen - 1;

    while (fast >= 0) {
      if (Character.isDigit(chArr[fast])) {
        while (fast >= 0 && Character.isDigit(chArr[fast])) {
          ans[slow] = chArr[fast];
          fast--;
          slow--;
        }
      }
      else {
        ans[slow] = '1';
        slow--;
      }

      ans[slow] = chArr[fast];
      slow--;
      fast--;
    }

    return new String(ans);
  }

  private int copyDigits(char[] chArr, int index, int count) {
    int len = 0;

    for (int i = count; i > 0; i /= 10) {
      len++;
      index++;
    }

    for (int i = count; i > 0; i /= 10) {
      index--;
      chArr[index] = (char) ('0' + i % 10);
    }

    return len;
  }
}
// TC: O(n); SC: O(n) 
// The new char array is not necessary therefore SC can be O(1).
