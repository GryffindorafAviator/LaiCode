// Easy
// Determine if the characters of a given string are all unique.

// Assumptions
// The only set of possible characters used in the string are 'a' - 'z', 
// the 26 lower case letters.
// The given string is not null.
  
// Examples
// the characters used in "abcd" are unique
// the characters used in "aba" are not unique

// Solution
public class Solution {
  public boolean allUnique(String word) {
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);

      if (set.contains(ch)) {
        return false;
      }

      set.add(ch);
    }

    return true;
  }
}
// TC: O(n); SC: O(n)
