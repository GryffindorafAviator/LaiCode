// Medium
// Determine if a small string is a substring of another large string.

// Return the index of the first occurrence of the small string in the large string.

// Return -1 if the small string is not a substring of the large string.

// Assumptions
// Both large and small are not null
// If small is empty string, 
// return 0
  
// Examples
// “ab” is a substring of “bcabc”, 
// return 2
// “bcd” is not a substring of “bcabc”, 
// return -1
// "" is substring of "abc", 
// return 0
  
// Solution
public class Solution {
  public int strstr(String large, String small) {
    if (small.length() == 0) {
      return 0;
    }

    if (large.length() < small.length()) {
      return -1;
    }

    for (int i = 0; i <= large.length() - small.length(); i++) {
      if (equals(large, small, i)) {
        return i;
      }
    }

    return -1; 
  }

  private boolean equals(String large, String small, int idx) {
    for (int i = 0; i < small.length(); i++) {
      if (small.charAt(i) != large.charAt(idx + i)) {
        return false;
      }
    }

    return true;
  }
}

// TC: O(n^2); SC: O(1)
