// Medium
// Given a string, 
// find the longest substring without any repeating characters and return the length of it. 
// The input string is guaranteed to be not null.

// For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", 
// we should return 4 in this case.
  
// Solution

public class Solution {
  public int longest(String input) {
    int maxCnt = 0;

    if (input == null || input.length() == 0) {
      return maxCnt;
    }
    
    HashMap<Character, Integer> hm = new HashMap<>();
    int start = 0;

    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);

      if (hm.containsKey(ch)) {
        maxCnt = Math.max(maxCnt, i - start);
        start = Math.max(start, hm.get(ch) + 1);
      }

      hm.put(ch, i);
    }

    maxCnt = Math.max(maxCnt, input.length() - start);

    return maxCnt;
  }
}

// TC: O(n); SC: O(n)
