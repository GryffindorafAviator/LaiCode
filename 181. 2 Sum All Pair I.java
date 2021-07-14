// Medium
// Find all pairs of elements in a given array that sum to the given target number. 
// Return all the pairs of indices.

// Assumptions

// The given array is not null and has length of at least 2.

// Examples

// A = {1, 3, 2, 4}, target = 5, return [[0, 3], [1, 2]]

// A = {1, 2, 2, 4}, target = 6, return [[1, 3], [2, 3]]

public class Solution {
  public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Map<Integer, List<Integer>> hm = new HashMap<>();

    for (int i = 0; i < array.length; ++i) {
      if (hm.containsKey(target - array[i])) {
        for (Integer index : hm.get(target - array[i])) {
          result.add(Arrays.asList(i, index));
        }
      }

      if (hm.get(array[i]) == null) {
        List<Integer> temp = new ArrayList<>();
        temp.add(i);
        hm.put(array[i], temp);
      }
      else {
        hm.get(array[i]).add(i);
      }
    }

    return result;
  }
}

// TC: O(n^2), SC: O(n^2)
