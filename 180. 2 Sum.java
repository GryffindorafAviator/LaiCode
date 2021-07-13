// Easy
// Determine if there exist two elements in a given array, 
// the sum of which is the given target number.

// Assumptions

// The given array is not null and has length of at least 2
// Examples

// A = {1, 2, 3, 4}, target = 5, return true (1 + 4 = 5)

// A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)

// A = {2, 4, 1}, target = 4, return false

// Solution 1
public class Solution {
  public boolean existSum(int[] array, int target) {
    Arrays.sort(array);

    int left = 0;
    int right = array.length - 1;


    while (left < right) {
      if ((array[left] + array[right]) == target) {
        return true;
      }
      else if ((array[left] + array[right]) < target) {
        ++left;
      }
      else {
        --right;
      }
    }

    return false;
  }
}
// TC: O(n), SC: O(1)

// Solution 2
public class Solution {
  public boolean existSum(int[] array, int target) {
    Set<Integer> set = new HashSet<>();

    for (int num : array) {
      if (set.contains(target - num)) {
        return true;
      }

      set.add(num);
    }

    return false;
  }
}
// TC: O(n), SC: O(n)
