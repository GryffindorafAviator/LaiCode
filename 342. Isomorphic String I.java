// Easy
// Two Strings are called isomorphic if the letters in one String can be remapped to get the second String. 
// Remapping a letter means replacing all occurrences of it with another letter. 
// The ordering of the letters remains unchanged. 
// The mapping is two way and no two letters may map to the same letter, 
// but a letter may map to itself. Determine if two given String are isomorphic.

// Assumptions:
// The two given Strings are not null.
  
// Examples:
// "abca" and "xyzx" are isomorphic since the mapping is 'a' <-> 'x', 'b' <-> 'y', 'c' <-> 'z'.
// "abba" and "cccc" are not isomorphic.
  
// Solution
public class Solution {
  public boolean isomorphic(String source, String target) {
    Map<Character, Character> sToT = new HashMap<>();
    Map<Character, Character> tToS = new HashMap<>();

    int lenS = source.length();
    int lenT = source.length();

    if (lenS != lenT) {
      return false;
    }

    for (int i = 0; i < lenS; i++) {
      char chS = source.charAt(i);
      char chT = target.charAt(i);

      if (sToT.containsKey(chS)) {
        if (sToT.get(chS) != chT) {
          return false;
        }
      }
      else {
        sToT.put(chS, chT);
      }

      if (tToS.containsKey(chT)) {
        if (tToS.get(chT) != chS) {
          return false;
        }
      }
      else {
        tToS.put(chT, chS);
      }
    }

    return true;
  }
}
// TC: O(n); SC: O(n)
