// Medium
// Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.

// Assumptions:

// The original string only contains alphabetic characters.
// Both input and pattern are not null.
// Pattern would not contain invalid information like "a0a","0".
// Examples:

// pattern “s11d” matches input “sophisticated” since “11” matches eleven chars “ophisticate”.
  
// Solution 1
public class Solution {
  public boolean match(String input, String pattern) {
    if (input == null && pattern == null) {
      return true;
    }

    return helper(input, pattern, 0, 0);
  }

  private boolean helper(String s, String t, int si, int ti) {
    if (si == s.length() && ti == t.length()) {
      return true;
    }
    
    else if (si >= s.length() || ti >= t.length()) {
      return false;
    }

    else if (t.charAt(ti) > '9') {
      if (t.charAt(ti) == s.charAt(si)) {
        return helper(s, t, si + 1, ti + 1);
      }

      return false;
    }

    else {
      int cnt = 0;

      while (ti < t.length() && '0' <= t.charAt(ti) && t.charAt(ti) <= '9') {
        cnt = cnt * 10 + (t.charAt(ti) - '0');
        ++ti;
      }

      return helper(s, t, si + cnt, ti);
    }
  }
}


// Solution 2
public class Solution {
  public boolean match(String input, String pattern) {
    if (input == null && pattern == null) {
      return true;
    }

    return helper(input, pattern, 0, 0);
  }

  private boolean helper(String s, String t, int si, int ti) {
    if (si == s.length() && ti == t.length()) {
      return true;
    }
    
    if (si >= s.length() || ti >= t.length()) {
      return false;
    }

    if (t.charAt(ti) > '9') {
      if (t.charAt(ti) == s.charAt(si)) {
        return helper(s, t, si + 1, ti + 1);
      }

      return false;
    }

    int cnt = 0;

    while (ti < t.length() && '0' <= t.charAt(ti) && t.charAt(ti) <= '9') {
      cnt = cnt * 10 + (t.charAt(ti) - '0');
      ++ti;
    }
    
    return helper(s, t, si + cnt, ti);
  }
}
