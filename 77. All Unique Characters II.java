// Medium
// Determine if the characters of a given string are all unique.

// Assumptions

// We are using ASCII charset, the value of valid characters are from 0 to 255
// The given string is not null
// Examples

// all the characters in "abA+\8" are unique
// "abA+\a88" contains duplicate characters

// Solution 1
public class Solution {
  public boolean allUnique(String word) {
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < word.length(); ++i) {
      char ch = word.charAt(i);

      if (set.contains(ch)) {
        return false;
      }

      set.add(ch);
    } 

    return true;
  }
}

// Solution 2
public class Solution {
  public boolean allUnique(String word) {
    boolean[] booArr = new boolean[256];

    for (int i = 0; i < word.length(); ++i) {
      int index = word.charAt(i);

      if (booArr[index]) {
        return false;
      }

      booArr[index] = true;
    }

    return true;
  }
}
