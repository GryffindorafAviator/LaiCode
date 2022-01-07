// Medium
// Find all common elements in 3 sorted arrays.

// Assumptions
// The 3 given sorted arrays are not null
// There could be duplicate elements in each of the arrays

// Examples
// A = {1, 2, 2, 3}, B = {2, 2, 3, 5}, C = {2, 2, 4}, 
// the common elements are [2, 2]

// Solution
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
