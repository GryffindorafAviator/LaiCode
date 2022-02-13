// Easy
// Find all numbers that appear in both of two sorted arrays (the two arrays are all sorted in ascending order).

// Assumptions
// In each of the two sorted arrays, there could be duplicate numbers.
// Both two arrays are not null.

// Examples
// A = {1, 1, 2, 2, 3}, B = {1, 1, 2, 5, 6}, common numbers are [1, 1, 2]

// Solution 1
public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> common = new ArrayList<>();
    int i = 0;
    int j = 0;

    while (i < A.length && j < B.length) {
      if (A[i] == B[j]) {
        common.add(A[i]);
        i++;
        j++;
      }
      else if (A[i] < B[j]) {
        i++;
      }
      else {
        j++;
      }
    }

    return common;
  }
}
// TC: O(n); SC: O(1)

// Solution 2
public class Solution {
  public List<Integer> common(int[] A, int[] B) {
    List<Integer> common = new ArrayList<>();

    if (A.length == 0 || B.length == 0) {
      return common;
    }

    Map<Integer, Integer> hmA = new HashMap<>();
    Map<Integer, Integer> hmB = new HashMap<>();

    for (int num : A) {
      hmA.put(num, hmA.getOrDefault(num, 0) + 1);
    }

    for (int num : B) {
      hmB.put(num, hmB.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry : hmA.entrySet()) {
      int cnt = 0;

      if (hmB.get(entry.getKey()) != null) {
        cnt = Math.min(hmA.get(entry.getKey()), hmB.get(entry.getKey()));
      }

      for (int i = 0; i < cnt; ++i) {
        common.add(entry.getKey());
      }
    }

    Collections.sort(common);

    return common;
  }
}
// TC: O(nlgn); SC: O(n + m)
