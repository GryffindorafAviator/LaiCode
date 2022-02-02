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

// Solution
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
