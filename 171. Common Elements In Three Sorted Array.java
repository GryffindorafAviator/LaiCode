// Medium
// Find all common elements in 3 sorted arrays.

// Assumptions
// The 3 given sorted arrays are not null
// There could be duplicate elements in each of the arrays

// Examples
// A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, 
// the common elements are [2, 2]

// Solution 1
public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> ans = new ArrayList<>();

    if (a == null || b == null || c == null) {
      return ans;
    }

    if (a.length == 0 || b.length == 0 || c.length == 0) {
      return ans;
    }

    int ai = 0;
    int bi = 0;
    int ci = 0;

    while (ai < a.length && bi < b.length && ci < c.length) {
      if (a[ai] == b[bi] && b[bi] == c[ci]) {
        ans.add(a[ai]);
        ai++;
        bi++;
        ci++;
      }
      else if (a[ai] < b[bi] && a[ai] < c[ci]) {
        ai++;
      }
      else if (b[bi] < a[ai] && b[bi] < c[ci]) {
        bi++;
      }
      else if (c[ci] < a[ai] && c[ci] < b[bi]) {
        ci++;
      }
      else if (a[ai] == b[bi] && b[bi] < c[ci]) {
        ai++;
        bi++;
      }
      else if (a[ai] == c[ci] && c[ci] < b[bi]) {
        ai++;
        ci++;
      }
      else {
        bi++;
        ci++;
      }
    }

    return ans;
  }
}
// TC: O(a.len + b.len + c.len); SC: O(1)

// Solution 2
public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    List<Integer> ans = new ArrayList<>();

    if (a == null || b == null || c == null) {
      return ans;
    }

    if (a.length == 0 || b.length == 0 || c.length == 0) {
      return ans;
    }

    int ai = 0;
    int bi = 0;
    int ci = 0;

    while (ai < a.length && bi < b.length && ci < c.length) {
      if (a[ai] == b[bi] && b[bi] == c[ci]) {
        ans.add(a[ai]);
        ai++;
        bi++;
        ci++;
      }
      else if (a[ai] <= b[bi] && a[ai] <= c[ci]) {
        ai++;
      }
      else if (b[bi] <= a[ai] && b[bi] <= c[ci]) {
        bi++;
      }
      else {
        ci++;
      }
    }

    return ans;
  }
}
// TC: O(a.len + b.len + c.len); SC: O(1)

// Solution 3
public class Solution {
  public List<Integer> common(int[] a, int[] b, int[] c) {
    if (a == null || b == null || c == null) {
      return null;
    }

    int lenA = a.length;
    int lenB = b.length;
    int lenC = c.length;
    List<Integer> ans = new ArrayList<>();

    if (lenA == 0 || lenB == 0 || lenC == 0) {
      return ans;
    }

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < lenA && j < lenB && k < lenC) {
      if (a[i] == b[j] && a[i] == c[k]) {
        ans.add(a[i]);
        i++;
        j++;
        k++;
      }
      else if (a[i] < b[j] && a[i] < c[k]) {
        i++;
      }
      else if (b[j] < a[i] && b[j] < c[k]) {
        j++;
      }
      else if (c[k] < b[j] && c[k] < a[i]) {
        k++;
      }
      else if (a[i] > b[j] && a[i] > c[k]) {
        j++;
        k++;
      }
      else if (b[j] > a[i] && b[j] > c[k]) {
        i++;
        k++;
      }
      else if (c[k] > b[j] && c[k] > a[i]) {
        i++;
        j++;
      }
    }

    return ans;
  }
}
// TC: O(a.len + b.len + c.len); SC: O(1)
