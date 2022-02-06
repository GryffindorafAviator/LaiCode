// Hard
// Given a string in compressed form, 
// decompress it to the original string. 
// The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

// Assumptions
// The string is not null
// The characters used in the original string are guaranteed to be ‘a’ - ‘z’
// There are no adjacent repeated characters with length > 9

// Examples
// “a1c0b2c4” → “abbcccc”

// Solution 1
public class Solution {
  public String decompress(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      i++;

      int cnt = input.charAt(i) - '0';

      for (int j = 0; j < cnt; j++) {
        sb.append(ch);
      }
    }

    return sb.toString();
  }
}
// TC: O(n); SC: O(n)

// Solution 2
public class Solution {
  public String decompress(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }

    char[] chArr = input.toCharArray();

    return decoderLong(chArr, decoderShort(chArr));
  }

  private int[] decoderShort(char[] chArr) {
    int end = 0;
    int cnt = 0;

    for (int i = 0; i < chArr.length; i += 2) {
      int di = getDigit(chArr[i + 1]);

      if (0 <= di && di <= 2) {
        for (int j = 0; j < di; j++) {
          chArr[end] = chArr[i];
          end++; 
          cnt++;
        } 
      }
      else {
        cnt += di;

        chArr[end] = chArr[i];
        end++;

        chArr[end] = chArr[i + 1];
        end++;
      }
    }

    return new int[] {end, cnt};
  }

  private String decoderLong(char[] input, int[] cnt) {
    int shortLen = cnt[0];
    int totalLen = cnt[1];

    char[] result = new char[totalLen];

    int end = totalLen - 1;

    for (int i = shortLen - 1; i >= 0; i--) {
      int di = getDigit(input[i]);

      if (2 < di && di <= 9) {
        i--;

        for (int j = 0; j < di; j++) {
          result[end] = input[i];
          end--;
        }
      }
      else {
        result[end] = input[i];
        end--;
      }
    }

    return new String(result);
  }

  private int getDigit(char di) {
    return di - '0';
  }
}
// TC: O(n); SC: O(1)
// Here we heve simulated an inplace method. 
// Therefore eventhough we used an extra char array result to store the result, 
// the SC is still O(1).
