// Easy
// Remove given characters in input string, the relative order of other characters should be remained. Return the new string after deletion.

// Assumptions

// The given input string is not null.
// The characters to be removed is given by another string, it is guaranteed to be not null.
// Examples

// input = "abcd", t = "ab", delete all instances of 'a' and 'b', the result is "cd".
  
public class Solution {
  public String remove(String input, String t) {
    char[] str = input.toCharArray();
    Set<Character> chSet = buildSet(t);
    int i = 0;

    for (char ch : str) {
      if (!chSet.contains(ch)) {
        str[i] = ch;
        ++i;
      }
    }

    return new String(str, 0, i);

  }

  private Set<Character> buildSet(String t) {
    Set<Character> set = new HashSet<>();

    for (int i = 0; i < t.length(); ++i) {
      set.add(t.charAt(i));
    }

    return set;
  } 
}
