// Medium
// Given a string, 
// find the longest substring without any repeating characters and return the length of it. 
// The input string is guaranteed to be not null.

// For example, the longest substring without repeating letters for "bcdfbd" is "bcdf", 
// we should return 4 in this case.
  
// Solution 1

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

// Solution 2
public class Solution {
  public int longest(String input) {
    int maxCnt = 0;

    if (input == null || input.length() == 0) {
      return maxCnt;
    }

    int fast = 0;
    int slow = 0;
    Set<Character> set = new HashSet<>();

    while (fast < input.length()) {
      char chF = input.charAt(fast);

      if (set.contains(chF)) {
        char chS = input.charAt(slow);

        set.remove(chS);
        slow++;
      }
      else {
        set.add(chF);
        maxCnt = Math.max(maxCnt, set.size());
        fast++;
      }
    }

    return maxCnt;
  }
}

// TC: O(n^2); SC: O(n)
