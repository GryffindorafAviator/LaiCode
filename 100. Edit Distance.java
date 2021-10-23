// Medium
// Given two strings of alphanumeric characters, 
// determine the minimum number of Replace, 
// Delete, 
// and Insert operations needed to transform one string into the other.

// Assumptions
// Both strings are not null
  
// Examples
// string one: “sigh”, string two : “asith”
// the edit distance between one and two is 2 (one insert “a” at front then replace “g” with “t”).
  
// Solution

public class Solution {
  public int editDistance(String one, String two) {
    if (one.length() == 0 || two.length() == 0) {
      return one.length() == 0 ? two.length() : one.length();
    }

    int[][] dis = new int[one.length() + 1][two.length() + 1];
    
    for (int i = 0; i <= one.length(); ++i) {
      for (int j = 0; j <= two.length(); ++j) {
        if (i == 0) {
          dis[i][j] = j;
        }
        else if (j == 0) {
          dis[i][j] = i;
        }
        else if (one.charAt(i - 1) == two.charAt(j - 1)) {
          dis[i][j] = dis[i - 1][j - 1];
        }
        else {
          dis[i][j] = Math.min(dis[i - 1][j], dis[i][j - 1]) + 1;
          dis[i][j] = Math.min(dis[i][j], dis[i - 1][j - 1] + 1);
        }
      }
    }

    return dis[one.length()][two.length()];
  }
}

// TC: O(n^2); SC: O(n^2)
