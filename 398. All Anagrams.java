// Medium
// Find all occurrence of anagrams of a given string s in a given string l. 
// Return the list of starting indices.

// Assumptions
// sh is not null or empty.
// lo is not null.
  
// Examples
// l = "abcbac", 
// s = "ab", 
// return [0, 3] since the substring with length 2 starting from index 0/3 are all anagrams of "ab" ("ab", "ba").
  
// Solution
public class Solution {
  public List<Integer> allAnagrams(String sh, String lo) {
    List<Integer> ans = new ArrayList<>();

    if (lo.length() == 0 || sh.length() > lo.length()) {
      return ans;
    }

    Map<Character, Integer> map = countMap(sh);
    int match = 0;

    for (int i = 0; i < lo.length(); ++i) {
      char ch = lo.charAt(i);
      Integer cnt = map.get(ch);

      if (cnt != null) {
        map.put(ch, cnt - 1);

        if (cnt == 1) {
          match++;
        }
      }

      if (i >= sh.length()) {
        ch = lo.charAt(i - sh.length());
        cnt = map.get(ch);

        if (cnt != null) {
          map.put(ch, cnt + 1);

          if (cnt == 0) {
            match--;
          }
        }
      }

      if (match == map.size()) {
        ans.add(i - sh.length() + 1);
      }
    }

    return ans;
  }

  private Map<Character, Integer> countMap(String sh) {
    Map<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < sh.length(); ++i) {
      char ch = sh.charAt(i);

      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    return map;
  }
}
// TC: O(n); SC: O(n)
