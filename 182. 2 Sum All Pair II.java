// Medium
// Find all pairs of elements in a given array that sum to the pair the given target number. 
// Return all the distinct pairs of values.

// Assumptions

// The given array is not null and has length of at least 2
// The order of the values in the pair does not matter
// Examples

// A = {2, 1, 3, 2, 4, 3, 4, 2}, target = 6, return [[2, 4], [3, 3]]

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, Boolean> hm = new HashMap<>();

    for (int num : array) {
      if (hm.containsKey(target - num) && !hm.get(target - num)) {
        result.add(Arrays.asList(num, target - num));
        hm.put(num, true);
        hm.put(target - num, true);
      }

      if (hm.get(num) == null) {
        hm.put(num, false);
      } 
    }

    return result;
  }
}

// TC: O(n), SC: O(n)
